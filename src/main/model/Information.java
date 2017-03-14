package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Information {

	private StringProperty phone, email, openDay, closeDay, desc, commentary, clue, openHour, closeHour, openMin, closeMin, floor;

	public Information(String phone, String email, String openDay, String closeDay, String openHour, String openMin, String closeHour, String closeMin, String commentary, String desc, String clue, String floor) {
		this.phone = new SimpleStringProperty(phone);
		this.email = new SimpleStringProperty(email);
		this.openDay = new SimpleStringProperty(openDay);
		this.closeDay = new SimpleStringProperty(closeDay);
		this.openHour = new SimpleStringProperty(openHour);
		this.openMin = new SimpleStringProperty(openMin);
		this.closeHour = new SimpleStringProperty(closeHour);
		this.closeMin = new SimpleStringProperty(closeMin);
		this.commentary = new SimpleStringProperty(commentary);
		this.desc = new SimpleStringProperty(desc);
		this.clue = new SimpleStringProperty(clue);
		this.floor = new SimpleStringProperty(floor);
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public void setOpenDay(String openDay) {
		this.openDay.set(openDay);
	}

	public void setCloseDay(String closeDay) {
		this.closeDay.set(closeDay);
	}

	public void setOpenHour(String openHour) {
		this.openHour.set(openHour);
	}

	public void setOpenMin(String openMin) {
		this.openMin.set(openMin);
	}

	public void setCloseHour(String openHour) {
		this.closeHour.set(openHour);
	}

	public void setCloseMin(String closeMin) {
		this.closeMin.set(closeMin);
	}

	public void setCommentary(String commentary) {
		this.commentary.set(commentary);
	}

	public void setDesc(String desc) {
		this.desc.set(desc);
	}

	public void setClue(String clue) {
		this.clue.set(clue);
	}

	public void setFloor(String floor) {
		this.floor.set(floor);
	}

	public StringProperty commentaryProperty() {
		return commentary;
	}

	public StringProperty descProperty() {
		return desc;
	}

	public StringProperty clueProperty() {
		return clue;
	}

	public String getPhone() {
		return phone.get();
	}

	public String getEmail() {
		return email.get();
	}

	public String getOpenDay() {
		return openDay.get();
	}

	public String getCloseDay() {
		return closeDay.get();
	}

	public String getDesc() {
		return desc.get();
	}

	public String getCommentary() {
		return commentary.get();
	}

	public String getClue() {
		return clue.get();
	}

	public String getOpenHour() {
		return openHour.get();
	}

	public String getCloseHour() {
		return closeHour.get();
	}

	public String getOpenMin() {
		return openMin.get();
	}

	public String getCloseMin() {
		return closeMin.get();
	}

	public String getFloor() {
		return floor.get();
	}

	public StringProperty phoneProperty() {
		return phone;
	}

	public StringProperty emailProperty() {
		return email;
	}

	public StringProperty openDayProperty() {
		return openDay;
	}

	public StringProperty closeDayProperty() {
		return closeDay;
	}

	public StringProperty openHourProperty() {
		return openHour;
	}

	public StringProperty closeHourProperty() {
		return closeHour;
	}

	public StringProperty openMinProperty() {
		return openMin;
	}

	public StringProperty closeMinProperty() {
		return closeMin;
	}

	public StringProperty floorProperty() {
		return floor;
	}
}
