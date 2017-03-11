package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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

	private List<Product> products;

	public void init(List<Product> products, String heading) { // 786 252

		this.heading.setText(heading);
		this.products = products;

		this.initSize(this.products.size() + 1, MAX_COLUMN);

		for (int i = 0; i < this.products.size(); i++) {
			Product p = this.products.get(i);
			p.resize(MAX_SIZE, MAX_SIZE);
			Zone zone = new Zone(p.getName(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, p.getPicture(), MAX_SIZE);
			this.gridPane.add(zone, 1 + i % MAX_COLUMN, i / MAX_COLUMN);
		}
	}

	public void init(Map<String, Product> categories) {

		this.heading.setText("Categorie");
		this.initSize(categories.keySet().size() + 1, MAX_COLUMN);

		int i = 0;

		for (Map.Entry<String, Product> entry : categories.entrySet()) {
			entry.getValue().resize(MAX_SIZE,MAX_SIZE);
			Zone zone = new Zone(entry.getKey(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, entry.getValue().getPicture(), MAX_SIZE);
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.gridPane.setHgap(2);
		this.gridPane.setVgap(2);
	}
}
