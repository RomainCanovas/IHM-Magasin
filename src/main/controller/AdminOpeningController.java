package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Information;
import model.Shop;

import java.io.IOException;

public class AdminOpeningController {

    @FXML
    private AnchorPane center;
    @FXML
    private ComboBox<String> opDay;
    @FXML
    private ComboBox<String> clDay;
    @FXML
    private ComboBox<String> opH;
    @FXML
    private ComboBox<String> clH;
    @FXML
    private ComboBox<String> opMn;
    @FXML
    private ComboBox<String> clMn;
    @FXML
    private TextField commentary;

    private Shop shop;

    public void init(Shop shop) {
        this.shop = shop;
        Information info = this.shop.getInfo();
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
            ((Pane) this.center.getParent()).getChildren().set(0, pane);

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public void check(KeyEvent keyEvent) {
        if (commentary.getLength() >= 37) {
            commentary.setText(commentary.getText().substring(0, 37));
            init(this.shop);
        }
    }

    private void setModifiedCommentary() {
        this.shop.getInfo().setCommentary(commentary.getText());
    }

    public void setModifiedOpening() {
        Information info = this.shop.getInfo();
        info.setOpenDay(opDay.getValue());
        info.setCloseDay(clDay.getValue());
        info.setOpenHour(opH.getValue());
        info.setCloseHour(clH.getValue());
        info.setOpenMin(opMn.getValue());
        info.setCloseMin(clMn.getValue());
    }

    public void validChanges() {

        setModifiedOpening();
        setModifiedCommentary();
    }
}
