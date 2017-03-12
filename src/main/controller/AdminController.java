package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import model.Information;

import java.io.IOException;

/**
 * Created by canor on 10/03/2017.
 */
    public class AdminController {

        @FXML
        public Button stats;
        @FXML
        public MenuItem floor1, floor2, floor0;
        @FXML
        private MenuItem jan2017CA, feb2017CA, jan2017PR, feb2017PR, jan2017PS, feb2017PS;
        @FXML
        private MenuItem access, description, opening, phoneMail, newsAdmin, salesAdmin, productsAdmin;
        @FXML
        private AnchorPane center;
        private Information information;


        public void init(){

        }

    public void actionAdmin(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Admin.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init();
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionAdminAccess(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminAccess.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init();
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setFloor1() {
        information.setFloor(1);
    }

    public void setFloor2() {
        information.setFloor(2);
    }

    public void setFloor0() {
        information.setFloor(0);
    }

    public void actionAdminDescription(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminDescription.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init();
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionAdminOpening(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminOpeningHours.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init();
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionAdminPhoneAndMail(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminPhoneAndMail.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init();
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HomeStats(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/AdminStats.fxml"));
            Parent pane = loader.load();
            ((AdminController) loader.getController()).init();
            this.center.getChildren().set(0, pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DoStats(ActionEvent actionEvent) {

    }

}

