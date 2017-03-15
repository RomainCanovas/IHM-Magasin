package controller.admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Product;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminProductChoiceController implements Initializable {

    @FXML
    public Text text;
    @FXML
    public Slider slider;
    @FXML
    private TextField textField;
    @FXML
    private SplitMenuButton button;
    private MenuItem salesOriginal;
    private MenuItem salesCurrent;
    private MenuItem changeOriginalPrice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.slider.setMin(0);
        this.slider.setMax(100);
        this.slider.setBlockIncrement(5);
        this.slider.setValue(50);
        this.slider.setSnapToTicks(true);

        this.slider.valueChangingProperty().addListener((observableValue, wasChanging, changing) -> {
            if (changing)
                textField.setText(slider.getValue() + "");
        });


        this.salesOriginal = new MenuItem("Réduction depuis prix original");
        this.salesOriginal.setOnAction(event -> this.setSalesOriginal());

        this.salesCurrent = new MenuItem("Réduction depuis prix actuel");
        this.salesCurrent.setOnAction(event -> this.setSalesCurrent());

        this.changeOriginalPrice = new MenuItem("Changer le prix original");
        this.changeOriginalPrice.setOnAction(event -> this.setNewPrice());

        this.button.getItems().addAll(this.changeOriginalPrice, this.salesCurrent);
        this.button.setText(this.salesOriginal.getText());
        this.textField.setText("0");
        this.text.setText("%");

    }

    private void setNewPrice() {
        this.button.getItems().removeAll(this.button.getItems());
        this.button.getItems().addAll(this.salesCurrent, this.salesOriginal);
        this.button.setText(this.changeOriginalPrice.getText());
        this.text.setText("€");
    }

    private void setSalesCurrent() {
        this.button.getItems().removeAll(this.button.getItems());
        this.button.getItems().addAll(this.changeOriginalPrice, this.salesOriginal);
        this.button.setText(this.salesCurrent.getText());
        this.text.setText("%");
    }

    private void setSalesOriginal() {
        this.button.getItems().removeAll(this.button.getItems());
        this.button.getItems().addAll(this.salesCurrent, this.changeOriginalPrice);
        this.button.setText(this.salesOriginal.getText());
        this.text.setText("%");
    }

    void doOperation(List<Product> products) {

        if (this.button.getText().equals(this.changeOriginalPrice.getText()))
            for (Product product : products) {
                double d = ((int) ((slider.getValue()) * 100)) / 100.;
                product.setCurrentPrice(d);
            }

        if (this.button.getText().equals(this.salesCurrent.getText()))
            for (Product product : products) {
                double d = ((int) ((product.getCurrentPrice() * slider.getValue() / 100) * 100)) / 100.;
                product.setCurrentPrice(d);
            }

        if (this.button.getText().equals(this.salesOriginal.getText()))
            for (Product product : products) {
                double d = ((int) ((product.getPrice() * slider.getValue() / 100) * 100)) / 100.;
                product.setCurrentPrice(d);
            }

    }

    public void onActionTextField() {
        String str = this.textField.getText();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                this.textField.setText("0");
                return;
            }
        }

        if ("".equals(this.textField.getText()))
            this.slider.setValue(0);
        else
            this.slider.setValue(Math.min(100, Math.max(0, Integer.parseInt(this.textField.getText()))));
    }
}
