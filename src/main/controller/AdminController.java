package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import model.Information;

import java.io.IOException;

/**
 * Created by canor on 10/03/2017.
 */
public class AdminController {

	@FXML
	public AnchorPane center;
	private Information info;


	public void init(Information info) {
		this.info = info;
	}

	public void actionAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Admin.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminAccess() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminAccess.fxml"));
			Parent pane = loader.load();
			((AdminAccesController) loader.getController()).init(this.info);
			((AnchorPane) this.center.getParent()).getChildren().set(0, pane); //fixme sa serait bien de ne pas empiler les panes mais plutot de les remplacer
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminDescription() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminDescription.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminOpening() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminOpeningHours.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminPhoneAndMail() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminPhoneAndMail.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void HomeStats() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminStats.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void DoStats() {

	}

}

