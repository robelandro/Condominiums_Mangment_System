package management;

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

public class ChoiceManagementControllerAdmin {

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
                    Node root2  = FXMLLoader.load(getClass().getResource("/management/ResidentMangerLoader.fxml"));
                    functionalPan.getChildren().add(root2);
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

}
