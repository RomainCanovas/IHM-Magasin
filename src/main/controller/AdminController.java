package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import model.Information;

import java.io.IOException;

/**
 * Created by canor on 10/03/2017.
 */
public class AdminController {

    @FXML
    private ComboBox floor;
    @FXML
    private Button stats;
    @FXML
    private MenuItem jan2017CA, feb2017CA, jan2017PR, feb2017PR, jan2017PS, feb2017PS;
    @FXML
    private MenuItem access, description, opening, phoneMail, newsAdmin, salesAdmin, productsAdmin;
    @FXML
    private AnchorPane center;
    private Information info;


        public void init(Information info){
            this.info=info;
        }

    public void actionAdmin(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Admin.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.info);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionAdminAccess(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/admin/AdminAccess.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.info);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFloor() {
        return floor.toString();
    }

    public void setFloor(ActionEvent actionEvent) {
        String floor = getFloor();
        switch (floor) {
            case "0":
                info.setFloor(0);
                break;
            case "1":
                info.setFloor(1);
                break;
            case "2":
                info.setFloor(2);
                break;
            default:
                break;
        }
    }


    public void actionAdminDescription(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminDescription.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.info);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionAdminOpening(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminOpeningHours.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.info);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionAdminPhoneAndMail(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminPhoneAndMail.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.info);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HomeStats(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminStats.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init(this.info);
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DoStats(ActionEvent actionEvent) {

    }

}

