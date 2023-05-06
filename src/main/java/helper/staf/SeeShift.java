package helper.staf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SeeShift implements Initializable {

    @FXML
    private Spinner<String> dateName;

    @FXML
    private TableColumn<ShiftData, String> fridayTab;

    @FXML
    private Label info;

    @FXML
    private TableColumn<ShiftData, String> mondayTab;

    @FXML
    private TableColumn<ShiftData, String> nameTab;

    @FXML
    private TableColumn<ShiftData, String> responsiblityTab;

    @FXML
    private TableColumn<ShiftData, String> saturdayTab;

    @FXML
    private TableView<ShiftData> shiftTable;

    @FXML
    private TextField staffName;

    @FXML
    private TableColumn<ShiftData, String> sundayTab;

    @FXML
    private TableColumn<ShiftData, String> thursdayTab;

    @FXML
    private TableColumn<ShiftData, String> tusedayTab;

    @FXML
    private TableColumn<ShiftData, String> wednesdayTab;

    ObservableList<String> observableList = FXCollections.observableArrayList(
            "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"
    );

    @FXML
    void filterButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(observableList);
        dateName.setValueFactory(valueFactory);
    }
}
