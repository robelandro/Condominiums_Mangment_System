package helper.physical;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class HouseHoldeControler implements Initializable {

    @FXML
    private JFXButton checkPressed;

    @FXML
    private TextField fristName;

    @FXML
    private TableView<HouseHoldData> houseHoldTAb;

    @FXML
    private TextField nameOfObject;

    @FXML
    private TableColumn<HouseHoldData, String> nameOfObjectTa;

    @FXML
    private TableColumn<HouseHoldData, String> nameTA;

    @FXML
    private TextField residentID;

    @FXML
    private TableColumn<HouseHoldData, String> residentIdTAb;

    @FXML
    private JFXButton rigester;

    @FXML
    private Spinner<String> riskySpinnner;


    @FXML
    private Spinner<String> paymentPurpose;

    @FXML
    private TableColumn<HouseHoldData, String> riskyTab;
    ObservableList<String> stringObservableList2 = FXCollections.observableArrayList();
    ObservableList<HouseHoldData>  houseHoldData = FXCollections.observableArrayList();
    ObservableList<String> stringObservableList = FXCollections.observableArrayList(
            "High","Medium","Low","Non"
    );

    @FXML
    void removePressed(ActionEvent event) {

    }

    @FXML
    void rigesterPressed(ActionEvent event) {
        HouseHold houseHold = new HouseHold();
        houseHold.registerHouseHold(fristName.getText().trim(),residentID.getText().trim(),nameOfObject.getText().trim(),riskySpinnner.getValue().trim(),paymentPurpose.getValue().trim());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory <String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(stringObservableList);
        riskySpinnner.setValueFactory(valueFactory);
        loadData1();
    }
    public void loadData1(){
        String sql ="SELECT FirstName , ResidentId , NameOfObject , Risky From HouseHold";
        String [] column ={"FirstName" , "ResidentId" , "NameOfObject" , "Risky"};
        ArrayList<String> read = new ArrayList<String>();
        SqlDataMode dataMode = new SqlDataMode();
        String [][] readed = dataMode.readTable(sql,column);
        for (String[] strings : readed) {
            Collections.addAll(read, strings);
            houseHoldData.add(new HouseHoldData(read.get(0),read.get(1),read.get(2),read.get(3)));
            read.clear();
        }
        columnTable(houseHoldData);
    }
    public void columnTable(ObservableList<HouseHoldData> dataObservableList1){
        nameTA.setCellValueFactory(new PropertyValueFactory<>("name"));
        residentIdTAb.setCellValueFactory(new PropertyValueFactory<>("residentId"));
        nameOfObjectTa.setCellValueFactory(new PropertyValueFactory<>("nameOfObject"));
        riskyTab.setCellValueFactory(new PropertyValueFactory<>("risky"));

        houseHoldTAb.setItems(dataObservableList1);
    }
    public void setRiskySpinnner(){
        String s ="Select Distinct(PaymentPurpose) From PaymentTable";
        String [] column ={"PaymentPurpose"};
        ArrayList<String> read = new ArrayList<String>();
        SqlDataMode dataMode = new SqlDataMode();
        String [][] readed = dataMode.readTable(s,column);
        int n=0;
        for (String[] strings : readed) {

            Collections.addAll(read, strings);
            read.clear();
            n++;
        }

    }

}
