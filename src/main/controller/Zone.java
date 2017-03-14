package controller;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Screen;
import model.Product;

import java.io.IOException;

public class Zone extends Parent {

	private String name;

	Zone(String name, Color color, ImageView picture, int maxSize) {

		this.name = name;
		this.prefHeight(maxSize);
		this.prefWidth(maxSize);

		Rectangle zone = new Rectangle(maxSize, maxSize);
		zone.setFill(color);

		this.setOnMouseEntered(event -> {
			Rectangle rect = new Rectangle(maxSize, maxSize);
			rect.setFill(Color.YELLOW);
			rect.setOpacity(0.6);
			Text text = new Text(this.name);
			text.setLayoutY(maxSize / 2);
			text.setLayoutX(maxSize / 2 - 25);
			this.getChildren().addAll(rect, text);
		});

		this.setOnMouseExited(event -> {
			this.setOpacity(1);
			this.getChildren().removeAll(
					this.getChildren().get(this.getChildren().size() - 1),
					this.getChildren().get(this.getChildren().size() - 2));
		});

		this.getChildren().addAll(zone, picture);
	}

	public String getName() {
		return this.name;
	}

	public void setAdmin(Product p) {
		CheckBox box = new CheckBox();

		if (p.isSelected()) box.fire();

		this.setOnMouseClicked(event -> {
			box.fire();
			p.setSelected(!p.getSelected());
		});
		this.getChildren().add(box);
	}

	public void setPop(Product p) {

		Parent pane = null;
		PopUpController controller = null;

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/ProductPopUp.fxml"));
			pane = loader.load();
			controller = loader.getController();
			controller.init(p);

		} catch (IOException e) {

			System.exit(0);

		}

		Popup pop = new Popup();
		pop.getContent().add(pane);

		controller.getBack().setOnAction(event -> pop.hide());

		Rectangle2D rec = Screen.getPrimary().getBounds();
		pop.setY(rec.getHeight() / 2 - 200);
		pop.setX(rec.getWidth() / 2 - 200);

		this.setOnMouseClicked(event -> pop.show(this.getScene().getWindow()));


	}
}
