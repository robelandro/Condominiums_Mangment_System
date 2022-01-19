package helper;

import dbUtil.SqlDataMode;

public class Guest extends Person{
    private int phoneNumber;

    public Guest(String firstName, String lastName, int age, String address, String sex, int phoneNumber) {
        super(firstName, lastName, age, address, sex);
        this.setPhoneNumber(phoneNumber);
    }

    public void registration(){
        String tableName = "Guest";
        SqlDataMode sqlDataMode = new SqlDataMode();
        sqlDataMode.createTableGuest(tableName);
        sqlDataMode.addDataGuest(tableName,getFirstName(),getLastName(),getAddress(),getAge(),getSex(),getPhoneNumber());
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
