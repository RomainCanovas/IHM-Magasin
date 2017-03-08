import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.Shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ShopController implements Initializable {

	@FXML
	private Button reception, sales, products, news, company, team;
	@FXML
	private AnchorPane center;
	private Shop shop;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//this.shop = new Shop();

		boolean condButton = this.reception != null && this.sales != null && this.products != null && this.news != null && this.company != null && this.team != null;
		boolean condScrollPane = this.center != null;
		assert condButton && condScrollPane : "Buttons were not injected: check your FXML file 'Magasin.fxml'.";

		this.actionReception(new ActionEvent());
	}

	public void actionReception(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("views/Accueil.fxml"));
			Parent pane = loader.load();
			((ReceptionController) loader.getController()).init();

			if (this.center.getChildren().size() == 0)
				this.center.getChildren().add(pane);
			else
				this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			System.err.println("merde");
			System.exit(0);
		}
	}

	public void actionSales(ActionEvent actionEvent) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("views/Promotion.fxml"));
			Parent pane = loader.load();
			((SalesController) loader.getController()).init();

			if (this.center.getChildren().size() == 0)
				this.center.getChildren().add(pane);
			else
				this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionProducts(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("views/Produit.fxml"));
			Parent pane = loader.load();
			((ProductController) loader.getController()).init();

			if (this.center.getChildren().size() == 0)
				this.center.getChildren().add(pane);
			else
				this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionNews(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("views/Nouveautes.fxml"));
			Parent pane = loader.load();
			((NewsController) loader.getController()).init();

			if (this.center.getChildren().size() == 0)
				this.center.getChildren().add(pane);
			else
				this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionCompany(ActionEvent actionEvent) {
		//Fixme rebalancer le gens sur la page de l'enseigne
	}

	public void actionTeam(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("views/Equipe.fxml"));
			Parent pane = loader.load();
			((TeamController) loader.getController()).init();

			if (this.center.getChildren().size() == 0)
				this.center.getChildren().add(pane);
			else
				this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
