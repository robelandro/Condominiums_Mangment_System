package dbUtil;

import helper.people.ResidentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDataMode {

    public ObservableList<ResidentData> dataObservableList;

    public void createTableId(){
        String sqlTable ="CREATE TABLE IDGenerator (residentGenerated INTEGER)";
        Connection connection;
        PreparedStatement statement;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(sqlTable);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch (SQLException e){

        }
    }

    public void createTableResident(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "ResidentId STRING,"+
                "FirstName STRING,"+
                "LastName STRING,"+
                "Address STRING,"+
                "Age STRING,"+
                "Sex STRING,"+
                "PhoneNumber STRING,"+
                "BlockNumber STRING,"+
                "HouseNumber STRING,"+
                "RentStatus STRING)";
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

    public void addDataResident(String residentId,String tableName, String firstName, String lastName, String address , String age , String sex, String phoneNumber, String blockNumber, String houseNumber, String rentStatus){
        String sqlInsert = "INSERT INTO "+tableName+" (ResidentId,FirstName,LastName,Address,Age,Sex,PhoneNumber,BlockNumber,HouseNumber,RentStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlInsert);
            statement.setString(1,residentId);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,address);
            statement.setString(5,age);
            statement.setString(6,sex);
            statement.setString(7,phoneNumber);
            statement.setString(8,blockNumber);
            statement.setString(9,houseNumber);
            statement.setString(10,rentStatus);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginTable(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "UserName STRING,"+
                "Password STRING,"+
                "AccessLevel STRING,"+
                "Hint STRING)";
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
    public void loginTableAdd(String tableName,String userName,String password,String accessLevel,String hint){
        String sqlInsert = "INSERT INTO "+tableName+"( UserName,Password,AccessLevel,Hint) VALUES (?,?,?,?)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlInsert);
            statement.setString(1,userName);
            statement.setString(2,password);
            statement.setString(3,accessLevel);
            statement.setString(4,hint);

            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void programTracker(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (UserId INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "StartUp BOOLEAN," +
                "RememberMe BOOLEAN)";
        String sqlInsert = "INSERT INTO "+tableName+" (StartUp,RememberMe) VALUES (true,false)";
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

    public boolean rememberMe(String tableName){
        String sqlRead = "SELECT * FROM "+tableName+
                " WHERE UserId = 1";
        Connection connection = null;
        PreparedStatement statement ;
        ResultSet resultSet;
        try {
            connection =DbConnection.getConnection();
            statement = connection.prepareStatement(sqlRead);
            resultSet = statement.executeQuery();
            if(resultSet.getBoolean("RememberMe")){
                return true;
            }
            return false;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void rememberMeUpdate(String tableName ,boolean rem){
        String rememberUpdater = "UPDATE "+tableName+
                " SET RememberMe = ?"+
                " WHERE UserId = 1";
        Connection connection = null;
        PreparedStatement statement ;
        try {
            connection=DbConnection.getConnection();
            statement = connection.prepareStatement(rememberUpdater);
            statement.setBoolean(1,rem);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isStarUp(String tableName){
        String sqlRead = "SELECT * FROM "+tableName+" WHERE UserId = 1";
        Connection connection = null;
        PreparedStatement statement ;
        ResultSet resultSet ;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(sqlRead);
            resultSet = statement.executeQuery();
            if (resultSet.getBoolean("StartUp")){
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException e){
            return false;
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public String hintForget(String tableName,String hint){

        String sqlRead = "SELECT * FROM "+tableName+" WHERE Hint = ?";
        Connection connection ;
        PreparedStatement statement ;
        ResultSet resultSet;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(sqlRead);
            statement.setString(1,hint);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
            return "Your Credential \nUsername : "+resultSet.getString("UserName")+
                    "\nPassword : "+resultSet.getString("Password");
            }
            else {
                return "No Credential With this input";
            }

        }
        catch (SQLException e){
            return "No Credential With this input";
        }
    }
    public void readResident (String tableName){
        Connection connection = null;
        ResultSet resultSet = null;
        dataObservableList = FXCollections.observableArrayList();
        String sqlRead ="SELECT * FROM "+tableName;

        try {
            connection = DbConnection.getConnection();
            dataObservableList = FXCollections.observableArrayList();
            PreparedStatement statement =connection.prepareStatement(sqlRead);
            resultSet =statement.executeQuery();
            while (resultSet.next()){
                dataObservableList.add(new ResidentData(resultSet.getString(2),resultSet.getInt(1),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getString(11)));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    public void createPaymentTable(){

    }
    public void readPayment(){

    }

}
