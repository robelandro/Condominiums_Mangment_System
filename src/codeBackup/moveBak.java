package codeBackup;

import dbUtil.DbConnection;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class moveBak {
    String residentId;
    String sqlRegister ="UPDATE Resident SET  ResidentId = ?,FirstName = ?,LastName = ?,Address = ?,Age = ?,Sex =?,PhoneNumber = ?,BlockNumber= ?,HouseNumber=?, RentStatus =? WHERE numCount=?";
    String sqlCheck ="SELECT * FROM IDGenerator";
    String sqlIn="INSERT INTO IDGenerator (residentGenerated) VALUES (2)";
    String [] checkabel ={"Resident","FirstName","LastName","HouseNumber", houseNumberPo.getText().trim()};
    Connection connection = null;
    PreparedStatement insert = null;
    PreparedStatement check;
    PreparedStatement autoIncrease;
    ResultSet resultSetCheck;
                try {
        connection = DbConnection.getConnection();
        insert = connection.prepareStatement(sqlIn);
        check =connection.prepareStatement(sqlCheck);
        resultSetCheck = check.executeQuery();
        if (resultSetCheck.next()){
            residentId =idGen+resultSetCheck.getInt("residentGenerated");
            int count;
            count =resultSetCheck.getInt("residentGenerated")+1;
            String counted =String.valueOf(count) ;
            String sqlUpdate ="UPDATE IDGenerator SET residentGenerated = "+counted;
            autoIncrease=connection.prepareStatement(sqlUpdate);
            autoIncrease.executeUpdate();
            autoIncrease.close();
            connection.close();

        }
        else {
            insert.executeUpdate();
            residentId =idGen+"1";
        }
        connection.close();
        String which;
        if(!dataMode.dbCheckInsertExit(checkabel[0],checkabel[1],checkabel[3],checkabel[4]).equals("error")){
            which =dataMode.dbCheckInsertExit(checkabel[0],checkabel[1],checkabel[3],checkabel[4]);
            System.out.println("erro");
        }
        else if(dataMode.houseNumberExit(houseNumberPo.getText().trim())){
            System.out.println("ppp");
            which = "error";
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("UNHALLOWED ACTION");
            alert.setHeaderText("Duplicated House Number");
            alert.showAndWait();
        }
        else{
            which = dataMode.dbCheckInsert(checkabel[0],checkabel[1],checkabel[2]);
            System.out.println("no et");
        }
        String [] valueRe ={residentId,firstNamePo.getText(),lastNamePo.getText(),addressPo.getText(),agePo.getText(),sexP,phoneNumberPo.getText(),blockNumberPo.getText(),houseNumberPo.getText(),rentP,which};
        dataMode.updateTableSql(sqlRegister,valueRe);
        infoPo.setText("Successes");
    } catch (
    SQLException e) {
        try {
            insert.executeUpdate();
            connection.close();
            residentId =idGen+"1";
            String which = dataMode.dbCheckInsert(checkabel[0],checkabel[1],checkabel[2]);
            String [] valueRe ={residentId,firstNamePo.getText(),lastNamePo.getText(),addressPo.getText(),agePo.getText(),sexP,phoneNumberPo.getText(),blockNumberPo.getText(),houseNumberPo.getText(),rentP,which};
            dataMode.updateTableSql(sqlRegister,valueRe);
            infoPo.setText("Successes");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        e.printStackTrace();
    }
}
