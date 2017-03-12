package model;

import java.util.*;
import java.util.stream.Collectors;

public class Inventory {

	private Map<String, List<Product>> products;
	private Date dataNews;

	public Inventory(Map<String, List<Product>> products) {
		this.products = products;
		this.dataNews = new Date();
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
			products.addAll(list.stream().filter(product -> product.getDate().after(this.dataNews)).collect(Collectors.toList()));

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

	public List<Product> search(String name) {

		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(product -> product.getName().toUpperCase().contains(name)).collect(Collectors.toList()));

		return products;

	}
}
