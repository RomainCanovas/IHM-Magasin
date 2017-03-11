package model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Inventory {

	private Map<String, List<Product>> products;

	public Inventory(Map<String, List<Product>> products) {
		this.products = products;
	}

	public List<Product> onSale() {

		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(Product::isOnSale).collect(Collectors.toList()));

		return products;
	}

	public Map<String, Product> getCategories() {
		Map<String, Product> map = new HashMap<>();

		for (Map.Entry<String, List<Product>> entry : this.products.entrySet())
			map.put(entry.getKey(), entry.getValue().get(0));

		return map;
	}
}
