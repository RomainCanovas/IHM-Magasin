package model;


import javafx.scene.image.Image;

import java.time.LocalDate;

public class Product {

	private String name, description;
	private float price;
	private float currentPrice;
	private Image picture;
	private boolean isSelected, show, inStock;
	private LocalDate date;

	public Product(String name, String picturePath, String description, int price, boolean inStock) {
		this.show = true;
		this.isSelected = false;
		this.name = name;
		this.picture = new Image(this.getClass().getResource(picturePath).toString());
		this.description = description;
		this.price = price;
		this.currentPrice = this.price;
		this.date = LocalDate.now();
		this.inStock = inStock;
	}

	public boolean isOnSale() {
		return this.price != this.currentPrice;
	}

	public Image getPicture() {
		return this.picture;
	}

	public String getName() {
		return this.name;
	}

	public LocalDate getDate() {
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

	public String getDescription() {
		return description;
	}

	public boolean isInStock() {
		return inStock;
	}
}
