package management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ResidentManger {

    @FXML
    private TableColumn<ResidentData, String> address;

    @FXML
    private TableColumn<ResidentData, String> age;

    @FXML
    private TableColumn<ResidentData, String> block;

    @FXML
    private TableColumn<ResidentData, String> firstName;

    @FXML
    private TableColumn<ResidentData, String> houseNumber;

    @FXML
    private TableColumn<ResidentData, String> lastName;

    @FXML
    private TableColumn<ResidentData, String> phoneNumber;

    @FXML
    private TableColumn<ResidentData, String> sex;

    @FXML
    private TableView<ResidentData> tableView;

    @FXML
    private TableColumn<ResidentData, String> userId;

    @FXML
    private TableColumn<ResidentData, String> rentStatusT;

    //
    @FXML
    private JFXButton addResident;

    @FXML
    private JFXButton removeResident;

    @FXML
    private TextField search;

    @FXML
    private JFXButton loadData;

    //
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
    public void cancelClicked(ActionEvent event) {

    }

    @FXML
    public void registerClicked(ActionEvent event) {
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

    @FXML
    public void addResidentP(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/management/popUpRegistratin.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Add Resident");
            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


        }

    @FXML
    public void removeResidentP(ActionEvent event) {

    }


    @FXML
    public void loadDataP(ActionEvent event) {
        String tableName ="Resident";
        SqlDataMode dataMode = new SqlDataMode();
        dataMode.readResident(tableName);
        this.userId.setCellValueFactory(new PropertyValueFactory<ResidentData, String>("userId"));
        this.firstName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("firstName"));
        this.lastName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("lastName"));
        this.age.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("age"));
        this.address.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("address"));
        this.sex.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("sex"));
        this.block.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("blockNumber"));
        this.phoneNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("phoneNumber"));
        this.houseNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("houseNumber"));
        this.rentStatusT.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("rentStatus"));
        this.tableView.setItems(null);
        this.tableView.setItems(dataMode.data);

    }

}
