package controller.admin;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Shop;

import java.io.IOException;

public class AdminStatsPRController {

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

	public void actionAdmin() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("adminstats.fxml"));
			Parent pane = loader.load();
			((AdminStatsController) loader.getController()).init(this.shop);
			((Pane) this.center.getParent()).getChildren().set(0, pane);
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

		PieChart.Data PS = new PieChart.Data("Produits renvoyés :", 500);
		PieChart.Data PNS = new PieChart.Data("Reste", 5000);
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

		PieChart.Data PS = new PieChart.Data("Produits renvoyés :", 1000);
		PieChart.Data PNS = new PieChart.Data("Reste", 7000);
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

		PieChart.Data PS = new PieChart.Data("Produits renvoyés :", 100);
		PieChart.Data PNS = new PieChart.Data("Reste", 8000);
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

		PieChart.Data PS = new PieChart.Data("Produits renvoyés :", 600);
		PieChart.Data PNS = new PieChart.Data("Reste", 4000);
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

		PieChart.Data PS = new PieChart.Data("Produits renvoyés :", 500);
		PieChart.Data PNS = new PieChart.Data("Reste", 5000);
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

		PieChart.Data PS = new PieChart.Data("Produits renvoyés :", 200);
		PieChart.Data PNS = new PieChart.Data("Reste", 3000);
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
