package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

public class ShopController implements Initializable {
	@FXML
	public TextField search;
	@FXML
	private AnchorPane center;
	private Shop shop;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.shop = this.createData();
		this.actionReception();
	}

	public void actionReception() {

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

	public void actionSales() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
			Parent pane = loader.load();
			((ProductController) loader.getController()).init(this.shop.getInventory(), "PROMOTIONS");
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public void actionProducts() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
			Parent pane = loader.load();
			((ProductController) loader.getController()).init(this.shop.getInventory(), "CATEGORIES");
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void actionNews() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
			Parent pane = loader.load();
			((ProductController) loader.getController()).init(this.shop.getInventory(), "NOUVEAUTES");
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public void actionCompany() {
		//Todo rebalancer le gens sur la page de l'enseigne
	}

	public void actionTeam() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Equipe.fxml"));
			Parent pane = loader.load();
			((TeamController) loader.getController()).initEmployee(this.shop.getTeam());
			this.center.getChildren().set(0, pane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void keyListenerAdmin(KeyEvent event) {
		try {

			if (event.getEventType() == KeyEvent.KEY_PRESSED && event.getCode() == KeyCode.A) {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/admin.fxml"));
				Parent pane = loader.load();
				((AdminController) loader.getController()).init(this.shop);
				this.center.getChildren().set(0, pane);

			}
		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	private Shop createData() {
		Information info = new Information("21", "tbth", "Lundi - Vendredi",
				"8H - 20H", "Trouver l'inspi pour une description", "En face des escaliers", 2);

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
						new Product("produit26", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25),
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit qui est bien !", 25)

				),
				Arrays.asList(
						new Product("produit26", "produit/produit2.jpg", "Ce produit est un produit qui est cher mais qui est bien, il est quand même relativement cher !", 250),
						new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit qui est cher !", 250),
						new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit qui est cher !", 250)
				),
				Arrays.asList(
						new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 250),
						new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 250),
						new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 2500)
				),
				Arrays.asList(
						new Product("produit1", "produit/produit1.jpg", "Ce produit est un produit !", 250),
						new Product("produit2", "produit/produit2.jpg", "Ce produit est un produit !", 250),
						new Product("produit3", "produit/produit3.jpg", "Ce produit est un produit !", 2500)
				)
		);

		Map<String, List<Product>> map = new HashMap<>();

		for (int i = 0; i < products.size(); i++)
			map.put("Categorie " + i, products.get(i));

		Inventory inventory = new Inventory(map);

		return new Shop(info, workers, inventory);
	}

	public void searchCall() {

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Produit.fxml"));
			Parent pane = loader.load();
			((ProductController) loader.getController()).init(this.shop.getInventory(), this.search.getText().toUpperCase());
			this.center.getChildren().set(0, pane);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
