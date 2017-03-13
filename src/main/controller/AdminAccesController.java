package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Information;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class AdminAccesController implements Initializable {

    @FXML
    TextField clue;
    @FXML
    AnchorPane center;

    private Information info;

    public void init(Information info) {
        this.info = info;
        clue.setText(this.info.getClue());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void setFloor0() {
        this.info.setFloor(0);
    }

    public void setFloor1() {
        this.info.setFloor(1);
    }

    public void setFloor2() {
        this.info.setFloor(2);
    }

    public void setModifiedClue() {
        this.info.setClue(clue.getText());
    }


    public void keyListenerAdmin(KeyEvent event) {
            if (event.getEventType() == KeyEvent.KEY_PRESSED && event.getCode() == KeyCode.ENTER) {
            setModifiedClue();
            }
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
