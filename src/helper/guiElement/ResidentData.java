package helper.guiElement;


import javafx.beans.property.*;

public class ResidentData {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final IntegerProperty age;
    private final StringProperty address;
    private final StringProperty sex;
    private final IntegerProperty blockNumber;
    private final IntegerProperty phoneNumber;
    private final IntegerProperty houseNumber;
    private final BooleanProperty rentStatus;

    public ResidentData(String firstName, String lastName, int age, String address, String sex, int blockNumber, int phoneNumber, int houseNumber, boolean rentStatus) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleIntegerProperty(age);
        this.address = new SimpleStringProperty(address);
        this.sex = new SimpleStringProperty(sex);
        this.blockNumber = new SimpleIntegerProperty(blockNumber);
        this.phoneNumber = new SimpleIntegerProperty(phoneNumber);
        this.houseNumber = new SimpleIntegerProperty(houseNumber);
        this.rentStatus = new SimpleBooleanProperty(rentStatus);
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

    public int getAge() {
        return age.get();
    }

    public IntegerProperty ageProperty() {
        return age;
    }

    public void setAge(int age) {
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

    public int getBlockNumber() {
        return blockNumber.get();
    }

    public IntegerProperty blockNumberProperty() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber.set(blockNumber);
    }

    public int getPhoneNumber() {
        return phoneNumber.get();
    }

    public IntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public int getHouseNumber() {
        return houseNumber.get();
    }

    public IntegerProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public boolean isRentStatus() {
        return rentStatus.get();
    }

    public BooleanProperty rentStatusProperty() {
        return rentStatus;
    }

    public void setRentStatus(boolean rentStatus) {
        this.rentStatus.set(rentStatus);
    }
}
