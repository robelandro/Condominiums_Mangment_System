package helper.physical;

import dbUtil.DbConnection;
import dbUtil.SqlDataMode;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CarManagement implements TobeApplied{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public boolean checkInResident(String firstName , String residentId){
        SqlDataMode dataMode =new SqlDataMode();
        String sql = "SELECT ResidentId,FirstName FROM Resident WHERE Name = '"+firstName+"' AND ResidentId = '"+residentId+"'";
        String[] nameColumn ={"ResidentId","FirstName"};
        String[][] read =dataMode.readTable(sql,nameColumn);
        return !(read.length == 0);
    }
    public boolean checkForPayment(String firstName , String residentId,String purpose){
        SqlDataMode dataMode =new SqlDataMode();
        String sql = "SELECT ResidentId,Name FROM PaymentTable WHERE Name = '"+firstName+"' AND ResidentId = '"+residentId+"' AND PaymentPurpose ='"+purpose+"'";
        String[] nameColumn ={"Name","ResidentId"};
        String[][] read =dataMode.readTable(sql,nameColumn);
        return !(read.length == 0);
    }
    public boolean checkParking(String parkingName){
        String sql ="SELECT "+parkingName+" FROM Parking WHERE NumCount = 2";
        String[] nameColumn ={parkingName};
        SqlDataMode dataMode =new SqlDataMode();
        String [][] result =dataMode.readTable(sql,nameColumn);
        return !(result.length == 0);
    }
    public String numberOfLeftParking(String parkingName){
        if (checkParking(parkingName)){
            String sql ="SELECT "+parkingName+" FROM Parking WHERE NumCount = 2";
            String[] nameColumn ={parkingName};
            SqlDataMode dataMode =new SqlDataMode();
            String [][] result =dataMode.readTable(sql,nameColumn);
            return result[0][0];
        }
        else {
            return null;
        }
    }
    public void registerParking(String firstName,String residentId,String plateNumber,String purpose,String parkingName){
        //? left NumCount iS empty
        SqlDataMode dataMode =new SqlDataMode();
        String sql ="Update Parking " +
                "Set PlateNumber = ? " +
                "WHERE NumCount = '"+getNumCount(parkingName)+"'";
        String [] values ={plateNumber};
        if (checkForPayment(firstName, residentId, purpose) && checkInResident(firstName, residentId)&& checkParking(parkingName)){
            dataMode.updateTableSql(sql,values);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unable To Register");
            alert.setHeaderText("Unable To Register The Car");
            alert.setContentText("Please Make Sure The Information Provided is Correct");
            alert.show();
        }
    }
    public void registerCar(String firstName,String residentId,String typeOfCar,String plateNumber,String purpose){
        String  sqlE ="INSERT INTO Car " +
                "(FirstName,ResidentId,TypeOfCar,PlateNumber) " +
                "Values(?,?,?,?)";
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sqlE);
            preparedStatement.setString(1,firstName);
            preparedStatement.setString(2,residentId);
            preparedStatement.setString(3,typeOfCar);
            preparedStatement.setString(4,plateNumber);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void removeCar(String residentID,String plateNumber){
        String delete ="Delete From Car " +
                "Where PlateNumber ='"+plateNumber+"' And ResidentId = '"+residentID+"'";
        try {
            connection=DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void removeParking(String plateNumber,String parkingName){
        if (checkParking(parkingName)){
            String delete ="Update Parking " +
                    "Set PlateNumber = ?" +
                    "Where PlateNumber ='"+plateNumber+"'";
            String [] value={null};
            SqlDataMode dataMode = new SqlDataMode();
            dataMode.updateTableSql(delete,value);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unable To Remove");
            alert.setHeaderText("Unable To Remove The Car");
            alert.setContentText("Please Make Sure The Information Provided is Correct");
            alert.show();
        }
    }
    public String getNumCount(String parkingName){
        String numCount = null;
        if (checkParking(parkingName)){
            String sqlR = "Select "+parkingName+" From Parking Where "+parkingName+" IS NUll";
            try {
                connection=DbConnection.getConnection();
                preparedStatement =connection.prepareStatement(sqlR,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet resultSet = preparedStatement.executeQuery();
                resultSet.first();
                numCount = resultSet.getString("NumCount");
                connection.close();
                return numCount;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        else {
            return null;
        }
    }
    public void addParking(String packingName,String reservedNumber){
        if (checkParking(packingName)){
            System.out.println("Existing");
        }
        else {
        String sqlPark ="ALTER TABLE Parking" +
                "ADD "+packingName+"varchar(255)";
        String sqlInitial = "INSERT INTO Parking " +
                "("+packingName+")" +
                "Values(?)";
            try {
                connection = DbConnection.getConnection();
                preparedStatement = connection.prepareStatement(sqlPark);
                preparedStatement.executeUpdate();
                PreparedStatement preparedStatement1 = connection.prepareStatement(sqlInitial);
                preparedStatement1.setString(1,reservedNumber);
                preparedStatement1.executeUpdate();
                PreparedStatement preparedStatement12 = connection.prepareStatement(sqlInitial);
                preparedStatement12.setString(1,"0");
                preparedStatement12.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
