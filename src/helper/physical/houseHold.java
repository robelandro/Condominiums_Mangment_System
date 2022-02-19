package helper.physical;

import dbUtil.DbConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class houseHold extends CarManagement implements TobeApplied {
    public void registerHouseHold(String firstName , String residentId,String nameOfObject,String risky,String purpose){
        if (checkForPayment(firstName,residentId,purpose) && checkInResident(firstName,residentId)){
            String  sqlE = "INSERT INTO HouseHold " +
                    "(FirstName,ResidentId,NameOfObject,Risky) " +
                    "Values(?,?,?,?)";
            try {
                Connection connection = DbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sqlE);
                preparedStatement.setString(1,firstName);
                preparedStatement.setString(2,residentId);
                preparedStatement.setString(3,nameOfObject);
                preparedStatement.setString(4,risky);
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Unable To Register");
            alert.setHeaderText("May be payment is not completed");
            alert.setContentText("OR Please Make Sure The Information Provided is Correct");
            alert.show();
        }
    }
    public void removeHouseHold(String residentID,String nameOfObject){
        String delete ="Delete From HouseHold " +
                "Where NameOfObject ='"+nameOfObject+"' And ResidentId = '"+residentID+"'";
        try {
            Connection connection;
            PreparedStatement preparedStatement;
            connection=DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
