package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import model.Product;

import java.net.URL;
import java.util.ResourceBundle;

public class PopUpController implements Initializable {

	@FXML
	public Text productName;
	@FXML
	public ImageView picture;
	@FXML
	public Text price;
	@FXML
	public TextFlow desc;

	public void init(Product p) {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
