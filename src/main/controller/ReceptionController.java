package controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Information;

public class ReceptionController {

	@FXML
	public Text openning, phone, email, floor, clue;

	public void init(Information info) {
		this.openning.setText(info.getOpenDay() + " de " + info.getOpenHour());
		this.phone.setText("Tél.: " + info.getPhone());
		this.email.setText("email: " + info.getEmail());
		this.floor.setText("Niveau: " + info.getFloor());
		this.clue.setText(info.getClue());
	}

	//fixme INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION
}
