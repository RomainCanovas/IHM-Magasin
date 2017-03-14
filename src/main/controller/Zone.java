package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import model.Product;

import java.io.IOException;

public class Zone extends Parent {

	private static double xPop = 0;
	private static double yPop = 0;
	private String name;

	public Zone(String name, Color color, ImageView picture, int maxSize) {

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

	public void setPopUp(Product p) {

		this.setOnMouseClicked(event -> {

			Popup popup = new Popup();
			popup.setX(xPop);
			popup.setY(yPop);

			try {

				FXMLLoader loader = new FXMLLoader(getClass().getResource("view/PopUp.fxml"));
				Parent pane = loader.load();
				pane.setOnMousePressed(e -> popup.hide());
				((PopUpController) loader.getController()).init(p);
				popup.getContent().add(pane);

			} catch (IOException e) {

				e.printStackTrace();

			}

			popup.show(this.getScene().getWindow());

		});

	}

	public void setAdmin(Product p) {
		CheckBox box = new CheckBox();
		this.setOnMouseClicked(event -> {
			box.fire();
			p.setSelected(!p.getSelected());
		});
		this.getChildren().add(box);
	}
}
