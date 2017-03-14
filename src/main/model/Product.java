package model;


import javafx.scene.image.ImageView;

import java.util.Date;

public class Product {

	private String name, description;
	private float price;
	private float currentPrice;
	private ImageView picture;
	private boolean isSelected, show;
	private Date date;

	public Product(String name, String picturePath, String description, int price) {
		this.show = true;
		this.isSelected = false;
		this.name = name;
		this.picture = new ImageView(this.getClass().getResource(picturePath).toString());
		this.description = description;
		this.price = price;
		this.currentPrice = this.price;
		this.date = new Date();
	}

	public boolean isOnSale() {
		return this.price != this.currentPrice;
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

	public Date getDate() {
		return this.date;
	}

	public void setSelected(boolean selected) {
		this.isSelected = selected;
	}

	public boolean isSelected() {
		return this.isSelected;
	}

	public void setShow(boolean b) {
		this.show = b;
	}

	public boolean getSelected() {
		return this.isSelected;
	}

	public boolean getShow() {
		return this.show;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setCurrentPrice(float price) {
		this.currentPrice = price;
	}

	public float getCurrentPrice() {
		return this.currentPrice;
	}

	public float getPrice() {
		return this.price;
	}
}
