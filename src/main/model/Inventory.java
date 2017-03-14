package model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Inventory {

	private Map<String, List<Product>> products;
	private LocalDate dateNews;

	public Inventory(Map<String, List<Product>> products) {
		this.products = products;
		this.dateNews = LocalDate.now();
	}

	public List<Product> onSale() {

		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(product -> product.isOnSale() && product.getShow()).collect(Collectors.toList()));

		return products;
	}

	public List<Product> isNew() {

		List<Product> products = new ArrayList<>();


		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(product -> product.getDate().isAfter(this.dateNews) && product.getShow()).collect(Collectors.toList()));

		return products;
	}

	public Map<String, Product> getCategories() {
		Map<String, Product> map = new HashMap<>();

		for (Map.Entry<String, List<Product>> entry : this.products.entrySet())
			if (!entry.getValue().stream().filter(Product::getShow).collect(Collectors.toList()).isEmpty())
				map.put(entry.getKey(), entry.getValue().get(0));


		return map;
	}

	public List<Product> getCategory(String key) {
		return this.products.get(key).stream().filter(Product::getShow).collect(Collectors.toList());
	}

	public List<Product> search(String name) {

		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(product -> product.getName().toUpperCase().contains(name) && product.getShow()).collect(Collectors.toList()));

		return products;

	}

	public List<Product> getAll() {

		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list);

		return products;
	}

	public List<Product> getNotShown() {
		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(product -> !product.getShow()).collect(Collectors.toList()));

		return products;
	}

	public List<Product> getShown() {
		List<Product> products = new ArrayList<>();

		for (List<Product> list : this.products.values())
			products.addAll(list.stream().filter(product -> product.getShow()).collect(Collectors.toList()));

		return products;
	}

	public void setDate(LocalDate date) {
		this.dateNews = date;
	}
}
