package management;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXScrollPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class ChoiceManagementControllerAdmin {

    @FXML
    private Pane abovePane;

    @FXML
    private JFXScrollPane belowScrolle;

    @FXML
    private JFXButton info;

    @FXML
    private JFXButton paymentManger;

    @FXML
    private ImageView profileImage;

    @FXML
    private Label profileName;

    @FXML
    private JFXButton propertyManger;

    @FXML
    private JFXButton registerManger;

    @FXML
    private JFXButton signOut;

    @FXML
    void infoP(ActionEvent event) {

    }

    @FXML
    void paymentMangerP(ActionEvent event) {

    }

    @FXML
    void propertyMangerP(ActionEvent event) {

    }

    @FXML
    public void registerMangerP(ActionEvent event) throws IOException {
        Node root = FXMLLoader.load(getClass().getResource("/management/residentContent.fxml"));
        abovePane.getChildren().add(root);
    }

    @FXML
    void signOutP(ActionEvent event) {

    }
    @FXML
    void addUser(ActionEvent event){

    }

}
