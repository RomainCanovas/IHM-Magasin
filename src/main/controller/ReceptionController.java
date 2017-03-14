package controller;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.Information;

public class ReceptionController {

    @FXML
    public Text openning, phone, email, floor, clue, desc, commentary;

    @FXML

    public void init(Information info) {
        this.openning.setText("Du " + info.getOpenDay() + " au " + info.getCloseDay() + " de " + info.getOpenHour() + info.getOpenMin() + " à " + info.getCloseHour() + info.getCloseMin());
        this.phone.setText("Tél.: +33 78 27 39 " + info.getPhone());
        this.email.setText("email: " + info.getEmail() + "@capsophia.fr");
        this.floor.setText("Niveau: " + info.getFloor());
        this.clue.setText(info.getClue());
        this.desc.setText(info.getDesc());
        this.commentary.setText(info.getCommentary());
    }

    //fixme INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION INTERACTION
}
