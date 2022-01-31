package codeBackup;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import helper.people.ResidentMangerLoader;

import java.io.IOException;

public class codeBackUp {

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
    private JFXButton addResident;

    @FXML
    private JFXButton removeResident;



    @FXML
    public void addResidentP(ActionEvent event) {



    }

    @FXML
    public void removeResidentP(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));

        try {
            Node root2 = FXMLLoader.load(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));
            belowScroll.getChildren().add(root2);
            loader.load();
            ResidentMangerLoader residentMangerLoader =loader.getRoot();
            residentMangerLoader.loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
        Node root = FXMLLoader.load(getClass().getResource("/codeBackup/residentContent.fxml"));
        abovePane.getChildren().add(root);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));
        loader.load();
        ResidentMangerLoader residentTable=loader.getController();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));

        try {
            Node root2 = FXMLLoader.load(getClass().getResource("/helper/people/ResidentMangerLoader.fxml"));
            belowScroll.getChildren().add(root2);
            loader.load();
            ResidentMangerLoader residentMangerLoader =loader.getController();
            residentMangerLoader.loadDataTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
