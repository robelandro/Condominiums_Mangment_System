package dashBoard;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class BrokerDashBoard implements Initializable {

    @FXML
    private Pane addToPane;

    @FXML
    private JFXButton find;

    @FXML
    private JFXButton forRent;

    @FXML
    private JFXButton forSale;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label profileName;

    @FXML
    private JFXButton signOut;

    @FXML
    void findPressed(ActionEvent event) {

    }

    @FXML
    void forRentPressed(ActionEvent event) {

    }

    @FXML
    void forSalePressed(ActionEvent event) {

    }

    @FXML
    void signOutPressed(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SqlDataMode dataMode = new SqlDataMode();
        profileName.setText(dataMode.userName());
    }
}
