package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import model.Shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by canor on 13/03/2017.
 */
public class AdminDescriptionController implements Initializable {

    @FXML
    TextArea desc;
    @FXML
    AnchorPane center;


    private Shop shop;

    public void init(Shop shop) {
        this.shop = shop;
        desc.setText(this.shop.getInfo().getDesc());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void setModifiedDescription() {
        this.shop.getInfo().setDesc(desc.getText());
    }

    public void validChanges(ActionEvent actionEvent){
        setModifiedDescription();

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
