package dashBoard;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import startUp.StartUpController;

import java.io.IOException;
import java.util.Objects;

public class AdminDashBoard {

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

    }

    @FXML
    void householdManagementPressed(ActionEvent event) {

    }

    @FXML
    void staffloginMangerPressed(ActionEvent event) {

    }

    @FXML
    void shiftMakerPressed(ActionEvent event) {

    }

}
