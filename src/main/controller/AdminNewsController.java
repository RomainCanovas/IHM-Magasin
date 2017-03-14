package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;


public class AdminNewsController implements Initializable {

	@FXML
	private DatePicker calendar;
	private LocalDate date;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.calendar.setValue(LocalDate.now());
	}

	public void setDate() {
		this.date = this.calendar.getValue();
	}

	public LocalDate getDate() {
		return this.date;
	}
}
