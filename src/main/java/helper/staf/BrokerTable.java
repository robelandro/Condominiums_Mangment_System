package helper.staf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class BrokerTable {

    @FXML
    private TableColumn<BrokerData, String> area;

    @FXML
    private TableColumn<BrokerData, String> blockNumber;

    @FXML
    private TableView<BrokerData> brokertable;

    @FXML
    private TableColumn<BrokerData, String> floor;

    @FXML
    private TableColumn<BrokerData, String> houseNumber;

    @FXML
    private TableColumn<BrokerData, String> money;

    @FXML
    private TableColumn<BrokerData, String> part;

    @FXML
    private TableColumn<BrokerData, String> phoneNumber;

    @FXML
    private TableColumn<BrokerData, String> senario;

    @FXML
    void refreshPressed(ActionEvent event) {

    }

}