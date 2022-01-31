package codeBackup;

import dbUtil.SqlDataMode;



public class Resident extends Person{
    private int blockNumber;
    private int phoneNumber;
    private int houseNumber;
    private boolean rentStatus;

    public Resident(String firstName, String lastName, int age, String address, String sex, int blockNumber, int phoneNumber, int houseNumber, boolean rentStatus) {
        super(firstName, lastName, age, address, sex);
        this.setBlockNumber(blockNumber);
        this.setPhoneNumber(phoneNumber);
        this.setHouseNumber(houseNumber);
        this.setRentStatus(rentStatus);
    }

    public void registration(){
        String tableName = "Resident";
        SqlDataMode sqlDataMode = new SqlDataMode();
        //sqlDataMode.addDataResident(tableName,getFirstName(),getLastName(),getAddress(),getAge(),getSex(),getPhoneNumber(),getBlockNumber(),getHouseNumber(),isRentStatus());
    }


    public void check (String firstName,int residentId){

    }


    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public boolean isRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(boolean rentStatus) {
        this.rentStatus = rentStatus;
    }
}
