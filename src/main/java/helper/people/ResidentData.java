package helper.people;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ResidentData {
    private final StringProperty firstName;
    private final IntegerProperty userId;
    private final StringProperty residentId;
    private final StringProperty lastName;
    private final StringProperty age;
    private final StringProperty sex;
    private final StringProperty blockNumber;
    private final StringProperty phoneNumber;
    private final StringProperty houseNumber;
    private final StringProperty rentStatus;
    private final StringProperty area;
    private final StringProperty floor;
    private final StringProperty part;

    public ResidentData(int userId,String residentId,String firstName, String lastName, String age, String sex, String blockNumber, String phoneNumber, String houseNumber, String rentStatus, String area, String floor, String part){
        this.residentId = new SimpleStringProperty(residentId);
        this.userId = new SimpleIntegerProperty(userId);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleStringProperty(age);
        this.sex = new SimpleStringProperty(sex);
        this.blockNumber = new SimpleStringProperty(blockNumber);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.houseNumber = new SimpleStringProperty(houseNumber);
        this.rentStatus = new SimpleStringProperty(rentStatus);
        this.area = new SimpleStringProperty(area);
        this.floor = new SimpleStringProperty(floor);
        this.part = new SimpleStringProperty(part);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public int getUserId() {
        return userId.get();
    }

    public IntegerProperty userIdProperty() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId.set(userId);
    }

    public String getResidentId() {
        return residentId.get();
    }

    public StringProperty residentIdProperty() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId.set(residentId);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAge() {
        return age.get();
    }

    public StringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getSex() {
        return sex.get();
    }

    public StringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public String getBlockNumber() {
        return blockNumber.get();
    }

    public StringProperty blockNumberProperty() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber.set(blockNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getHouseNumber() {
        return houseNumber.get();
    }

    public StringProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public String getRentStatus() {
        return rentStatus.get();
    }

    public StringProperty rentStatusProperty() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus.set(rentStatus);
    }

    public String getArea() {
        return area.get();
    }

    public StringProperty areaProperty() {
        return area;
    }

    public void setArea(String area) {
        this.area.set(area);
    }

    public String getFloor() {
        return floor.get();
    }

    public StringProperty floorProperty() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor.set(floor);
    }

    public String getPart() {
        return part.get();
    }

    public StringProperty partProperty() {
        return part;
    }

    public void setPart(String part) {
        this.part.set(part);
    }
}
