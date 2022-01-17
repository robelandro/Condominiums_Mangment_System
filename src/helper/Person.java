package helper;

import dbUtil.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String address;
    private String sex;

    public Person(String firstName, String lastName, int age, String address, String sex) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setAddress(address);
        this.setSex(sex);
    }

    public void removeUser(String tableName,String firstName,int Id){
        String sqlDelete = "DELETE FROM "+tableName+" WHERE "+" FirstName = '" +firstName+"'"+" AND "+"UserId = '"+Id+"'";
        Connection conn;
        PreparedStatement preparedStatement;
        try {
            conn = DbConnection.getConnection();
            preparedStatement = conn.prepareStatement(sqlDelete);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
            System.out.println("Delete Successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
