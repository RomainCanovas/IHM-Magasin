package controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Information;

public class ReceptionController {

	@FXML
	public Text openning, phone, email, floor, clue, desc1, desc2, desc3;
	@FXML

	public void init(Information info) {
		this.openning.setText(info.getOpenDay() + " de " + info.getOpenHour());
		this.phone.setText("Tél.: +33 78 27 39" + info.getPhone());
		this.email.setText("email: " + info.getEmail() + "@capsophia.fr");
		this.floor.setText("Niveau: " + info.getFloor());
		this.clue.setText(info.getClue());
		this.desc1.setText(info.getDesc());
		this.desc2.setText("Yololo");
		this.desc3.setText("Yolololo");

	}

	//fixme INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION
}
