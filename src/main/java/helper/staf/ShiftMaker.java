package helper.staf;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ShiftMaker implements Initializable {

    @FXML
    private TableColumn<ShiftData, String> fridayTab;

    @FXML
    private Spinner<String> fromFri;

    @FXML
    private Spinner<String> fromMon;

    @FXML
    private Spinner<String> fromSat;

    @FXML
    private Spinner<String> fromSun;

    @FXML
    private Spinner<String> fromThur;

    @FXML
    private Spinner<String> fromTus;

    @FXML
    private Spinner<String> fromWend;

    @FXML
    private TableColumn<ShiftData, String> mondayTab;

    @FXML
    private TextField name;

    @FXML
    private TableColumn<ShiftData, String> nameTab;

    @FXML
    private JFXButton refreshPressed;

    @FXML
    private TextField responsiblity;

    @FXML
    private TableColumn<ShiftData, String> responsiblityTab;

    @FXML
    private JFXButton rigisterPressed;

    @FXML
    private TableColumn<ShiftData, String> saturdayTab;

    @FXML
    private TableColumn<ShiftData, String> sundayTab;

    @FXML
    private TableColumn<ShiftData, String> thursdayTab;

    @FXML
    private Spinner<String> toFri;

    @FXML
    private Spinner<String> toMon;

    @FXML
    private Spinner<String> toSat;

    @FXML
    private Spinner<String> toSun;

    @FXML
    private Spinner<String> toThur;

    @FXML
    private Spinner<String> toTus;

    @FXML
    private Spinner<String> toWend;

    @FXML
    private TableView<ShiftData> shiftTable;

    @FXML
    private TableColumn<ShiftData, String> tusedayTab;

    @FXML
    private TableColumn<ShiftData, String> wednesdayTab;

    ObservableList<String> list = FXCollections.observableArrayList(
            "12:00 AM","1:00 AM","2:00 AM","3:00 AM","4:00 AM","5:00 AM","6:00 AM","7:00 AM","8:00 AM","9:00 AM","10:00 AM","11:00 AM","12:00 PM","1:00 PM","2:00 PM","3:00 PM","4:00 PM","5:00 PM","6:00 PM","7:00 PM","8:00 PM","9:00 PM","10:00 PM","11:00 PM"
    );

    @FXML
    void refreshPressed(ActionEvent event) {

    }

    @FXML
    void rigisterPressed(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<String> h1 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h2 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h3 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h4 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h5 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h6 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h7 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h8 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h9 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h10 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h11 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h12 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h13 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> h14 = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);


        fromMon.setValueFactory(h1);
        fromTus.setValueFactory(h2);
        fromWend.setValueFactory(h3);
        fromThur.setValueFactory(h4);
        fromFri.setValueFactory(h5);
        fromSat.setValueFactory(h6);
        fromSun.setValueFactory(h7);
        toMon.setValueFactory(h8);
        toTus.setValueFactory(h9);
        toWend.setValueFactory(h10);
        toThur.setValueFactory(h11);
        toFri.setValueFactory(h12);
        toSat.setValueFactory(h13);
        toSun.setValueFactory(h14);
    }
}
