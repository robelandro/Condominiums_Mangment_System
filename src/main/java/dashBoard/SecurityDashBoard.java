package dashBoard;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import startUp.StartUpController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecurityDashBoard implements Initializable {

    @FXML
    private JFXButton addReport;

    @FXML
    private Pane paneToAdd;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label profileName;

    @FXML
    private JFXButton propertyManger;

    @FXML
    private JFXButton seeShift;

    @FXML
    private JFXButton signOut;

    @FXML
    void addReportPressed(ActionEvent event) {

    }

    @FXML
    void propertyMangerPressed(ActionEvent event) {

    }

    @FXML
    void seeShiftPressed(ActionEvent event) {

    }

    @FXML
    void signOutPressed(ActionEvent event) {
        String trackerName ="Program";
        SqlDataMode sqlDataMode = new SqlDataMode();
        sqlDataMode.rememberMeUpdate(trackerName,false);
        Stage stage = (Stage) this.signOut.getScene().getWindow();
        stage.close();
        StartUpController startUpController = new StartUpController();
        startUpController.loginPage();
    }
    @FXML
    void carManagementPressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Node root  = FXMLLoader.load(getClass().getResource("/helper/physical/CarMangement.fxml"));
                    if (!paneToAdd.getChildren().isEmpty()) {
                        paneToAdd.getChildren().clear();
                    }
                    root.prefWidth(675);
                    root.prefWidth(500);
                    paneToAdd.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @FXML
    void householdManagementPressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Node root  = FXMLLoader.load(getClass().getResource("/helper/physical/houseHold.fxml"));
                    if (!paneToAdd.getChildren().isEmpty()) {
                        paneToAdd.getChildren().clear();
                    }
                    root.prefWidth(675);
                    root.prefWidth(500);
                    paneToAdd.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SqlDataMode dataMode = new SqlDataMode();
        profileName.setText(dataMode.userName());
    }
}
