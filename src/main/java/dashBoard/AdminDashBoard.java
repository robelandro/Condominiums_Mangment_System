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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import startUp.StartUpController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdminDashBoard implements Initializable {

    @FXML
    private AnchorPane functionalPan;

    @FXML
    private JFXButton paymentManger;

    @FXML
    private Label profileName;

    @FXML
    private ImageView profilePicture;

    @FXML
    private JFXButton propertyManger;

    @FXML
    private JFXButton residentsManger;

    @FXML
    private JFXButton signOut;

    @FXML
    private JFXButton staffManger;

    @FXML
    void paymentMangerPressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Node root  = FXMLLoader.load(getClass().getResource("/helper/payment/PaymentManger.fxml"));
                    if (!functionalPan.getChildren().isEmpty()) {
                        functionalPan.getChildren().clear();
                    }
                    functionalPan.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @FXML
    void propertyMangerPressed(ActionEvent event) {

    }

    @FXML
    void residentMangerPressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Node root  = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/helper/people/ResidentMangerLoader.fxml")));
                    if (!functionalPan.getChildren().isEmpty()) {
                        functionalPan.getChildren().clear();
                    }
                    functionalPan.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

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
    void staffMangerPressed(ActionEvent event) {

    }
    @FXML
    void carManagementPressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Node root  = FXMLLoader.load(getClass().getResource("/helper/physical/CarMangement.fxml"));
                    if (!functionalPan.getChildren().isEmpty()) {
                        functionalPan.getChildren().clear();
                    }
                    functionalPan.getChildren().add(root);
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
                    if (!functionalPan.getChildren().isEmpty()) {
                        functionalPan.getChildren().clear();
                    }
                    functionalPan.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @FXML
    void staffloginMangerPressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Node root  = FXMLLoader.load(getClass().getResource("/helper/staf/staffManger.fxml"));
                    if (!functionalPan.getChildren().isEmpty()) {
                        functionalPan.getChildren().clear();
                    }
                    functionalPan.getChildren().add(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @FXML
    void shiftMakerPressed(ActionEvent event) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {

                try {
                    Node root  = FXMLLoader.load(getClass().getResource("/helper/staf/shiftMaker.fxml"));
                    if (!functionalPan.getChildren().isEmpty()) {
                        functionalPan.getChildren().clear();
                    }
                    functionalPan.getChildren().add(root);
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
