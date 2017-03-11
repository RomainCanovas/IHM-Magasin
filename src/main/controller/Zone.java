package controller;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Zone extends Parent {

	private String name;

	public Zone(String name, Color color, ImageView image, int maxSize) {

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

		this.getChildren().addAll(zone, image);

	}
}
