package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by canor on 13/03/2017.
 */
public class AdminContactController implements Initializable {

    @FXML
    TextField phone;
    @FXML
    TextField mail;
    @FXML
    AnchorPane center;

    private Shop shop;


    public void init(Shop shop) {
        this.shop = shop;
        phone.setText(this.shop.getInfo().getPhone());
        mail.setText(this.shop.getInfo().getEmail());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setModifiedPhone() {
        this.shop.getInfo().setPhone(phone.getText());
    }

    public void setModifiedMail() {
        this.shop.getInfo().setEmail(mail.getText());
    }


    public void validChanges(ActionEvent actionEvent){
        setModifiedPhone();
        setModifiedMail();
    }

    public void actionAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/admin.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.shop);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
