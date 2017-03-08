package model;

import javafx.beans.property.StringProperty;

import java.util.List;

public class Shop {

	private StringProperty location, telephone, open, close, email;
	private List<Product> products;

	public Shop(StringProperty location, StringProperty telephone, StringProperty open, StringProperty close, StringProperty email, List<Product> products) {
		this.location = location;
		this.telephone = telephone;
		this.open = open;
		this.close = close;
		this.email = email;
		this.products = products;
	}
}