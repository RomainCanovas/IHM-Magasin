package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.Inventory;
import model.Product;
import model.Shop;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AdminProductController implements Initializable {

	private static final int MAX_SIZE = 95;
	private static final int MAX_COLUMN = 8;

	@FXML
	public TextField searchBar;
	@FXML
	private AnchorPane center;
	@FXML
	private AnchorPane tricky;
	@FXML
	private RadioButton add;
	@FXML
	private RadioButton news;
	@FXML
	private RadioButton modification;
	@FXML
	private RadioButton remove;
	@FXML
	private GridPane gridPane;
	private AdminProductChoiceController trickyController;
	private AdminNewsController dateController;
	private boolean setModification;
	private boolean setRemove;
	private boolean setAdd;
	private boolean setNews; //Todo

	private Shop shop;
	private List<Product> currentProducts;
	private List<Product> displayedProducts;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ToggleGroup group = new ToggleGroup();
		this.add.setToggleGroup(group);
		this.remove.setToggleGroup(group);
		this.news.setToggleGroup(group);
		this.modification.setToggleGroup(group);
		this.gridPane.setVgap(2);
		this.gridPane.setHgap(2);
	}

	public void init(Shop shop) {
		this.shop = shop;
		this.currentProducts = new ArrayList<>();
		Inventory inventory = shop.getInventory();
		for (Product product : inventory.getAll())
			product.setSelected(false);

		this.initProduct(inventory.getAll());
	}

	private void initProduct(List<Product> products) { // 786 252

		this.displayedProducts = products;

		if (this.gridPane.getChildren().size() > 0)
			this.gridPane.getChildren().removeAll(this.gridPane.getChildren());

		this.initSize(products.size() + 1, MAX_COLUMN);

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			ImageView view = new ImageView(p.getPicture());
			view.setFitWidth(MAX_SIZE);
			view.setFitHeight(MAX_SIZE);
			Zone zone = new Zone(p.getName(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, view, MAX_SIZE);
			zone.setAdmin(p);
			this.gridPane.add(zone, 1 + i % MAX_COLUMN, i / MAX_COLUMN);
		}
	}

	private void initSize(int maxColumn, int size) {

		for (int i = 0; i < maxColumn + 1; i++)
			this.gridPane.getColumnConstraints().add(new ColumnConstraints());
		for (int i = 0; i < size / maxColumn; i++)
			this.gridPane.getRowConstraints().add(new RowConstraints());

	}

	public void newsSelection() {
		this.reInit();

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminNews.fxml"));
			Parent pane = loader.load();
			this.dateController = loader.getController();
			this.tricky.getChildren().add(pane);

		} catch (IOException e) {

			e.printStackTrace();

		}

		this.setNews = true;
	}

	public void modificationSelection() {

		this.reInit();

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/TrickyController.fxml"));
			Parent pane = loader.load();
			this.trickyController = loader.getController();
			this.tricky.getChildren().add(pane);

		} catch (IOException e) {

			e.printStackTrace();

		}

		this.initProduct(this.shop.getInventory().getShown());
		this.currentProducts = this.shop.getInventory().getShown();
		this.setModification = true;
	}

	public void removeSelection() {
		this.reInit();
		this.initProduct(this.shop.getInventory().getShown());
		this.currentProducts = this.shop.getInventory().getShown();
		this.setRemove = true;

	}

	public void addSelection() {
		this.reInit();
		this.initProduct(this.shop.getInventory().getNotShown());
		this.currentProducts = this.shop.getInventory().getNotShown();
		this.setAdd = true;
	}

	public void searchCall() {
		this.initProduct(
				this.currentProducts.stream()
						.filter(product -> product.getName().toUpperCase().contains(this.searchBar.getText().toUpperCase()))
						.collect(Collectors.toList()));
	}

	public void unselectAll() {
		for (Product displayedProduct : this.displayedProducts)
			displayedProduct.setSelected(false);
		this.initProduct(this.displayedProducts);
	}

	public void selectAll() {
		for (Product displayedProduct : this.displayedProducts)
			displayedProduct.setSelected(true);
		this.initProduct(this.displayedProducts);

	}

	private void reInit() {
		this.gridPane.getChildren().removeAll(this.gridPane.getChildren());
		this.tricky.getChildren().removeAll(this.tricky.getChildren());
		this.setRemove = false;
		this.setAdd = false;
		this.setModification = false;
		this.setNews = false;
		for (Product product : this.shop.getInventory().getAll())
			product.setSelected(false);

	}

	public void valid() {
		List<Product> list = this.shop.getInventory().getAll().stream().filter(Product::isSelected).collect(Collectors.toList());

		if (this.setNews)
			this.shop.getInventory().setDate(this.dateController.getDate());

		if (this.setAdd)
			for (Product product : list) {
				product.setShow(true);
			}

		if (this.setModification)
			this.trickyController.doOperation(list);

		if (this.setRemove)
			for (Product product : list) {
				product.setShow(false);
			}
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
}
