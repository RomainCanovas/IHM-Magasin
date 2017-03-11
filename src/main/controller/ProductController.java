package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Inventory;
import model.Product;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

	private static final int MAX_SIZE = 95;
	private static final int MAX_COLUMN = 8;

	@FXML
	public GridPane gridPane;
	@FXML
	public Text heading;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.gridPane.setHgap(2);
		this.gridPane.setVgap(2);
	}

	void init(Inventory inventory, String name) {

		if (inventory.getCategory(name) != null) {

			this.initProduct(inventory.getCategory(name), name);

		} else {

			switch (name) {
				case "PROMOTIONS":
					this.initProduct(inventory.onSale(), name);
					break;
				case "CATEGORIES":
					this.initCategory(inventory);
					break;
				default:
					System.exit(0);
			}
		}
	}

	private void initProduct(List<Product> products, String name) { // 786 252

		this.heading.setText(name);

		this.initSize(products.size() + 1, MAX_COLUMN);

		for (int i = 0; i < products.size(); i++) {
			Product p = products.get(i);
			p.resize(MAX_SIZE, MAX_SIZE);
			Zone zone = new Zone(p.getName(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, p.getPicture(), MAX_SIZE);
			zone.setPopUp(p);
			this.gridPane.add(zone, 1 + i % MAX_COLUMN, i / MAX_COLUMN);
		}
	}

	private void initCategory(Inventory inventory) {

		this.heading.setText("CATEGORIES");

		Map<String, Product> categories = inventory.getCategories();

		this.initSize(categories.keySet().size() + 1, MAX_COLUMN);

		int i = 0;

		for (Map.Entry<String, Product> entry : categories.entrySet()) {

			entry.getValue().resize(MAX_SIZE, MAX_SIZE);
			Zone zone = new Zone(entry.getKey(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, entry.getValue().getPicture(), MAX_SIZE);
			zone.setOnMouseClicked(event -> this.init(inventory, zone.getName()));

			this.gridPane.add(zone, 1 + i % MAX_COLUMN, i / MAX_COLUMN);
			i++;
		}

	}

	private void initSize(int maxColumn, int size) {

		for (int i = 0; i < maxColumn + 1; i++)
			this.gridPane.getColumnConstraints().add(new ColumnConstraints());
		for (int i = 0; i < size / maxColumn; i++)
			this.gridPane.getRowConstraints().add(new RowConstraints());

	}

}
