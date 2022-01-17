package helper;

import dbUtil.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Guest extends Person{
    private int phoneNumber;

    public Guest(String firstName, String lastName, int age, String address, String sex, int phoneNumber) {
        super(firstName, lastName, age, address, sex);
        this.setPhoneNumber(phoneNumber);
    }

    public void registration(){
        String tableName = "Guest";
        createTable(tableName);
        addData(tableName,getFirstName(),getLastName(),getAddress(),getAge(),getSex(),getPhoneNumber());
    }

    @Override
    public void removeUser(String tableName, String firstName, int Id) {
        super.removeUser(tableName, firstName, Id);
    }

    public static void addData(String tableName, String firstName, String lastName, String address , int age , String sex, int phoneNumber){
        String sqlInsert = "INSERT INTO "+tableName+"( FirstName,LastName,Address,Age,Sex,PhoneNumber) VALUES (?,?,?,?,?,?)";
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
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "FirstName STRING,"+
                "LastName STRING,"+
                "Address STRING,"+
                "Age INTEGER,"+
                "Sex STRING,"+
                "PhoneNumber INTEGER)";
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
