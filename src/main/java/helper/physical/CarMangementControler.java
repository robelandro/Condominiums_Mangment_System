package helper.physical;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import helper.staf.StaffData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class CarMangementControler implements Initializable {

    @FXML
    private TableColumn<CarData, String> carName;

    @FXML
    private TableColumn<CarData, String> carResdentId;

    @FXML
    private TableColumn<CarData, String> typeOfCar;

    @FXML
    private TableView<CarData> carTable;

    @FXML
    private JFXButton parkingTable;

    @FXML
    private TableColumn<CarData, String> plateNumber;

    @FXML
    private JFXButton registerCar;

    @FXML
    private JFXButton registerParking;

    @FXML
    private JFXButton removeCar;

    @FXML
    private JFXButton removeParking;

    ObservableList<CarData> carData = FXCollections.observableArrayList();



    @FXML
    void parkingTablePressed(ActionEvent event) {

    }

    @FXML
    void registerCarPressed(ActionEvent event) {

    }

    @FXML
    void registerParkingPressed(ActionEvent event) {

    }

    @FXML
    void removeCarPressed(ActionEvent event) {

    }

    @FXML
    void removeParkingPressed(ActionEvent event) {

    }

    public void loadData1(){
        String sql ="SELECT FirstName , ResidentId , TypeOfCar , PlateNumber From Car";
        String [] column ={"FirstName" , "ResidentId" , "TypeOfCar" , "PlateNumber"};
        ArrayList<String> read = new ArrayList<String>();
        SqlDataMode dataMode = new SqlDataMode();
        String [][] readed = dataMode.readTable(sql,column);
        for (String[] strings : readed) {
            Collections.addAll(read, strings);
            carData.add(new CarData(read.get(0),read.get(1),read.get(2),read.get(3)));
            read.clear();
        }
        columnTable(carData);
    }
    public void columnTable(ObservableList<CarData> dataObservableList1){
        carName.setCellValueFactory(new PropertyValueFactory<>("name"));
        carResdentId.setCellValueFactory(new PropertyValueFactory<>("residentId"));
        typeOfCar.setCellValueFactory(new PropertyValueFactory<>("typeOfcar"));
        plateNumber.setCellValueFactory(new PropertyValueFactory<>("plateNumber"));

        carTable.setItems(dataObservableList1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData1();
    }
}
