package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ShopController implements Initializable {

	@FXML
	private Button reception, sales, products, news, company, team;
	@FXML
	private MenuItem access;
	@FXML
	private AnchorPane center;
	private Shop shop;

	@Override
	public void initialize(URL location, ResourceBundle resources) {


		this.shop = this.createData();

		boolean condButton = this.reception != null && this.sales != null && this.products != null && this.news != null && this.company != null && this.team != null;
		boolean condScrollPane = this.center != null;
		assert condButton && condScrollPane : "Buttons were not injected: check your FXML file 'Magasin.fxml'.";

		this.actionReception(new ActionEvent());
	}

	public void actionReception(ActionEvent actionEvent) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Accueil.fxml"));
			Parent pane = loader.load();
			((ReceptionController) loader.getController()).init(this.shop.getInfo());

			if (this.center.getChildren().size() == 0)
				this.center.getChildren().add(pane);
			else
				this.center.getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void actionSales(ActionEvent actionEvent) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
			Parent pane = loader.load();
			((ProductController) loader.getController()).init(this.shop.getInventory(), "PROMOTIONS");
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void actionProducts(ActionEvent actionEvent) {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
			Parent pane = loader.load();
			((ProductController) loader.getController()).init(this.shop.getInventory(),"CATEGORIES");
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void actionNews(ActionEvent actionEvent) {
	}

	public void actionCompany(ActionEvent actionEvent) {
		//Fixme rebalancer le gens sur la page de l'enseigne
	}

	public void actionTeam(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Equipe.fxml"));
			Parent pane = loader.load();
			((TeamController) loader.getController()).initEmployee(this.shop.getTeam());
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void actionAdmin(ActionEvent actionEvent) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Admin.fxml"));
			Parent pane = loader.load();
			((AdminController) loader.getController()).init();
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Shop createData() {
		Information info = new Information("+33 79 35 01 21", "tbth@capsophia.com", "Lundi - Vendredi",
				"8H - 20H", " the place to be tada", "En face des escaliers", 2);

		List<Employee> workers = Arrays.asList(
				new Employee("Maurice", "Lopez", "Directeur", "image/directeur.png"),
				new Employee("Maurice", "Lopez", "Directeur", "image/directeur.png"),
				new Employee("Maurice", "Lopez", "Directeur", "image/directeur.png"),
				new Employee("Philip", "Moris", "Vendeur", "image/vendeur.jpg"),
				new Employee("Philip", "Moris", "Vendeur", "image/vendeur.jpg"),
				new Employee("Philip", "Moris", "Vendeur", "image/vendeur.jpg"),
				new Employee("Florian", "Guillaume", "Conseiller", "image/conseiller.png")
		);

		List<List<Product>> products = Arrays.asList(
				Arrays.asList(
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25)

				),
				Arrays.asList(
						new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit qui est cher !", 250),
						new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit qui est cher !", 250),
						new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit qui est cher !", 250)
				),
				Arrays.asList(
						new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 250),
						new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 250),
						new Product("produit3", "produit/produit3.jpg", "Ce produit est un produitr !", 2500)
				)
		);

		Map<String, List<Product>> map = new HashMap<>();

		for (int i = 0; i < products.size(); i++)
			map.put("Categorie " + i, products.get(i));

		Inventory inventory = new Inventory(map);

		return new Shop(info, workers, inventory);
	}
}
