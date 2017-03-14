package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Product;

public class PopUpController {

	@FXML
	private Button back;
	@FXML
	private Text title;
	@FXML
	private ImageView picture;
	@FXML
	private Text desc;
	@FXML
	private Text stock;
	@FXML
	private Text price;
	@FXML
	private ImageView stockPicture;

	private Product product;

	public void init(Product product) {
		this.product = product;
		this.title.setText(product.getName());
		this.desc.setText(product.getDescription());
		this.picture.setImage(product.getPicture().getImage());

		if (product.getPrice() == product.getCurrentPrice()) {
			this.price.setText(String.valueOf(product.getPrice()));
		} else this.price.setText(String.valueOf(product.getCurrentPrice()));

		if (product.isInStock()) {
			this.stock.setText("En stock");
		} else this.stock.setText("Plus disponible");
	}

	public Button getBack() {
		return this.back;
	}
}
