package helper.staf;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShiftData {
    private final StringProperty name;
    private final StringProperty responsibility;
    private final StringProperty monday;
    private final StringProperty tuesday;
    private final StringProperty wednesday;
    private final StringProperty thursday;
    private final StringProperty friday;
    private final StringProperty saturday;
    private final StringProperty sunday;

    public ShiftData(String name, String responsibility,String monday,String tuesday,String wednesday,String thursday,String friday,String saturday,String sunday) {
        this.name = new SimpleStringProperty(name);
        this.responsibility = new SimpleStringProperty(responsibility);
        this.monday = new SimpleStringProperty(monday);
        this.tuesday = new SimpleStringProperty(tuesday);
        this.wednesday = new SimpleStringProperty(wednesday);
        this.thursday = new SimpleStringProperty(thursday);
        this.friday = new SimpleStringProperty(friday);
        this.saturday = new SimpleStringProperty(saturday);
        this.sunday = new SimpleStringProperty(sunday);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getResponsibility() {
        return responsibility.get();
    }

    public StringProperty responsibilityProperty() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility.set(responsibility);
    }

    public String getMonday() {
        return monday.get();
    }

    public StringProperty mondayProperty() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday.set(monday);
    }

    public String getTuesday() {
        return tuesday.get();
    }

    public StringProperty tuesdayProperty() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday.set(tuesday);
    }

    public String getWednesday() {
        return wednesday.get();
    }

    public StringProperty wednesdayProperty() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday.set(wednesday);
    }

    public String getThursday() {
        return thursday.get();
    }

    public StringProperty thursdayProperty() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday.set(thursday);
    }

    public String getFriday() {
        return friday.get();
    }

    public StringProperty fridayProperty() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday.set(friday);
    }

    public String getSaturday() {
        return saturday.get();
    }

    public StringProperty saturdayProperty() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday.set(saturday);
    }

    public String getSunday() {
        return sunday.get();
    }

    public StringProperty sundayProperty() {
        return sunday;
    }

    public void setSunday(String sunday) {
        this.sunday.set(sunday);
    }
}
