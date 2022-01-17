package helper;

import dbUtil.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Resident extends Person{
    private int blockNumber;
    private int phoneNumber;
    private int houseNumber;
    private boolean rentStatus;

    public Resident(String firstName, String lastName, int age, String address, String sex, int blockNumber, int phoneNumber, int houseNumber, boolean rentStatus) {
        super(firstName, lastName, age, address, sex);
        this.blockNumber = blockNumber;
        this.phoneNumber = phoneNumber;
        this.houseNumber = houseNumber;
        this.rentStatus = rentStatus;
    }

    public void registration(){
        String tableName = "Resident";
        createTable(tableName);
        addData(tableName,getFirstName(),getLastName(),getAddress(),getAge(),getSex(),getPhoneNumber(),getBlockNumber(),getHouseNumber(),isRentStatus());
    }
    public static void createTable(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (Id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "FirstName STRING,"+
                "LastName STRING,"+
                "Address STRING,"+
                "Age INTEGER,"+
                "Sex STRING,"+
                "PhoneNumber INTEGER,"+
                "BlockNumber INTEGER,"+
                "HouseNumber INTEGER,"+
                "RentStatus BOOLEAN)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlTable);
            statement.execute();
            statement.close();
            connection.close();
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Table created Excite.");

            /*System.exit(1);*/
        }
    }

    public Resident(String firstName, String lastName, int age, String address, String sex, boolean rentStatus) {
        super(firstName, lastName, age, address, sex);
        this.setRentStatus(rentStatus);
    }

    public static void addData(String tableName, String firstName, String lastName, String address , int age , String sex, int phoneNumber, int blockNumber, int houseNumber, boolean rentStatus){
        String sqlInsert = "INSERT INTO "+tableName+"( FirstName,LastName,Address,Age,Sex,PhoneNumber,BlockNumber,HouseNumber,RentStatus) VALUES (?,?,?,?,?,?,?,?,?)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlInsert);
            statement.setString(1,firstName);
            statement.setString(2,lastName);
            statement.setString(3,address);
            statement.setInt(4,age);
            statement.setString(5,sex);
            statement.setInt(6,phoneNumber);
            statement.setInt(7,blockNumber);
            statement.setInt(8,houseNumber);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void check (){

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
