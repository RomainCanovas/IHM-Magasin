package model;

public class Information {

    private String phone, email, openDay, closeDay, commentary, desc, clue, openHour, closeHour, openMin, closeMin, floor;

    public Information(String phone, String email, String openDay, String closeDay, String openHour, String openMin, String closeHour, String closeMin, String commentary, String desc, String clue, String floor) {
        this.phone = phone;
        this.email = email;
        this.openDay = openDay;
        this.closeDay = closeDay;
        this.openHour = openHour;
        this.openMin = openMin;
        this.closeHour = closeHour;
        this.closeMin = closeMin;
        this.commentary = commentary;
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

    public String getCloseDay() {
        return closeDay;
    }

    public void setCloseDay(String closeDay) {
        this.closeDay = closeDay;
    }

    public String getOpenHour() {
        return openHour;
    }

    public void setOpenHour(String openHour) {
        this.openHour = openHour;
    }

    public String getOpenMin() {
        return openMin;
    }

    public void setOpenMin(String openMin) {
        this.openMin = openMin;
    }

    public String getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(String openHour) {
        this.closeHour = openHour;
    }

    public String getCloseMin() {
        return closeMin;
    }

    public void setCloseMin(String closeMin) {
        this.closeMin = closeMin;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
