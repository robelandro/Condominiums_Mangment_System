package management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpRegistratin {

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

        String tableName ="Resident";
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
            boolean checkMe=firstNamePo.getText().isEmpty() || lastNamePo.getText().isEmpty() || addressPo.getText().isEmpty() || agePo.getText().isEmpty() || phoneNumberPo.getText().isEmpty() || blockNumberPo.getText().isEmpty() || houseNumberPo.getText().isEmpty() || sexP == null || rentPo ==null;
            if (!(checkMe)){
                dataMode.addDataResident(tableName,firstNamePo.getText(),lastNamePo.getText(),addressPo.getText(),agePo.getText(),sexP,phoneNumberPo.getText(),blockNumberPo.getText(),houseNumberPo.getText(),rentP);
                infoPo.setText("Successes");
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
