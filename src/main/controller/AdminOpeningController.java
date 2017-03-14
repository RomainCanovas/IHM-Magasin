package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Information;
import model.Shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by canor on 13/03/2017.
 */
public class AdminOpeningController implements Initializable {

    @FXML
    AnchorPane center;
    @FXML
    ComboBox opDay, clDay, opH, clH, opMn, clMn;
    @FXML
    TextField commentary;

    private Shop shop;
    private Information info;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void init(Shop shop) {
        this.shop = shop;
        info=this.shop.getInfo();
        opDay.setPromptText(info.getOpenDay());
        opDay.setValue(info.getOpenDay());
        clDay.setPromptText(info.getCloseDay());
        clDay.setValue(info.getCloseDay());
        opH.setPromptText(info.getOpenHour());
        opH.setValue(info.getOpenHour());
        clH.setPromptText(info.getCloseHour());
        clH.setValue(info.getCloseHour());
        opMn.setPromptText(info.getOpenMin());
        opMn.setValue(info.getOpenMin());
        clMn.setPromptText(info.getCloseMin());
        clMn.setValue(info.getCloseMin());
        commentary.setText(info.getCommentary());
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


    public void setModifiedCommentary() {
        this.info.setCommentary(commentary.getText());
    }


    public void validChanges() {
        this.info.setOpenDay(opDay.getValue().toString());
        this.info.setCloseDay(clDay.getValue().toString());
        this.info.setOpenHour(opH.getValue().toString());
        this.info.setCloseHour(clH.getValue().toString());
        this.info.setOpenMin(opMn.getValue().toString());
        this.info.setCloseMin(clMn.getValue().toString());
        setModifiedCommentary();
    }
}
