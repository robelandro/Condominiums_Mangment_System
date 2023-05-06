package helper.staf;

import dbUtil.SqlDataMode;
import helper.people.ResidentData;
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

public class LoginTableController implements Initializable {

    @FXML
    private TableColumn<LoginData, String> accessLevel;

    @FXML
    private TableView<LoginData> credentialTable;

    @FXML
    private TableColumn<LoginData, String> hint;

    @FXML
    private TableColumn<LoginData, String> password;

    @FXML
    private TableColumn<LoginData, String> userName;

    ObservableList<LoginData> loginData = FXCollections.observableArrayList();

    @FXML
    void infoPressed(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData1();
    }
    public void loadData1(){
        String sql ="SELECT UserName,Password,AccessLevel,Hint From Login";
        String [] column ={"UserName","Password","AccessLevel","Hint"};
        ArrayList<String> read = new ArrayList<String>();
        SqlDataMode dataMode = new SqlDataMode();
        String [][] readed = dataMode.readTable(sql,column);
        for (String[] strings : readed) {
            Collections.addAll(read, strings);
            loginData.add(new LoginData(read.get(0),read.get(1),read.get(2),read.get(3)));
            read.clear();
        }
        columnTable(loginData);
    }
    public void columnTable(ObservableList<LoginData> dataObservableList1){
        userName.setCellValueFactory(new PropertyValueFactory<LoginData,String>("userName"));
        password.setCellValueFactory(new PropertyValueFactory<LoginData,String>("password"));
        accessLevel.setCellValueFactory(new PropertyValueFactory<LoginData,String>("accessLevel"));
        hint.setCellValueFactory(new PropertyValueFactory<LoginData,String>("hint"));

        credentialTable.setItems(dataObservableList1);
    }
}
