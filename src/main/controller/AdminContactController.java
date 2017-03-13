package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Information;

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

    private Information info;


    public void init(Information info) {
        this.info = info;
        phone.setText(this.info.getPhone());
        mail.setText(this.info.getEmail());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setModifiedPhone() {
        this.info.setPhone(phone.getText());
    }

    public void setModifiedMail() {
        this.info.setEmail(mail.getText());
    }


    public void validChanges(ActionEvent actionEvent){
        setModifiedPhone();
        setModifiedMail();
    }

    public void actionAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/admin.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.info);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
