package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Employee;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TeamController implements Initializable {

	private static final int MAX_COLUMN = 4;
	@FXML
	private GridPane gridPane;
	@FXML
	private ScrollPane scrollPane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.gridPane.setHgap(42);
		this.gridPane.setVgap(42);
	}

	void initEmployee(List<Employee> team) {

		for (int i = 0; i < MAX_COLUMN; i++)
			this.gridPane.getColumnConstraints().add(new ColumnConstraints());
		for (int i = 0; i < team.size() / MAX_COLUMN; i++)
			this.gridPane.getRowConstraints().add(new RowConstraints());

		for (int i = 0; i < team.size(); i++) {
			Employee e = team.get(i);
			VBox vBox = new VBox();
			vBox.getChildren().addAll(e.getPicture(), new Text("\t" + e.getFirstName() + " " + e.getName()), new Text("\t" + e.getJob()));
			this.gridPane.add(vBox, i % MAX_COLUMN, i / MAX_COLUMN);
		}
	}
}
