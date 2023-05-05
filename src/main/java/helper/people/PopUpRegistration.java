package helper.people;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import dbUtil.DbConnection;
import dbUtil.SqlDataMode;
import helper.Info.ResidentInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private TextField areaPo;

    @FXML
    private TextField floorPo;

    @FXML
    private TextField partitionPo;

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
        String sexP = null ;
        String rentP = null;
        SqlDataMode dataMode = new SqlDataMode();
        try{
            if(rentPo.isSelected()){
                rentP = "Rent";
            }
            if (ownerPo.isSelected()){
                rentP = "Owner";
            }
            if (malePo.isSelected()){
                sexP = "Male";
            }
            if (femalePo.isSelected()){
                sexP = "Female";
            }
            boolean checkMe=firstNamePo.getText().trim().isEmpty() || lastNamePo.getText().trim().isEmpty() || areaPo.getText().trim().isEmpty() || agePo.getText().trim().isEmpty() || phoneNumberPo.getText().trim().isEmpty() || blockNumberPo.getText().trim().isEmpty() || houseNumberPo.getText().trim().isEmpty() || sexP == null || rentP ==null;
            if (!(checkMe)){
                ResidentInfo residentInfo = new ResidentInfo(firstNamePo.getText().trim(),lastNamePo.getText().trim(),agePo.getText().trim(),sexP,blockNumberPo.getText().trim(),phoneNumberPo.getText().trim(),houseNumberPo.getText().trim(),rentP,areaPo.getText().trim(),floorPo.getText().trim(),partitionPo.getText().trim());
                if (residentInfo.register()){
                    infoPo.setText("Success");
                }
                else {
                    infoPo.setText("Information \nis Incomplete");
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
