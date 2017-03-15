import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable {

	@FXML
	public Pane integration;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Pane root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("controller/Magasin.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Parent parent = this.integration.getParent();
		this.integration = root;
		((Pane)parent).getChildren().add(root);
	}

}
