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
		this.reSize(165, 165);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	private void reSize(double height, double width) {
		this.picture.setFitWidth(width);
		this.picture.setFitHeight(height);
	}

	public ImageView getPicture() {
		return picture;
	}
}
