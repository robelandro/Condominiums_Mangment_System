package helper.Info;


public class BasicInfo {
    private String firstName;
    private String nameId;
    private String lastName;
    private String age;
    private String address;
    private String sex;
    public BasicInfo(){

    }

    public BasicInfo(String firstName, String nameId) {
        this.firstName = firstName;
        this.nameId = nameId;
    }

    public BasicInfo(String firstName, String nameId, String lastName, String age, String address, String sex) {
        this.firstName = firstName;
        this.nameId = nameId;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public BasicInfo(String firstName, String lastName, String age, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
