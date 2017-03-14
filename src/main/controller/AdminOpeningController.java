package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Information;
import model.Shop;

import java.io.IOException;

public class AdminOpeningController {

	@FXML
	private AnchorPane center;
	@FXML
	private ComboBox opDay, clDay, opH, clH, opMn, clMn;
	@FXML
	private TextField commentary;

	private Shop shop;

	public void init(Shop shop) {
		this.shop = shop;
		Information info = this.shop.getInfo();
		opDay.setPromptText(info.getOpenDay());
		clDay.setPromptText(info.getCloseDay());
		opH.setPromptText(info.getOpenHour());
		clH.setPromptText(info.getCloseHour());
		opMn.setPromptText(info.getOpenMin());
		clMn.setPromptText(info.getCloseMin());
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

	public void setModifiedCommentary() {
		this.shop.getInfo().setCommentary(commentary.getText());
	}

	public void validChanges() {

		Information info = this.shop.getInfo();
		info.setOpenDay(opDay.getValue().toString());
		info.setCloseDay(clDay.getValue().toString());
		info.setOpenHour(opH.getValue().toString());
		info.setCloseHour(clH.getValue().toString());
		info.setOpenMin(opMn.getValue().toString());
		info.setCloseMin(clMn.getValue().toString());
		setModifiedCommentary();
	}
}
