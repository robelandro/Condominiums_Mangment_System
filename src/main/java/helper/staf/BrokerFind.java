package helper.staf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BrokerFind implements Initializable {

    @FXML
    private TableColumn<BrokerData, String> area;

    @FXML
    private Spinner<String> areaCompare;

    @FXML
    private TextField areaNum;

    @FXML
    private TableColumn<BrokerData, String> blockNumber;

    @FXML
    private TableColumn<BrokerData, String> floor;

    @FXML
    private TextField floorTxt;

    @FXML
    private TableColumn<BrokerData, String> houseNumber;

    @FXML
    private TableColumn<BrokerData, String> money;

    @FXML
    private TableColumn<BrokerData, String> part;

    @FXML
    private TextField partTxt;

    @FXML
    private TableColumn<BrokerData, String> phoneNumber;

    @FXML
    private Spinner<String> saleOr;

    @FXML
    private TableView<BrokerData> brokerFindTable;

    @FXML
    private TableColumn<BrokerData, String> senario;

    ObservableList<String> list = FXCollections.observableArrayList(
            "ForSale","ForRent"
    );
    ObservableList<String> list2 = FXCollections.observableArrayList(
            "<=",">="
    );

    @FXML
    void searchPressed(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<String> forSale = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        SpinnerValueFactory<String> areaD = new SpinnerValueFactory.ListSpinnerValueFactory<>(list2);
        areaCompare.setValueFactory(areaD);
        saleOr.setValueFactory(forSale);
    }
}
