package management;


import javafx.beans.property.*;

public class ResidentData {
    private final IntegerProperty userId;
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty age;
    private final StringProperty address;
    private final StringProperty sex;
    private final StringProperty blockNumber;
    private final StringProperty phoneNumber;
    private final StringProperty houseNumber;
    private final StringProperty rentStatus;

    public ResidentData(int userId ,String firstName, String lastName, String age, String address, String sex, String blockNumber, String phoneNumber, String houseNumber, String rentStatus) {
        this.userId = new SimpleIntegerProperty(userId);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleStringProperty(age);
        this.address = new SimpleStringProperty(address);
        this.sex = new SimpleStringProperty(sex);
        this.blockNumber = new SimpleStringProperty(blockNumber);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.houseNumber = new SimpleStringProperty(houseNumber);
        this.rentStatus = new SimpleStringProperty(rentStatus);
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

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
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

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
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
}
