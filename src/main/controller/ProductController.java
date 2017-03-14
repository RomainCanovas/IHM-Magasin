package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import model.Inventory;
import model.Product;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    private static final int MAX_SIZE = 95;
    private static final int MAX_COLUMN = 8;
    private Product product;

    @FXML
    public GridPane gridPane;
    @FXML
    public Text heading;
    @FXML
    public AnchorPane center;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.gridPane.setHgap(2);
        this.gridPane.setVgap(2);
    }

    void init(Inventory inventory, String name) {

        switch (name) {
            case "PROMOTIONS":
                this.initProduct(inventory.onSale(), name);
                break;
            case "CATEGORIES":
                this.initCategory(inventory);
                break;
            case "NOUVEAUTES":
                this.initProduct(inventory.isNew(), name);
                break;
            default:
                this.initProduct(inventory.search(name), name);

        }

    }

    private void initProduct(List<Product> products, String name) { // 786 252

        this.heading.setText(name);

        this.initSize(products.size() + 1, MAX_COLUMN);

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            p.resize(MAX_SIZE, MAX_SIZE);
            Zone zone = new Zone(p.getName(), (i % 2 == 0) ? Color.YELLOW : Color.BEIGE, p.getPicture(), MAX_SIZE);
            zone.setOnMouseClicked(event -> this.actionPop());
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
            zone.setOnMouseClicked(event -> this.initProduct(inventory.getCategory(zone.getName()), zone.getName()));
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

    public void actionPop() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/productpopup.fxml"));
            Parent pane = loader.load();
            ((PopUpController) loader.getController()).init(this.product);

            Popup pop = new Popup();
            pane.setOnKeyPressed(e -> {
                if (e.getCode() == KeyCode.Q)
                    pop.hide();
            });

            pop.getContent().add(pane);
            pop.setY(50);
            pop.setX(50);
            pop.show(this.center.getScene().getWindow());


        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
