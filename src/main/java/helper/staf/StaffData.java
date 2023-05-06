package helper.staf;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StaffData {
    private final StringProperty firstName;
    private final StringProperty nameId;
    private final StringProperty lastName;
    private final StringProperty age;
    private final StringProperty address;
    private final StringProperty sex;
    private final StringProperty responsibility;
    public StaffData(String firstName, String nameId, String lastName, String age, String address, String sex, String responsibility){
        this.firstName = new SimpleStringProperty(firstName);
        this.nameId = new SimpleStringProperty(nameId);
        this.lastName = new SimpleStringProperty(lastName);
        this.age = new SimpleStringProperty(age);
        this.address = new SimpleStringProperty(address);
        this.sex = new SimpleStringProperty(sex);
        this.responsibility = new SimpleStringProperty(responsibility);
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

    public String getNameId() {
        return nameId.get();
    }

    public StringProperty nameIdProperty() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId.set(nameId);
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

    public String getResponsibility() {
        return responsibility.get();
    }

    public StringProperty responsibilityProperty() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility.set(responsibility);
    }
}
