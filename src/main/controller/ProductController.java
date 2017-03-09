package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.Product;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
	private static final int MAX_COLUMN = 2;
	@FXML
	public GridPane gridPane;

	private List<Product> products;

	public void init(List<Product> products) { // 786 252

		this.products = products;

		for (int i = 0; i < MAX_COLUMN + 1; i++)
			this.gridPane.getColumnConstraints().add(new ColumnConstraints());
		for (int i = 0; i < this.products.size() / MAX_COLUMN; i++)
			this.gridPane.getRowConstraints().add(new RowConstraints());

		for (int i = 0; i < this.products.size(); i++) {
			Product p = this.products.get(i);
			HBox hBox = new HBox();
			VBox vBox = new VBox();
			vBox.getChildren().addAll(new Text("\t" + p.getName() + "\t" + p.getPrice() + "€"), new Text("\t" + p.getDescription()));
			hBox.getChildren().addAll(p.getPicture(), vBox);
			this.gridPane.add(hBox, 1 + i % MAX_COLUMN, i / MAX_COLUMN);
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.gridPane.setHgap(20);
	}
}
