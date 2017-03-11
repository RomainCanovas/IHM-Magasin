package model;


import javafx.scene.image.ImageView;

public class Product {

	private String name, description;
	private final float price;
	private float salesPrice;
	private ImageView picture;

	public Product(String name, String picturePath, String description, int price) {
		this.name = name;
		this.picture = new ImageView(this.getClass().getResource(picturePath).toString());
		this.description = description;
		this.price = price;
		this.salesPrice = this.price;
	}

	public boolean isOnSale() {
		return this.price != this.salesPrice ||true;
	}//Fixme

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
}
