package model;

public class Information {

    private String phone, email, openDay, desc, clue;
    private int openHour, closeHour;
    private int floor;

    public Information(String phone, String email, String openDay, int openHour, int closeHour, String desc, String clue, int floor) {
        this.phone = phone;
        this.email = email;
        this.openDay = openDay;
        this.openHour = openHour;
        this.closeHour = closeHour;
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

    public int getOpenHour() {
        return openHour;
    }

    public void setOpenHour(int openHour) {
        this.openHour = openHour;
    }

    public int getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(int openHour) {
        this.closeHour = openHour;
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
