package helper.people;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import dbUtil.DbConnection;
import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopUpRegistration {

    @FXML
    private ToggleGroup Rent;

    @FXML
    private ToggleGroup Sex;

    @FXML
    private TextField addressPo;

    @FXML
    private TextField agePo;

    @FXML
    private TextField blockNumberPo;

    @FXML
    private JFXButton cancelPo;

    @FXML
    private JFXRadioButton femalePo;

    @FXML
    private TextField firstNamePo;

    @FXML
    private TextField houseNumberPo;

    @FXML
    private Label infoPo;

    @FXML
    private TextField lastNamePo;

    @FXML
    private JFXRadioButton malePo;

    @FXML
    private JFXRadioButton ownerPo;

    @FXML
    private TextField phoneNumberPo;

    @FXML
    private JFXButton registerPo;

    @FXML
    private JFXRadioButton rentPo;

    @FXML
    void cancelClicked(ActionEvent event) {

    }

    @FXML
    void registerClicked(ActionEvent event) {
        String idGen = null;
        String tableName ="Resident";
        String sexP = null ;
        String rentP = null;
        SqlDataMode dataMode = new SqlDataMode();
        try{
            if(rentPo.isSelected()){
                idGen ="RT";
                rentP = "Rent";
            }
            if (ownerPo.isSelected()){
                rentP = "Owner";
                idGen ="OW";
            }
            if (malePo.isSelected()){
                sexP = "Male";
            }
            if (femalePo.isSelected()){
                sexP = "Female";
            }
            boolean checkMe=firstNamePo.getText().isEmpty() || lastNamePo.getText().isEmpty() || addressPo.getText().isEmpty() || agePo.getText().isEmpty() || phoneNumberPo.getText().isEmpty() || blockNumberPo.getText().isEmpty() || houseNumberPo.getText().isEmpty() || sexP == null || rentPo ==null;
            if (!(checkMe)){
                String residentId;
                String sqlCheck ="SELECT * FROM IDGenerator";
                String sqlIn="INSERT INTO IDGenerator (residentGenerated) VALUES (2)";
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
                    dataMode.addDataResident(residentId,tableName,firstNamePo.getText(),lastNamePo.getText(),addressPo.getText(),agePo.getText(),sexP,phoneNumberPo.getText(),blockNumberPo.getText(),houseNumberPo.getText(),rentP);
                    infoPo.setText("Successes");
                } catch (SQLException e) {
                    try {
                        insert.executeUpdate();
                        connection.close();
                        residentId =idGen+"1";
                        dataMode.addDataResident(residentId,tableName,firstNamePo.getText(),lastNamePo.getText(),addressPo.getText(),agePo.getText(),sexP,phoneNumberPo.getText(),blockNumberPo.getText(),houseNumberPo.getText(),rentP);
                        infoPo.setText("Successes");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
            else {
                infoPo.setText("Information \nis Incomplete");
            }

        }catch (NullPointerException e){
            System.out.println(e);
            infoPo.setText("Information \nis Incomplete");
        }
    }


}
