package helper.people;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ResidentMangerLoader implements Initializable {

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
    void removeResidentP(ActionEvent event) {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
