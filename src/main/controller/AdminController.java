package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import model.Shop;

import java.io.IOException;

public class AdminController {

	@FXML
	public AnchorPane center;

	private Shop shop;

	public void init(Shop shop) {
		this.shop = shop;
	}

	public void actionAdminAccess() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminAccess.fxml"));
			Parent pane = loader.load();
			((AdminAccesController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminDescription() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminDescription.fxml"));
			Parent pane = loader.load();
			((AdminDescriptionController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminOpening() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminOpeningHours.fxml"));
			Parent pane = loader.load();
			((AdminOpeningController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminContact() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminContact.fxml"));
			Parent pane = loader.load();
			((AdminContactController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionStats() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminStats.fxml"));
			Parent pane = loader.load();
			((AdminStatsController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void products() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminProduct.fxml"));
			Parent pane = loader.load();
			((AdminProductController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

