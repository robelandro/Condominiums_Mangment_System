package login;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label dbStatues;

    @FXML
    private Label errorPrint;

    @FXML
    private Button forgetPassword;

    @FXML
    private Button login;

    @FXML
    private ComboBox<Option> option;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.option.setItems(FXCollections.observableArrayList(Option.values()));
    }

    public LoginController(PasswordField password, TextField userName) {
        this.setPassword(password);
        this.setUserName(userName);
    }

    public void loginPressed(ActionEvent event){
        LoginMode loginMode = new LoginMode();
        String tableName ="Login";
        String comboBox=((Option)this.option.getValue()).toString();
        if (loginMode.isCorrect(tableName,getUserName().getText(),getPassword().getText(),comboBox)){
            Stage stage = (Stage)this.login.getScene().getWindow();
            switch (comboBox){
                case "Admin":
                    stage.close();
                    adminDashBord();
                    break;
                case "Staff":
                    stage.close();
                    staffDashBord();
                    break;
                case default :
                    errorPrint.setText("Option Is not Selected");
            }
        }
        else {
            errorPrint.setText("Wrong Credential");
        }

    }
    public void adminDashBord(){

    }
    public void staffDashBord(){

    }
    public PasswordField getPassword() {
        return password;
    }

    public void setPassword(PasswordField password) {
        this.password = password;
    }

    public TextField getUserName() {
        return userName;
    }

    public void setUserName(TextField userName) {
        this.userName = userName;
    }
}