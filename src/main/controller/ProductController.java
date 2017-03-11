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

		for (int i = 0; i < MAX_COLUMN + 1; i++)
			this.gridPane.getColumnConstraints().add(new ColumnConstraints());
		for (int i = 0; i < this.products.size() / MAX_COLUMN; i++)
			this.gridPane.getRowConstraints().add(new RowConstraints());

		for (int i = 0; i < this.products.size(); i++) {
			Product p = this.products.get(i);
			p.reSize(MAX_SIZE, MAX_SIZE);
			Zone zone = new Zone(p.getName(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, p.getPicture(), MAX_SIZE);
			this.gridPane.add(zone, 1 + i % MAX_COLUMN, i / MAX_COLUMN);
		}
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.gridPane.setHgap(2);
		this.gridPane.setVgap(2);
	}
}
