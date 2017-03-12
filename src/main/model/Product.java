package model;


import javafx.scene.image.ImageView;

import java.util.Date;

public class Product {

	private String name, description;
	private final float price;
	private float salesPrice;
	private ImageView picture;
	private Date date;

	public Product(String name, String picturePath, String description, int price) {
		this.name = name;
		this.picture = new ImageView(this.getClass().getResource(picturePath).toString());
		this.description = description;
		this.price = price;
		this.salesPrice = this.price;
		this.date = new Date();
	}

	public boolean isOnSale() {
		return this.price != this.salesPrice;
	}

	public ImageView getPicture() {
		return this.picture;
	}

	public String getName() {
		return this.name;
	}

	public void resize(double height, double width) {
		this.picture.setFitWidth(width);
		this.picture.setFitHeight(height);
	}

	public String getDescription() {
		return this.description;
	}

	public float getPrice() {
		return this.price;
	}

	public Date getDate() {
		return this.date;
	}
}
