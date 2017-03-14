package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Product;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by canor on 14/03/2017.
 */
public class PopUpController implements Initializable{

    Product product;

    @FXML
    Text productTitle, productPrice, productDesc, productStock;

    @FXML
    ImageView productPicture;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void init(Product product){
        this.product = product;
        productTitle.setText(product.getName());
        productDesc.setText(product.getDescription());
        productPicture.setImage(product.getPicture().getImage());

        if(product.getPrice()==product.getCurrentPrice())
        {productPrice.setText(String.valueOf(product.getPrice()));}
        else productPrice.setText(String.valueOf(product.getCurrentPrice()));

        if (product.isInStock()) {productStock.setText("En stock");}
        else productStock.setText("Plus disponible");
    }
}
