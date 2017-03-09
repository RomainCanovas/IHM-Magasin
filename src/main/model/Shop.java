package model;

import java.util.List;

public class Shop {

	private Information info;
	private List<Employee> team;
	private Inventory inventory;

	public Shop(Information info, List<Employee> team, Inventory inventory) {
		this.info = info;
		this.team = team;
		this.inventory = inventory;
	}

	public List<Employee> getTeam() {
		return team;
	}

	public Information getInfo() {
		return info;
	}

	public Inventory getInventory() {
		return this.inventory;
	}
}