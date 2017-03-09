package model;

public class Information {

	private String phone, email, openDay, openHour, desc, clue;
	private int floor;

	public Information(String phone, String email, String openDay, String openHour, String desc, String clue, int floor) {
		this.phone = phone;
		this.email = email;
		this.openDay = openDay;
		this.openHour = openHour;
		this.desc = desc;
		this.clue = clue;
		this.floor = floor;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOpenDay() {
		return openDay;
	}

	public void setOpenDay(String openDay) {
		this.openDay = openDay;
	}

	public String getOpenHour() {
		return openHour;
	}

	public void setOpenHour(String openHour) {
		this.openHour = openHour;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getClue() {
		return clue;
	}

	public void setClue(String clue) {
		this.clue = clue;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
}
