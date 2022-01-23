package management;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChoiceManagementControllerAdmin implements Initializable{

    //public static boolean setIt = false;
    @FXML
    private Pane abovePane;

    @FXML
    private JFXButton addUser;

    @FXML
    private AnchorPane belowScroll;

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
    private TextField search;

    @FXML
    private FontAwesomeIcon searchPressed;

    @FXML
    private JFXButton signOut;

    @FXML
    private JFXButton updateTabel;

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
    public void registerMangerP() throws IOException {
        Node root = FXMLLoader.load(getClass().getResource("/management/residentContent.fxml"));
        abovePane.getChildren().add(root);
        Node root2 = FXMLLoader.load(getClass().getResource("/management/residentTable.fxml"));
        belowScroll.getChildren().add(root2);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/management/residentTable.fxml"));
        loader.load();
        ResidentTable residentTable=loader.getController();
        residentTable.loadDataTable();
        //setIt = true;
    }

    @FXML
    void signOutP(ActionEvent event) {

    }
    @FXML
    void addUser(ActionEvent event){

    }
    @FXML
    void updateTa() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/management/residentTable.fxml"));

        try {
            Node root2 = FXMLLoader.load(getClass().getResource("/management/residentTable.fxml"));
            belowScroll.getChildren().add(root2);
            loader.load();
            ResidentTable residentTable=loader.getController();
            residentTable.loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
