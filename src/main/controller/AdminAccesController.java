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


public class AdminAccesController implements Initializable {

    @FXML
    ComboBox comboBox;
	@FXML
	TextField clue;
	@FXML
	AnchorPane center;

	private Information info;
	private Shop shop;

    private String floor;

    public void init(Information info) {
        this.info = info;
        floor=this.info.getFloor();
        comboBox.setPromptText(floor);
		comboBox.setValue(floor);
        clue.setText(this.info.getClue());
        }


	public void init(Shop s) {
		this.info = s.getInfo();
		this.shop = s;
		clue.setText(this.info.getClue());
        comboBox.setPromptText(info.getFloor());
        comboBox.setValue(info.getFloor());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}


	public void setModifiedClue() {
		this.info.setClue(clue.getText());
	}

    public void validChanges(){
        this.info.setFloor(comboBox.getValue().toString());
        setModifiedClue();
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
