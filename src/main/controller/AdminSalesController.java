package controller;

import javafx.fxml.Initializable;
import model.Information;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by canor on 13/03/2017.
 */
public class AdminSalesController implements Initializable {

    private Information info;

    public void init(Information info) {
        this.info = info;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
