package helper.people;

import com.jfoenix.controls.JFXButton;
import dbUtil.SqlDataMode;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DeletPopUp implements Initializable {

    @FXML
    private AnchorPane paneLader;

    @FXML
    private JFXButton okPressedK;

    @FXML
    private Spinner<String> froSaleSpinner;

    @FXML
    private TextField moneyNum;

    @FXML
    private TextField newPhoneNumber;

    @FXML
    private TextField scenario;

    private double x,y;

    ObservableList<String> list = FXCollections.observableArrayList(
            "ForSale","ForRent","ForOwn"
    );


    @FXML
    void okPressed(ActionEvent event) {

    }
    public void init(Stage stage){
        paneLader.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        paneLader.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        /*buttonMinimize.setOnMouseClicked(mouseEvent -> {
            stage.setIconified(true);
        });*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(list);
        froSaleSpinner.setValueFactory(valueFactory);
        froSaleSpinner.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if (froSaleSpinner.getValue().trim().equals("ForOwn")){
                    moneyNum.setDisable(true);
                    //moneyNum.setVisible(false);
                    newPhoneNumber.setDisable(true);
                    //newPhoneNumber.setVisible(false);
                    scenario.setDisable(true);
                    //scenario.setVisible(false);
                }
                else {
                    moneyNum.setDisable(false);
                    //moneyNum.setVisible(false);
                    newPhoneNumber.setDisable(false);
                    //newPhoneNumber.setVisible(false);
                    scenario.setDisable(false);
                    //scenario.setVisible(false);
                }
            }
        });
        okPressedK.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String string =null;
                String deleteF ="UPDATE Resident SET  Money = ?,Scenario = ?,SaleOr =? WHERE ResidentId =?";
                Stage stage = new Stage();
                FXMLLoader loader1 = new FXMLLoader();
                Pane pane;
                try {
                    pane = (Pane) loader1.load(getClass().getResource("/helper/people/ResidentMangerLoader.fxml").openStream());
                    string= ((ResidentMangerLoader)loader1.getController()).name;
                    System.out.println(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String[] deleteValue ={moneyNum.getText().trim(),scenario.getText().trim(),froSaleSpinner.getValue(),string};
                SqlDataMode dataMode=new SqlDataMode();
                dataMode.updateTableSql(deleteF,deleteValue);
                Stage stage3 = (Stage) okPressedK.getScene().getWindow();
                stage3.close();
            }
        });
    }
}
