package dbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDataMode {

    public void createTableResident(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
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

    public void addDataResident(String tableName, String firstName, String lastName, String address , int age , String sex, int phoneNumber, int blockNumber, int houseNumber, boolean rentStatus){
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
            statement.setBoolean(9,rentStatus);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void addDataStaff(String tableName, String firstName, String lastName, String address , int age , String sex, int phoneNumber,String workResponsibility){
        String sqlInsert = "INSERT INTO "+tableName+"( FirstName,LastName,Address,Age,Sex,PhoneNumber,WorkResponsibility) VALUES (?,?,?,?,?,?,?)";
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
            statement.setString(7,workResponsibility);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTableStaff(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "FirstName STRING,"+
                "LastName STRING,"+
                "Address STRING,"+
                "Age INTEGER,"+
                "Sex STRING,"+
                "PhoneNumber INTEGER,"+
                "WorkResponsibility STRING)";
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

    public void addDataGuest(String tableName, String firstName, String lastName, String address , int age , String sex, int phoneNumber){
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

    public void createTableGuest(String tableName){
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
    public void loginTable(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "UserName STRING,"+
                "Password STRING,"+
                "AccessLevel STRING)";
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
    public void loginTableAdd(String tableName,String userName,String password,String accessLevel){
        String sqlInsert = "INSERT INTO "+tableName+"( UserName,Password,AccessLevel) VALUES (?,?,?)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlInsert);
            statement.setString(1,userName);
            statement.setString(2,password);
            statement.setString(3,accessLevel);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void programTracker(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "StartUp INTEGER)";
        String sqlInsert = "INSERT INTO "+tableName+" (StartUp) VALUES (0)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlTable);
            statement.execute();
            System.out.println("Table created successfully.");
            statement = connection.prepareStatement(sqlInsert);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Table created Excite.");

            /*System.exit(1);*/
        }
    }


    public boolean isNotStarUp(String tableName){
        String sqlRead = "SELECT * FROM "+tableName+" WHERE UserId = 1";
        Connection connection ;
        PreparedStatement statement ;
        ResultSet resultSet;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(sqlRead);
            resultSet = statement.executeQuery();
            return resultSet.next();
        }
        catch (SQLException e){
            return false;
        }

    }

}
