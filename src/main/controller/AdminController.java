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
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminDescription.fxml"));
			Parent pane = loader.load();
			((AdminDescriptionController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminOpening() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminOpeningHours.fxml"));
			Parent pane = loader.load();
			((AdminOpeningController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdminContact() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminContact.fxml"));
			Parent pane = loader.load();
			((AdminContactController) loader.getController()).init(this.info);
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionStats() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminStats.fxml"));
			Parent pane = loader.load();
			((AdminStatsController) loader.getController()).init();
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

