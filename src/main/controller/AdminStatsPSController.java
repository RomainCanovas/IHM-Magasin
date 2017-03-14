package controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import model.Shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by canor on 13/03/2017.
 */
public class AdminStatsPSController implements Initializable {

    @FXML
    private AnchorPane center;
    @FXML
    private ToggleButton oct, nov, dec, jan, fev, mar;
    @FXML
    private PieChart chart;

    private Shop shop;

    public void init(Shop shop) {
        this.shop = shop;
        final ToggleGroup group = new ToggleGroup();
        oct.setToggleGroup(group);
        nov.setToggleGroup(group);
        dec.setToggleGroup(group);
        jan.setToggleGroup(group);
        fev.setToggleGroup(group);
        mar.setToggleGroup(group);
        mar.setSelected(true);
        display();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void actionAdmin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/adminstats.fxml"));
            Parent pane = loader.load();
            ((AdminStatsController) loader.getController()).init(this.shop);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display() {
        chart.getData().clear();
        if (oct.isSelected()) {
            displayOct();
        }
        if (nov.isSelected()) {
            displayNov();
        }
        if (dec.isSelected()) {
            displayDec();
        }
        if (jan.isSelected()) {
            displayJan();
        }
        if (fev.isSelected()) {
            displayFev();
        }
        if (mar.isSelected()) {
            displayMar();
        }
    }

    public void displayOct() {

        PieChart.Data PS = new PieChart.Data("Produits soldés :", 20);
        PieChart.Data PNS = new PieChart.Data("Produits non soldés :", 400);
        chart.getData().add(PS);
        chart.getData().add(PNS);

        chart.getData().forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().intValue()
                        )
                )
        );
    }

    public void displayNov() {

        PieChart.Data PS = new PieChart.Data("Produits soldés :", 80);
        PieChart.Data PNS = new PieChart.Data("Produits non soldés :", 390);
        chart.getData().add(PS);
        chart.getData().add(PNS);

        chart.getData().forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().intValue()
                        )
                )
        );
    }

    public void displayDec() {

        PieChart.Data PS = new PieChart.Data("Produits soldés :", 22);
        PieChart.Data PNS = new PieChart.Data("Produits non soldés :", 360);
        chart.getData().add(PS);
        chart.getData().add(PNS);

        chart.getData().forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().intValue()
                        )
                )
        );
    }

    public void displayJan() {

        PieChart.Data PS = new PieChart.Data("Produits soldés :", 25);
        PieChart.Data PNS = new PieChart.Data("Produits non soldés :", 420);
        chart.getData().add(PS);
        chart.getData().add(PNS);

        chart.getData().forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().intValue()
                        )
                )
        );
    }

    public void displayFev() {

        PieChart.Data PS = new PieChart.Data("Produits soldés :", 30);
        PieChart.Data PNS = new PieChart.Data("Produits non soldés :", 350);
        chart.getData().add(PS);
        chart.getData().add(PNS);

        chart.getData().forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().intValue()
                        )
                )
        );
    }

    public void displayMar() {

        PieChart.Data PS = new PieChart.Data("Produits soldés :", 60);
        PieChart.Data PNS = new PieChart.Data("Produits non soldés :", 500);
        chart.getData().add(PS);
        chart.getData().add(PNS);

        chart.getData().forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " ", data.pieValueProperty().intValue()
                        )
                )
        );
    }

}
