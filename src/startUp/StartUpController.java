package startUp;

import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class StartUpController {

    @FXML
    private Label ErrorPrinter;

    @FXML
    private Button adminCreate;

    @FXML
    private TextField buildingBlock;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private TextField hint;

    @FXML
    private TextField numberOfHouse;

    @FXML
    private PasswordField startUpPassword;

    @FXML
    private TextField startupUserName;

    public void adminCreate(ActionEvent event){
        String table = "Login";
        String access = "Admin";
        String trackerName ="Program";

        if (startUpPassword.getText().endsWith(confirmPassword.getText())){
            SqlDataMode sqlDataMode = new SqlDataMode();
            sqlDataMode.programTracker(trackerName);
            sqlDataMode.loginTable(table);
            sqlDataMode.loginTableAdd(table,startupUserName.getText(),startUpPassword.getText(),access);
            sqlDataMode.createTableResident("Resident");
            Stage stage = (Stage) this.adminCreate.getScene().getWindow();
            stage.close();
            loginPage();
        }
        else {
            ErrorPrinter.setText("Password not match");
        }
    }

    public void loginPage(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane = (Pane) loader.load(getClass().getResource("/login/login.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Login Page");
            stage.setResizable(false);
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
