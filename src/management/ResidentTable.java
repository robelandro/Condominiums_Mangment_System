package management;

import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResidentTable implements Initializable {

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

    @FXML
    public void loadDataTable() throws IOException {
        String tableName ="Resident";
        /*ChoiceManagementControllerAdmin managementControllerAdmin =new ChoiceManagementControllerAdmin();
        managementControllerAdmin.addTableTo();*/
        SqlDataMode dataMode = new SqlDataMode();
        dataMode.readResident(tableName);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
