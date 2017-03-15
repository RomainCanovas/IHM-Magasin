package controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Information;

public class ReceptionController {

	@FXML
	private Text openning, phone, email, floor, clue, desc, commentary;

	public void init(Information info) {
		this.openning.textProperty().bind(Bindings.concat("Du ", info.openDayProperty(), " au ", info.closeDayProperty(), " de ", info.openHourProperty(), info.openMinProperty(), " à ", info.closeHourProperty(), info.closeMinProperty()));
		this.phone.textProperty().bind(Bindings.concat("Tél.: +33 78 27 39 ", info.phoneProperty()));
		this.email.textProperty().bind(Bindings.concat("email: ", info.emailProperty(), "@capsophia.fr"));
		this.floor.textProperty().bind(Bindings.concat("Niveau: ", info.floorProperty()));
		this.clue.textProperty().bind(info.clueProperty());
		this.desc.textProperty().bind(info.descProperty());
		this.commentary.textProperty().bind(info.commentaryProperty());
	}

}
