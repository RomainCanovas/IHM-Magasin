package controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Information;

public class ReceptionController {

	@FXML
	public Text openning, phone, email, floor, clue, desc, commentary;

	@FXML

	public void init(Information info) {
		this.openning.textProperty().bind(Bindings.concat("Du ", info.getOpenDay(), " au ", info.getCloseDay(), " de ", info.getOpenHour(), info.getOpenMin(), " à ", info.getCloseHour(), info.getCloseMin()));
		this.phone.textProperty().bind(Bindings.concat("Tél.: +33 78 27 39 ", info.getPhone()));
		this.email.textProperty().bind(Bindings.concat("email: ", info.getEmail(), "@capsophia.fr"));
		this.floor.textProperty().bind(Bindings.concat("Niveau: ", info.floorProperty()));
		this.clue.textProperty().bind(info.clueProperty());
		this.desc.textProperty().bind(info.descProperty());
		this.commentary.textProperty().bind(info.commentaryProperty());
	}

}
