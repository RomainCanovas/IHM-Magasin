package model;

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

	public List<Product> isNew() {

		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(Product::isNew).collect(Collectors.toList()));

		return products;
	}

	public Map<String, Product> getCategories() {
		Map<String, Product> map = new HashMap<>();

		for (Map.Entry<String, List<Product>> entry : this.products.entrySet())
			map.put(entry.getKey(), entry.getValue().get(0));

		return map;
	}

	public List<Product> getCategory(String key) {
		return this.products.get(key);
	}
}
