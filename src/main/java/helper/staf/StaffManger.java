package helper.staf;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import helper.Info.StaffInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class StaffManger implements Initializable {

    @FXML
    private JFXButton SavePStafInf;

    @FXML
    private Spinner<String> accessLevel;


    @FXML
    private TableView<StaffData> staffDataTabel;

    @FXML
    private TableColumn<StaffData, String> addressTAb;

    @FXML
    private TextField addressTxt;

    @FXML
    private TableColumn<StaffData, String> ageTAb;

    @FXML
    private TextField ageTxt;

    @FXML
    private TextField confirmPassword;

    @FXML
    private TextField hint;

    @FXML
    private Label info;

    @FXML
    private TableColumn<StaffData, String> lastNameTAb;

    @FXML
    private TextField lastNameTxt;

    @FXML
    private JFXButton loginTable;

    @FXML
    private TableColumn<StaffData, String> nameIdTab;

    @FXML
    private TextField nameIdTxt;

    @FXML
    private TableColumn<StaffData, String> nameTAb;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField password;

    @FXML
    private TableColumn<StaffData, String> responsibilityTab;

    @FXML
    private TextField responsibilityTxt;

    @FXML
    private JFXButton saveCredential;

    @FXML
    private TableColumn<StaffData, String> sexTab;

    @FXML
    private TextField sexTxt;

    @FXML
    private TextField userName;

    ObservableList<StaffData> loginData = FXCollections.observableArrayList();

    @FXML
    void SavePStafInf(ActionEvent event) {
        boolean b =nameTxt.getText().isEmpty()||nameIdTxt.getText().isEmpty()||lastNameTxt.getText().isEmpty()||ageTxt.getText().isEmpty()||addressTxt.getText().isEmpty()||sexTxt.getText().isEmpty()||responsibilityTxt.getText().isEmpty();
        if (!b){
            StaffInfo staffInfo = new StaffInfo(nameTxt.getText(),nameIdTxt.getText(),lastNameTxt.getText(),ageTxt.getText(),addressTxt.getText(),sexTxt.getText(),responsibilityTxt.getText());
            staffInfo.registerStaff();
            info.setText("Success");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Empty Filed Is Present");
            alert.show();
        }
    }

    @FXML
    void loginTable(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/helper/staf/loginTable.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Login Credential");
            stage.setResizable(false);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void saveCredential(ActionEvent event) {
        boolean b =userName.getText().trim().isEmpty()||password.getText().trim().isEmpty()||accessLevel.getValue().trim().isEmpty()||hint.getText().isEmpty();
        System.out.println(b);
        if (!b){
            StaffManage staffManage = new StaffManage();
            info.setText("Success");
            staffManage.registerStaffLogin(userName.getText().trim(),password.getText().trim(),accessLevel.getValue().trim(),hint.getText());
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Empty Filed Is Present");
            alert.show();
        }

    }
    ObservableList<String> list = FXCollections.observableArrayList(
            "Broker","Staff","Security"
    );
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory <String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        accessLevel.setValueFactory(valueFactory);
        loadData1();
    }
    public void loadData1(){
        String sql ="SELECT FirstName , NameId , LastName , Age , Address , Sex , Responsibility  From Staff";
        String [] column ={"FirstName", "NameId" , "LastName" , "Age" , "Address" , "Sex" , "Responsibility"};
        ArrayList<String> read = new ArrayList<String>();
        SqlDataMode dataMode = new SqlDataMode();
        String [][] readed = dataMode.readTable(sql,column);
        for (String[] strings : readed) {
            Collections.addAll(read, strings);
            loginData.add(new StaffData(read.get(0),read.get(1),read.get(2),read.get(3),read.get(4),read.get(5),read.get(6)));
            read.clear();
        }
        columnTable(loginData);
    }
    public void columnTable(ObservableList<StaffData> dataObservableList1){
        nameTAb.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        nameIdTab.setCellValueFactory(new PropertyValueFactory<>("nameId"));
        lastNameTAb.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageTAb.setCellValueFactory(new PropertyValueFactory<>("age"));
        addressTAb.setCellValueFactory(new PropertyValueFactory<>("address"));
        sexTab.setCellValueFactory(new PropertyValueFactory<>("sex"));
        responsibilityTab.setCellValueFactory(new PropertyValueFactory<>("responsibility"));

        staffDataTabel.setItems(dataObservableList1);
    }
}
