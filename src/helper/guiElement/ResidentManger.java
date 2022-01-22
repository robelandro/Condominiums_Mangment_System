package helper.guiElement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ResidentManger {

    @FXML
    private TableColumn<ResidentData, String> address;

    @FXML
    private TableColumn<ResidentData, Integer> age;

    @FXML
    private TableColumn<ResidentData, Integer> block;

    @FXML
    private TableColumn<ResidentData, String> firstName;

    @FXML
    private TableColumn<ResidentData, Integer> houseNumber;

    @FXML
    private TableColumn<ResidentData, String> lastName;

    @FXML
    private TableColumn<ResidentData, Integer> phoneNumber;

    @FXML
    private TableColumn<ResidentData, String> sex;

    @FXML
    private TableView<ResidentData> tableView;

    @FXML
    private TableColumn<ResidentData, Integer> userId;

    @FXML
    private JFXButton addResident;

    @FXML
    private JFXButton removeResident;

    @FXML
    private TextField search;


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
    private TextField phonNumberPo;

    @FXML
    private JFXButton registerPo;

    @FXML
    private JFXRadioButton rentPo;

    @FXML
    void cancelClicked(ActionEvent event) {

    }

    @FXML
    void registerClicked(ActionEvent event) {

    }

    @FXML
    public void addResidentP(ActionEvent event) {

    }

    @FXML
    public void removeResidentP(ActionEvent event) {

    }

}
