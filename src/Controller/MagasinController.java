package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MagasinController implements Initializable {

	@FXML
	private Button reception, sales, products, information, company, team;
	@FXML
	private ScrollPane center;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		boolean condButton = this.reception != null && this.sales != null && this.products != null && this.information != null && this.company != null && this.team != null;
		boolean condScrollPane = this.center != null;
		assert condButton && condScrollPane : "Buttons were not injected: check your FXML file 'Magasin.fxml'.";

		try {
			center = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void actionReception(ActionEvent actionEvent) {
		try {
			center = FXMLLoader.load(getClass().getResource("Accueil.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionSales(ActionEvent actionEvent) {
		try {
			center = FXMLLoader.load(getClass().getResource("Promotion.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionProducts(ActionEvent actionEvent) {
		try {
			center = FXMLLoader.load(getClass().getResource("Produit.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionInformation(ActionEvent actionEvent) {
		try {
			center = FXMLLoader.load(getClass().getResource("Information.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionCompany(ActionEvent actionEvent) {
		try {
			center = FXMLLoader.load(getClass().getResource("Enseigne.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionTeam(ActionEvent actionEvent) {
		try {
			center = FXMLLoader.load(getClass().getResource("Equipe.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
