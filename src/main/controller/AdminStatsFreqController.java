package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Shop;

import java.io.IOException;

public class AdminStatsFreqController {

	@FXML
	private BarChart chart;
	@FXML
	private ToggleButton lun, mar, mer, jeu, ven, sam, dim;
	@FXML
	private RadioButton freq17, freq16;
	@FXML
	private AnchorPane center;

	private Shop shop;

	public void init(Shop shop) {
		this.shop = shop;

		lun.setSelected(true);
		freq16.setSelected(true);

		display();

	}

	public void actionAdmin() {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/adminstats.fxml"));
			Parent pane = loader.load();
			((AdminStatsController) loader.getController()).init(this.shop);
			((Pane) this.center.getParent()).getChildren().set(0, pane);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void display() {
		chart.getData().clear();
		if (lun.isSelected()) {
			displayLun();
		}
		if (mar.isSelected()) {
			displayMar();
		}
		if (mer.isSelected()) {
			displayMer();
		}
		if (jeu.isSelected()) {
			displayJeu();
		}
		if (ven.isSelected()) {
			displayVen();
		}
		if (sam.isSelected()) {
			displaySam();
		}
		if (dim.isSelected()) {
			displayDim();
		}

	}

	public void displayLun() {

		if (freq16.isSelected()) {

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("2016");

			dataSeries1.getData().add(new XYChart.Data("8h", 5));
			dataSeries1.getData().add(new XYChart.Data("9h", 10));
			dataSeries1.getData().add(new XYChart.Data("10h", 20));
			dataSeries1.getData().add(new XYChart.Data("11h", 50));
			dataSeries1.getData().add(new XYChart.Data("12h", 30));
			dataSeries1.getData().add(new XYChart.Data("13h", 25));
			dataSeries1.getData().add(new XYChart.Data("14h", 30));
			dataSeries1.getData().add(new XYChart.Data("15h", 70));
			dataSeries1.getData().add(new XYChart.Data("16h", 60));
			dataSeries1.getData().add(new XYChart.Data("17h", 50));
			dataSeries1.getData().add(new XYChart.Data("18h", 40));
			dataSeries1.getData().add(new XYChart.Data("19h", 30));
			dataSeries1.getData().add(new XYChart.Data("20h", 10));


			chart.getData().add(dataSeries1);
		}

		if (freq17.isSelected()) {

			XYChart.Series dataSeries2 = new XYChart.Series();
			dataSeries2.setName("2017");

			dataSeries2.getData().add(new XYChart.Data("8h", 500));
			dataSeries2.getData().add(new XYChart.Data("9h", 65));
			dataSeries2.getData().add(new XYChart.Data("10h", 23));
			dataSeries2.getData().add(new XYChart.Data("11h", 567));
			dataSeries2.getData().add(new XYChart.Data("12h", 567));
			dataSeries2.getData().add(new XYChart.Data("13h", 567));
			dataSeries2.getData().add(new XYChart.Data("14h", 567));
			dataSeries2.getData().add(new XYChart.Data("15h", 567));
			dataSeries2.getData().add(new XYChart.Data("16h", 567));
			dataSeries2.getData().add(new XYChart.Data("17h", 567));
			dataSeries2.getData().add(new XYChart.Data("18h", 567));
			dataSeries2.getData().add(new XYChart.Data("19h", 567));
			dataSeries2.getData().add(new XYChart.Data("20h", 567));

			chart.getData().add(dataSeries2);
		}

	}

	public void displayMar() {

		if (freq16.isSelected()) {

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("2016");

			dataSeries1.getData().add(new XYChart.Data("8h", 5));
			dataSeries1.getData().add(new XYChart.Data("9h", 10));
			dataSeries1.getData().add(new XYChart.Data("10h", 20));
			dataSeries1.getData().add(new XYChart.Data("11h", 50));
			dataSeries1.getData().add(new XYChart.Data("12h", 30));
			dataSeries1.getData().add(new XYChart.Data("13h", 25));
			dataSeries1.getData().add(new XYChart.Data("14h", 30));
			dataSeries1.getData().add(new XYChart.Data("15h", 70));
			dataSeries1.getData().add(new XYChart.Data("16h", 60));
			dataSeries1.getData().add(new XYChart.Data("17h", 50));
			dataSeries1.getData().add(new XYChart.Data("18h", 40));
			dataSeries1.getData().add(new XYChart.Data("19h", 30));
			dataSeries1.getData().add(new XYChart.Data("20h", 10));


			chart.getData().add(dataSeries1);
		}

		if (freq17.isSelected()) {

			XYChart.Series dataSeries2 = new XYChart.Series();
			dataSeries2.setName("2017");

			dataSeries2.getData().add(new XYChart.Data("8h", 500));
			dataSeries2.getData().add(new XYChart.Data("9h", 65));
			dataSeries2.getData().add(new XYChart.Data("10h", 23));
			dataSeries2.getData().add(new XYChart.Data("11h", 567));
			dataSeries2.getData().add(new XYChart.Data("12h", 567));
			dataSeries2.getData().add(new XYChart.Data("13h", 567));
			dataSeries2.getData().add(new XYChart.Data("14h", 567));
			dataSeries2.getData().add(new XYChart.Data("15h", 567));
			dataSeries2.getData().add(new XYChart.Data("16h", 567));
			dataSeries2.getData().add(new XYChart.Data("17h", 567));
			dataSeries2.getData().add(new XYChart.Data("18h", 567));
			dataSeries2.getData().add(new XYChart.Data("19h", 567));
			dataSeries2.getData().add(new XYChart.Data("20h", 567));

			chart.getData().add(dataSeries2);
		}
	}

	public void displayMer() {

		if (freq16.isSelected()) {

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("2016");

			dataSeries1.getData().add(new XYChart.Data("8h", 5 * 2));
			dataSeries1.getData().add(new XYChart.Data("9h", 10 * 2));
			dataSeries1.getData().add(new XYChart.Data("10h", 20 * 2));
			dataSeries1.getData().add(new XYChart.Data("11h", 50 * 2));
			dataSeries1.getData().add(new XYChart.Data("12h", 30 * 2));
			dataSeries1.getData().add(new XYChart.Data("13h", 25 * 2));
			dataSeries1.getData().add(new XYChart.Data("14h", 30 * 2));
			dataSeries1.getData().add(new XYChart.Data("15h", 70 * 2));
			dataSeries1.getData().add(new XYChart.Data("16h", 60 * 2));
			dataSeries1.getData().add(new XYChart.Data("17h", 50 * 2));
			dataSeries1.getData().add(new XYChart.Data("18h", 40 * 2));
			dataSeries1.getData().add(new XYChart.Data("19h", 30 * 2));
			dataSeries1.getData().add(new XYChart.Data("20h", 10 * 2));


			chart.getData().add(dataSeries1);
		}

		if (freq17.isSelected()) {

			XYChart.Series dataSeries2 = new XYChart.Series();
			dataSeries2.setName("2017");

			dataSeries2.getData().add(new XYChart.Data("8h", 500));
			dataSeries2.getData().add(new XYChart.Data("9h", 65));
			dataSeries2.getData().add(new XYChart.Data("10h", 23));
			dataSeries2.getData().add(new XYChart.Data("11h", 567));
			dataSeries2.getData().add(new XYChart.Data("12h", 567));
			dataSeries2.getData().add(new XYChart.Data("13h", 567));
			dataSeries2.getData().add(new XYChart.Data("14h", 567));
			dataSeries2.getData().add(new XYChart.Data("15h", 567));
			dataSeries2.getData().add(new XYChart.Data("16h", 567));
			dataSeries2.getData().add(new XYChart.Data("17h", 567));
			dataSeries2.getData().add(new XYChart.Data("18h", 567));
			dataSeries2.getData().add(new XYChart.Data("19h", 567));
			dataSeries2.getData().add(new XYChart.Data("20h", 567));

			chart.getData().add(dataSeries2);
		}
	}

	public void displayJeu() {

		if (freq16.isSelected()) {

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("2016");

			dataSeries1.getData().add(new XYChart.Data("8h", 5));
			dataSeries1.getData().add(new XYChart.Data("9h", 10));
			dataSeries1.getData().add(new XYChart.Data("10h", 20));
			dataSeries1.getData().add(new XYChart.Data("11h", 50));
			dataSeries1.getData().add(new XYChart.Data("12h", 30));
			dataSeries1.getData().add(new XYChart.Data("13h", 25));
			dataSeries1.getData().add(new XYChart.Data("14h", 30));
			dataSeries1.getData().add(new XYChart.Data("15h", 70));
			dataSeries1.getData().add(new XYChart.Data("16h", 60));
			dataSeries1.getData().add(new XYChart.Data("17h", 50));
			dataSeries1.getData().add(new XYChart.Data("18h", 40));
			dataSeries1.getData().add(new XYChart.Data("19h", 30));
			dataSeries1.getData().add(new XYChart.Data("20h", 10));


			chart.getData().add(dataSeries1);
		}

		if (freq17.isSelected()) {

			XYChart.Series dataSeries2 = new XYChart.Series();
			dataSeries2.setName("2017");

			dataSeries2.getData().add(new XYChart.Data("8h", 500));
			dataSeries2.getData().add(new XYChart.Data("9h", 65));
			dataSeries2.getData().add(new XYChart.Data("10h", 23));
			dataSeries2.getData().add(new XYChart.Data("11h", 567));
			dataSeries2.getData().add(new XYChart.Data("12h", 567));
			dataSeries2.getData().add(new XYChart.Data("13h", 567));
			dataSeries2.getData().add(new XYChart.Data("14h", 567));
			dataSeries2.getData().add(new XYChart.Data("15h", 567));
			dataSeries2.getData().add(new XYChart.Data("16h", 567));
			dataSeries2.getData().add(new XYChart.Data("17h", 567));
			dataSeries2.getData().add(new XYChart.Data("18h", 567));
			dataSeries2.getData().add(new XYChart.Data("19h", 567));
			dataSeries2.getData().add(new XYChart.Data("20h", 567));

			chart.getData().add(dataSeries2);
		}
	}

	public void displayVen() {

		if (freq16.isSelected()) {

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("2016");

			dataSeries1.getData().add(new XYChart.Data("8h", 5));
			dataSeries1.getData().add(new XYChart.Data("9h", 10));
			dataSeries1.getData().add(new XYChart.Data("10h", 20));
			dataSeries1.getData().add(new XYChart.Data("11h", 50));
			dataSeries1.getData().add(new XYChart.Data("12h", 30));
			dataSeries1.getData().add(new XYChart.Data("13h", 25));
			dataSeries1.getData().add(new XYChart.Data("14h", 30));
			dataSeries1.getData().add(new XYChart.Data("15h", 70));
			dataSeries1.getData().add(new XYChart.Data("16h", 60));
			dataSeries1.getData().add(new XYChart.Data("17h", 50));
			dataSeries1.getData().add(new XYChart.Data("18h", 40));
			dataSeries1.getData().add(new XYChart.Data("19h", 30));
			dataSeries1.getData().add(new XYChart.Data("20h", 10));


			chart.getData().add(dataSeries1);
		}

		if (freq17.isSelected()) {

			XYChart.Series dataSeries2 = new XYChart.Series();
			dataSeries2.setName("2017");

			dataSeries2.getData().add(new XYChart.Data("8h", 500));
			dataSeries2.getData().add(new XYChart.Data("9h", 65));
			dataSeries2.getData().add(new XYChart.Data("10h", 23));
			dataSeries2.getData().add(new XYChart.Data("11h", 567));
			dataSeries2.getData().add(new XYChart.Data("12h", 567));
			dataSeries2.getData().add(new XYChart.Data("13h", 567));
			dataSeries2.getData().add(new XYChart.Data("14h", 567));
			dataSeries2.getData().add(new XYChart.Data("15h", 567));
			dataSeries2.getData().add(new XYChart.Data("16h", 567));
			dataSeries2.getData().add(new XYChart.Data("17h", 567));
			dataSeries2.getData().add(new XYChart.Data("18h", 567));
			dataSeries2.getData().add(new XYChart.Data("19h", 567));
			dataSeries2.getData().add(new XYChart.Data("20h", 567));

			chart.getData().add(dataSeries2);
		}
	}

	public void displaySam() {

		if (freq16.isSelected()) {

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("2016");

			dataSeries1.getData().add(new XYChart.Data("8h", 5 * 3));
			dataSeries1.getData().add(new XYChart.Data("9h", 10 * 3));
			dataSeries1.getData().add(new XYChart.Data("10h", 20 * 3));
			dataSeries1.getData().add(new XYChart.Data("11h", 50 * 3));
			dataSeries1.getData().add(new XYChart.Data("12h", 30 * 2));
			dataSeries1.getData().add(new XYChart.Data("13h", 25 * 2));
			dataSeries1.getData().add(new XYChart.Data("14h", 30 * 2));
			dataSeries1.getData().add(new XYChart.Data("15h", 70 * 2));
			dataSeries1.getData().add(new XYChart.Data("16h", 60 * 2));
			dataSeries1.getData().add(new XYChart.Data("17h", 50 * 2));
			dataSeries1.getData().add(new XYChart.Data("18h", 40 * 2));
			dataSeries1.getData().add(new XYChart.Data("19h", 30 * 2));
			dataSeries1.getData().add(new XYChart.Data("20h", 10 * 2));


			chart.getData().add(dataSeries1);
		}

		if (freq17.isSelected()) {

			XYChart.Series dataSeries2 = new XYChart.Series();
			dataSeries2.setName("2017");

			dataSeries2.getData().add(new XYChart.Data("8h", 500));
			dataSeries2.getData().add(new XYChart.Data("9h", 65));
			dataSeries2.getData().add(new XYChart.Data("10h", 23));
			dataSeries2.getData().add(new XYChart.Data("11h", 567));
			dataSeries2.getData().add(new XYChart.Data("12h", 567));
			dataSeries2.getData().add(new XYChart.Data("13h", 567));
			dataSeries2.getData().add(new XYChart.Data("14h", 567));
			dataSeries2.getData().add(new XYChart.Data("15h", 567));
			dataSeries2.getData().add(new XYChart.Data("16h", 567));
			dataSeries2.getData().add(new XYChart.Data("17h", 567));
			dataSeries2.getData().add(new XYChart.Data("18h", 567));
			dataSeries2.getData().add(new XYChart.Data("19h", 567));
			dataSeries2.getData().add(new XYChart.Data("20h", 567));

			chart.getData().add(dataSeries2);
		}
	}

	public void displayDim() {

		if (freq16.isSelected()) {

			XYChart.Series dataSeries1 = new XYChart.Series();
			dataSeries1.setName("2016");

			dataSeries1.getData().add(new XYChart.Data("8h", 0));
			dataSeries1.getData().add(new XYChart.Data("9h", 0));
			dataSeries1.getData().add(new XYChart.Data("10h", 0));
			dataSeries1.getData().add(new XYChart.Data("11h", 0));
			dataSeries1.getData().add(new XYChart.Data("12h", 0));
			dataSeries1.getData().add(new XYChart.Data("13h", 0));
			dataSeries1.getData().add(new XYChart.Data("14h", 0));
			dataSeries1.getData().add(new XYChart.Data("15h", 0));
			dataSeries1.getData().add(new XYChart.Data("16h", 0));
			dataSeries1.getData().add(new XYChart.Data("17h", 0));
			dataSeries1.getData().add(new XYChart.Data("18h", 0));
			dataSeries1.getData().add(new XYChart.Data("19h", 0));
			dataSeries1.getData().add(new XYChart.Data("20h", 0));


			chart.getData().add(dataSeries1);
		}

		if (freq17.isSelected()) {

			XYChart.Series dataSeries2 = new XYChart.Series();
			dataSeries2.setName("2017");

			dataSeries2.getData().add(new XYChart.Data("8h", 0));
			dataSeries2.getData().add(new XYChart.Data("9h", 0));
			dataSeries2.getData().add(new XYChart.Data("10h", 0));
			dataSeries2.getData().add(new XYChart.Data("11h", 0));
			dataSeries2.getData().add(new XYChart.Data("12h", 0));
			dataSeries2.getData().add(new XYChart.Data("13h", 0));
			dataSeries2.getData().add(new XYChart.Data("14h", 0));
			dataSeries2.getData().add(new XYChart.Data("15h", 0));
			dataSeries2.getData().add(new XYChart.Data("16h", 0));
			dataSeries2.getData().add(new XYChart.Data("17h", 0));
			dataSeries2.getData().add(new XYChart.Data("18h", 0));
			dataSeries2.getData().add(new XYChart.Data("19h", 0));
			dataSeries2.getData().add(new XYChart.Data("20h", 0));

			chart.getData().add(dataSeries2);
		}
	}
}
