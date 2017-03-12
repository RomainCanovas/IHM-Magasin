package controller;


import javafx.fxml.Initializable;
import model.Information;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminAccesController implements Initializable {

	private Information info;

	public void init(Information info) {
		this.info = info;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

	public void setFloor0() {
		this.info.setFloor(0);
	}

	public void setFloor1() {
		this.info.setFloor(1);
	}

	public void setFloor2() {
		this.info.setFloor(2);

	}

	public void actionAdmin() {
		//todo je sais pas quoi

	}
}
