package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Shop;

import java.io.IOException;

public class AdminAccesController {

	@FXML
	private ComboBox<String> comboBox;
	@FXML
	private TextField clue;
	@FXML
	private AnchorPane center;

	private Shop shop;

	public void init(Shop s) {
		this.shop = s;
		clue.setText(this.shop.getInfo().getClue());
		comboBox.setPromptText(this.shop.getInfo().getFloor());
        comboBox.setValue(this.shop.getInfo().getFloor());
    }

	private void setModifiedClue() {
		this.shop.getInfo().setClue(clue.getText());
	}

	public void validChanges() {
		this.shop.getInfo().setFloor(comboBox.getValue());
		setModifiedClue();
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
