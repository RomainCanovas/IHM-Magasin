package model;

import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {

	private Map<ImageView, List<Product>> products;

	public Inventory(Map<ImageView, List<Product>> products) {
		this.products = products;
	}

	public List<Product> onSale() {

		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(Product::isOnSale).collect(Collectors.toList()));

		return products ;
	}
}
