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
	private Text title, desc, stock, price, priceSale;
	@FXML
	private ImageView picture;
	@FXML
	private ImageView stockPicture;

	private Product product;

	public void init(Product product) {
		this.product = product;
		this.title.setText(product.getName());
		this.desc.setText(product.getDescription());
		this.picture.setImage(product.getPicture());

		if (product.getPrice() != product.getCurrentPrice()) {
			this.priceSale.setText(String.valueOf(product.getCurrentPrice())+"€ au lieu de "+String.valueOf(product.getPrice())+"€");
		}
		else{
            this.price.setText(String.valueOf(product.getPrice())+"€");
        }

		if (product.isInStock()) {
			this.stock.setText("En stock");
		} else this.stock.setText("Plus disponible");
	}

	public Button getBack() {
		return this.back;
	}
}
