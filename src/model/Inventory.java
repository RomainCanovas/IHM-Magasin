package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

	private List<Product> products;

	public Inventory() {
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
}
