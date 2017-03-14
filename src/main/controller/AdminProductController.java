package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import model.Inventory;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AdminProductController implements Initializable {

	private static final int MAX_SIZE = 95;
	private static final int MAX_COLUMN = 8;

	@FXML
	public AnchorPane tricky;
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
	private boolean setModification;
	private boolean setRemove;
	private boolean setAdd;
	private boolean setNews; //Todo
	private Inventory inventory;

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

	public void init(Inventory inventory) {
		this.inventory = inventory;
		for (Product product : this.inventory.getAll())
			product.setSelected(false);

		this.initProduct(inventory.getAll());
	}

	private void initProduct(List<Product> products) { // 786 252

		this.initSize(products.size() + 1, MAX_COLUMN);

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			p.resize(MAX_SIZE, MAX_SIZE);
			Zone zone = new Zone(p.getName(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, p.getPicture(), MAX_SIZE);
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

		this.initProduct(this.inventory.getShown());
		this.setModification = true;
	}

	public void removeSelection() {
		this.reInit();
		this.initProduct(this.inventory.getShown());
		this.setRemove = true;

	}

	public void addSelection() {
		this.reInit();
		this.initProduct(this.inventory.getNotShown());
		this.setAdd = true;
	}

	private void reInit() {
		this.gridPane.getChildren().removeAll(this.gridPane.getChildren());
		this.tricky.getChildren().removeAll(this.tricky.getChildren());
		this.setRemove = false;
		this.setAdd = false;
		this.setModification = false;
		this.setNews = false;
		for (Product product : this.inventory.getAll())
			product.setSelected(false);

	}

	public void valid() {
		List<Product> list = this.inventory.getAll().stream().filter(Product::isSelected).collect(Collectors.toList());

		/*if (this.setNews)
			true;*/

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
}
