package model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {

	private String location, telephone, open, close, email;
	private List<Product> products;

	public Shop(String location, String telephone, String open, String close, String email) {
		this.location = location;
		this.telephone = telephone;
		this.open = open;
		this.close = close;
		this.email = email;
		this.products = new ArrayList<>();
	}

	public void addProduct(Product product) {
		this.products.add(product);
	}

	public void makeReduction(int reduction) {
		for (Product product : products)

			if (product.isInSales())
				product.updateReduction(reduction);

			else
				product.setReduction(reduction);

	}

	public List<Product> productInSales(){
		return this.products.stream().filter(Product::isInSales).collect(Collectors.toList());
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}