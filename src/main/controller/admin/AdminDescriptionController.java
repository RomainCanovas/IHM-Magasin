package controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Shop;

import java.io.IOException;

public class AdminDescriptionController {

	@FXML
	private TextArea desc;
	@FXML
	private AnchorPane center;

	private Shop shop;

	public void init(Shop shop) {
		this.shop = shop;
		desc.setText(this.shop.getInfo().getDesc());
	}

	public void check() {
		if (desc.getLength() >= 301) {
			desc.setText(desc.getText().substring(0, 300));
		}
	}

	private void setModifiedDescription() {
		this.shop.getInfo().setDesc(desc.getText());
	}

	public void validChanges() {
		setModifiedDescription();
	}

	public void actionAdmin() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init(this.shop);
			((Pane) this.center.getParent()).getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
