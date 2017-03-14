package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Shop;

import java.io.IOException;

public class AdminContactController {

    @FXML
    private TextField phone;
    @FXML
    private TextField mail;
    @FXML
    private AnchorPane center;

    private Shop shop;

    public void init(Shop shop) {
        this.shop = shop;
        phone.setText(this.shop.getInfo().getPhone());
        mail.setText(this.shop.getInfo().getEmail());
    }

    private void setModifiedChanges() {
        this.shop.getInfo().setEmail(mail.getText());
        if (phone.getText().matches("[0-9]*")) {
            if (phone.getLength() == 2) {
                this.shop.getInfo().setPhone(phone.getText());
            }
        }
    }

    public void check(KeyEvent keyEvent) {
            if (phone.getLength() >= 3) {
                phone.setText(phone.getText().substring(0, 2));
            }
            if (mail.getLength() >= 16) {
                mail.setText(mail.getText().substring(0, 15));
        }
    }

    public void validChanges() {
        setModifiedChanges();
    }

    public void actionAdmin() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/admin.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.shop);
            ((Pane) this.center.getParent()).getChildren().set(0, pane);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
