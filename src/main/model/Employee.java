package model;

import javafx.scene.image.ImageView;

public class Employee {

	private String firstName, name, job;
	private ImageView picture;

	public Employee(String firstName, String name, String job, String picturePath) {
		this.firstName = firstName;
		this.name = name;
		this.job = job;
		this.picture = new ImageView(this.getClass().getResource(picturePath).toString());
		this.picture.setFitHeight(165);
		this.picture.setFitWidth(165);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public ImageView getPicture() {
		return picture;
	}

	public void setPicture(ImageView picture) {
		this.picture = picture;
	}
}
