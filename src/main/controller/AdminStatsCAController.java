package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by canor on 13/03/2017.
 */
public class AdminStatsCAController implements Initializable{

    @FXML
    AnchorPane center;
    @FXML
    BarChart chart;
    @FXML
    ToggleButton a16, a17, a15;


    public void init() {

        a17.setSelected(true);
        display();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void actionAdmin(ActionEvent actionEvent){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/adminstats.fxml"));
            Parent pane = loader.load();
            ((AdminStatsController) loader.getController()).init();
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void display(){
        chart.getData().clear();
        if (a15.isSelected()){display2015();}
        if (a16.isSelected()){display2016();}
        if (a17.isSelected()){display2017();}
    }

    public void display2015(){


            XYChart.Series dataSeries1 = new XYChart.Series();
            dataSeries1.setName("2015");

            dataSeries1.getData().add(new XYChart.Data("Jan", 20));
            dataSeries1.getData().add(new XYChart.Data("Fev", 20));
            dataSeries1.getData().add(new XYChart.Data("Mar", 40));
            dataSeries1.getData().add(new XYChart.Data("Avr", 50));
            dataSeries1.getData().add(new XYChart.Data("Mai", 40));
            dataSeries1.getData().add(new XYChart.Data("Juin", 40));
            dataSeries1.getData().add(new XYChart.Data("Juil", 50));
            dataSeries1.getData().add(new XYChart.Data("Aoû", 80));
            dataSeries1.getData().add(new XYChart.Data("Sept", 80));
            dataSeries1.getData().add(new XYChart.Data("Oct", 70));
            dataSeries1.getData().add(new XYChart.Data("Nov", 90));
            dataSeries1.getData().add(new XYChart.Data("Dec", 100));

            chart.getData().add(dataSeries1);

    }

    public void display2016(){


        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2016");

        dataSeries1.getData().add(new XYChart.Data("Jan", 20+5));
        dataSeries1.getData().add(new XYChart.Data("Fev", 20+5));
        dataSeries1.getData().add(new XYChart.Data("Mar", 40+5));
        dataSeries1.getData().add(new XYChart.Data("Avr", 50+5));
        dataSeries1.getData().add(new XYChart.Data("Mai", 40+5));
        dataSeries1.getData().add(new XYChart.Data("Juin", 40+5));
        dataSeries1.getData().add(new XYChart.Data("Juil", 50+5));
        dataSeries1.getData().add(new XYChart.Data("Aoû", 80+5));
        dataSeries1.getData().add(new XYChart.Data("Sept", 80+5));
        dataSeries1.getData().add(new XYChart.Data("Oct", 70+5));
        dataSeries1.getData().add(new XYChart.Data("Nov", 90+5));
        dataSeries1.getData().add(new XYChart.Data("Dec", 100+5));

        chart.getData().add(dataSeries1);

    }

    public void display2017(){


        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2017");

        dataSeries1.getData().add(new XYChart.Data("Jan", 20+7));
        dataSeries1.getData().add(new XYChart.Data("Fev", 20+7));
        dataSeries1.getData().add(new XYChart.Data("Mar", 40+7));
        dataSeries1.getData().add(new XYChart.Data("Avr", 50+7));
        dataSeries1.getData().add(new XYChart.Data("Mai", 40+7));
        dataSeries1.getData().add(new XYChart.Data("Juin", 40+7));
        dataSeries1.getData().add(new XYChart.Data("Juil", 50+7));
        dataSeries1.getData().add(new XYChart.Data("Aoû", 80+7));
        dataSeries1.getData().add(new XYChart.Data("Sept", 80+7));
        dataSeries1.getData().add(new XYChart.Data("Oct", 70+7));
        dataSeries1.getData().add(new XYChart.Data("Nov", 90+7));
        dataSeries1.getData().add(new XYChart.Data("Dec", 100+7));

        chart.getData().add(dataSeries1);

    }




}
