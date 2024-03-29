package login;

import com.jfoenix.controls.JFXCheckBox;
import dashBoard.AdminDashBoard;
import dbUtil.SqlDataMode;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends Thread implements Initializable {

    @FXML
    private AnchorPane anchorPan;

    @FXML
    private ImageView buttonClose;

    @FXML
    private ImageView buttonMinimize;

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
    private Pane pane;

    @FXML
    private JFXCheckBox rememberMe;

    @FXML
    private PasswordField password;

    @FXML
    private TextField userName;

    private double x,y;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.getOption().setItems(FXCollections.observableArrayList(Option.values()));
    }
    public void init(Stage stage){
        anchorPan.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        anchorPan.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });
        buttonClose.setOnMouseClicked(mouseEvent -> {
            //stage.close();
            System.exit(0);
        });
        /*buttonMinimize.setOnMouseClicked(mouseEvent -> {
            stage.setIconified(true);
        });*/
    }

    public void loginPressed(ActionEvent event){
        LoginMode loginMode = new LoginMode();
        String tableName ="Login";
        String comboBox = null;
        try {
            comboBox = ((Option) this.getOption().getValue()).toString();
        }catch (Exception e){
            getErrorPrint().setText("Wrong Credential");
        }

        //System.out.println(comboBox+" "+userName.getText()+" "+password.getText());


        if (!(comboBox == null)){
            boolean checked = loginMode.isCorrect(tableName, getUserName().getText().trim(), getPassword().getText().trim(),comboBox);
            if (checked){
                if (rememberMe.isSelected()){
                    String trackerName ="Program";
                    SqlDataMode sqlDataMode = new SqlDataMode();
                    sqlDataMode.rememberMeUpdate(trackerName,true);
                    String rememberMeUpdate = "Update Program Set RememberName ='"+comboBox+"' Where NumCount = 1";
                    sqlDataMode.sqlExecute(rememberMeUpdate);
                }
                else {
                    String trackerName ="Program";
                    SqlDataMode sqlDataMode = new SqlDataMode();
                    sqlDataMode.rememberMeUpdate(trackerName,false);
                }
                Stage stage = (Stage) this.getLogin().getScene().getWindow();
                switch (comboBox) {
                    case "Admin":
                      stage.close();
                      adminDashBord();
                      break;
                    case "Staff":
                      stage.close();
                      staffDashBord();
                      break;
                    default:
                      getErrorPrint().setText("Something is going to wrong");
                      }
                }
            else {
                getErrorPrint().setText("Wrong Credential");
            }
        }
        else {
            getErrorPrint().setText("Option Is Not Selected");
        }
    }
    public void forgetPressed(ActionEvent event){
        Stage stage =(Stage) this.getForgetPassword().getScene().getWindow();
        stage.close();
        forgetPasswordDashBord();
    }
    public void forgetPasswordDashBord(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/login/forgetPassword.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Forget Password");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void adminDashBord(){

        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/dashBoard/AdminDashBoard.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Login Page");
            updateValues(getUserName().getText().trim());
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void securityDashBord(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/dashBoard/SecurityDashBoard.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Login Page");
            updateValues(getUserName().getText().trim());
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void brokerDashBord(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/dashBoard/BrokerDashBoard.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Login Page");
            updateValues(getUserName().getText().trim());
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void staffDashBord(){
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane;
            pane = (Pane) loader.load(getClass().getResource("/dashBoard/StaffDashBoard.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            stage.setTitle("Login Page");
            stage.setResizable(false);
            updateValues(getUserName().getText().trim());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateValues(String usernameP){
        String rememberMeUpdate = "Update Program Set UserName ='"+usernameP+"' Where NumCount = 1";
        SqlDataMode sqlDataMode = new SqlDataMode();
        sqlDataMode.sqlExecute(rememberMeUpdate);
    }

    public Label getDbStatues() {
        return dbStatues;
    }

    public void setDbStatues(Label dbStatues) {
        this.dbStatues = dbStatues;
    }

    public Label getErrorPrint() {
        return errorPrint;
    }

    public void setErrorPrint(Label errorPrint) {
        this.errorPrint = errorPrint;
    }

    public Button getForgetPassword() {
        return forgetPassword;
    }

    public void setForgetPassword(Button forgetPassword) {
        this.forgetPassword = forgetPassword;
    }

    public Button getLogin() {
        return login;
    }

    public void setLogin(Button login) {
        this.login = login;
    }

    public ComboBox<Option> getOption() {
        return option;
    }

    public void setOption(ComboBox<Option> option) {
        this.option = option;
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
