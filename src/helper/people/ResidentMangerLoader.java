package helper.people;

import com.jfoenix.controls.JFXButton;
import dbUtil.DbConnection;
import dbUtil.SqlDataMode;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.ResourceBundle;

public class ResidentMangerLoader implements Initializable {

    @FXML
    private MenuItem addUser;

    @FXML
    private MenuItem deleteUser;

    @FXML
    private MenuItem printSelected;

    @FXML
    private JFXButton printTable;

    @FXML
    private TableColumn<ResidentData, String> residentIDT;

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
    private TableColumn<ResidentData, String> rentStatusT;

    @FXML
    private TableColumn<ResidentData, String> sex;

    @FXML
    private TableView<ResidentData> tableView;

    @FXML
    private TableColumn<ResidentData, Integer> userId;
    //Resident Pressed
    @FXML
    private TextField SearchFiled;

    @FXML
    private FontAwesomeIcon SearchPressed;

    @FXML
    private JFXButton addResident;


    @FXML
    private JFXButton refreshTable;

    @FXML
    private JFXButton removeResident;

    public ObservableList<ResidentData> dataObservableList;

    @FXML
    void addResidentP(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/helper/people/popUpRegistratin.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Add Resident");
            stage.setResizable(false);
            stage.showAndWait();
            loadDataTable();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void refreshablePressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    loadDataTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    public void loadDataTable() throws IOException {
        String tableName ="Resident";
        /*AdminDashBoard managementControllerAdmin =new AdminDashBoard();
        managementControllerAdmin.addTableTo();*/
        SqlDataMode dataMode = new SqlDataMode();
        dataMode.readResident(tableName);
        residentIDT.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("residentId"));
        userId.setCellValueFactory(new PropertyValueFactory<ResidentData,Integer>("userId"));
        firstName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("lastName"));
        age.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("age"));
        address.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("address"));
        sex.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("sex"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("phoneNumber"));
        block.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("blockNumber"));
        houseNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("houseNumber"));
        rentStatusT.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("rentStatus"));

        tableView.setItems(dataMode.dataObservableList);

    }

    @FXML
    void addUserPressed(ActionEvent event) {
        addResidentP(event);
    }

    @FXML
    void deleteUserPressed(ActionEvent event) {
        ResidentData selected =tableView.getSelectionModel().getSelectedItem();
        if (!(selected ==null)){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting User");
            alert.setContentText("Are You Sure to Delete: "+selected.getFirstName()+" ?");
            Optional<ButtonType> answer = alert.showAndWait();
            if (answer.get()==ButtonType.OK){
                String deleteF ="UPDATE Resident SET  ResidentId = ?,FirstName = ?,LastName = ?,Address = ?,Age = ?,Sex =?,PhoneNumber = ?, RentStatus =? WHERE ResidentId =?";
                String[] deleteValue ={null,null,null,null,null,null,null,null,selected.getResidentId()};
                SqlDataMode dataMode=new SqlDataMode();
                dataMode.updateTableSql(deleteF,deleteValue);
                try {
                    loadDataTable();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                Alert alert1 = new Alert(Alert.AlertType.NONE);
                alert1.setTitle("Canceled");
                alert1.setContentText("Canceled Successful");
                alert1.show();
            }
        }
    }

    @FXML
    void printSelectedPressed(ActionEvent event) {

    }

    @FXML
    void printTablePressed(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SearchPressed.setOnMousePressed(mouseEvent -> {
            if (SearchFiled.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Search");
                alert.setHeaderText("Search Filed Can not Be Empty");
                alert.setContentText("Search Filed Is Empty");
                alert.show();
            }
            else {
                String searchA ="SELECT * FROM Resident WHERE FirstName LIKE '%"+SearchFiled.getText().trim()+"%' OR LastName LIKE '%"+SearchFiled.getText().trim()+"%'";
                String [] naColumn ={"NumCount" , "ResidentId" , "FirstName" , "LastName" , "Address", "Age" , "Sex" , "PhoneNumber" , "BlockNumber", "HouseNumber", "RentStatus"};
                ArrayList<String> read = new ArrayList<String>();
                dataObservableList = FXCollections.observableArrayList();
                SqlDataMode mode = new SqlDataMode();
                String readed[][] = mode.readTable(searchA,naColumn);
                for (String[] strings : readed) {
                    Collections.addAll(read, strings);
                    dataObservableList.add(new ResidentData(read.get(1), Integer.parseInt(read.get(0)), read.get(2), read.get(3), read.get(4), read.get(5), read.get(6), read.get(7), read.get(8), read.get(9), read.get(10)));
                }
                residentIDT.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("residentId"));
                userId.setCellValueFactory(new PropertyValueFactory<ResidentData,Integer>("userId"));
                firstName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("firstName"));
                lastName.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("lastName"));
                age.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("age"));
                address.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("address"));
                sex.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("sex"));
                phoneNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("phoneNumber"));
                block.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("blockNumber"));
                houseNumber.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("houseNumber"));
                rentStatusT.setCellValueFactory(new PropertyValueFactory<ResidentData,String>("rentStatus"));

                tableView.setItems(dataObservableList);
            }
        });
        try {
            loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
