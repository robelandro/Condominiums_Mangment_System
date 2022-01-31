package codeBackup;

import dbUtil.SqlDataMode;



public class Staff extends Person{
    private String workResponsibility;
    private int phoneNumber;

    public Staff(String firstName, String lastName, int age, String address, String sex, String workResponsibility, int phoneNumber) {
        super(firstName, lastName, age, address, sex);
        this.workResponsibility = workResponsibility;
        this.phoneNumber = phoneNumber;
    }

    public void registration(){
        String tableName = "Staff";
        SqlDataMode sqlDataMode = new SqlDataMode();
        sqlDataMode.createTableStaff(tableName);
        sqlDataMode.addDataStaff(tableName,getFirstName(),getLastName(),getAddress(),getAge(),getSex(),getPhoneNumber(),getWorkResponsibility());
    }



    public String getWorkResponsibility() {
        return workResponsibility;
    }

    public void setWorkResponsibility(String workResponsibility) {
        this.workResponsibility = workResponsibility;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
