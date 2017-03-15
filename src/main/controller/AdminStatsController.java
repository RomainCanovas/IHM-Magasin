package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Shop;

import java.io.IOException;

public class AdminStatsController{

	@FXML
	private AnchorPane center;

	private Shop shop;

	public void init(Shop shop) {
		this.shop = shop;
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

	public void actionPS() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/adminstatsPS.fxml"));
			Parent pane = loader.load();
			((AdminStatsPSController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionPR() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/adminstatsPR.fxml"));
			Parent pane = loader.load();
			((AdminStatsPRController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionCA() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/adminStatsCA.fxml"));
			Parent pane = loader.load();
			((AdminStatsCAController) loader.getController()).init(this.shop);

			((Pane) this.center.getParent()).getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void actionFreq() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminStatsFrequentation.fxml"));
			Parent pane = loader.load();
			((AdminStatsFreqController) loader.getController()).init(this.shop);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
