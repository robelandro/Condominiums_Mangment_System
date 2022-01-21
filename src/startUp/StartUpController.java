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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import login.LoginController;

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

        if (getStartUpPassword().getText().endsWith(getConfirmPassword().getText())){
            SqlDataMode sqlDataMode = new SqlDataMode();
            sqlDataMode.programTracker(trackerName);
            sqlDataMode.loginTable(table);
            sqlDataMode.loginTableAdd(table, getStartupUserName().getText(), getStartUpPassword().getText(),access, getHint().getText());
            sqlDataMode.createTableResident("Resident");
            Stage stage = (Stage) this.getAdminCreate().getScene().getWindow();
            stage.close();
            loginPage();
        }
        else {
            getErrorPrinter().setText("Password not match");
        }
    }

    public void loginPage(){
        try{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane pane = (Pane) loader.load(getClass().getResource("/login/login.fxml").openStream());
            Scene scene = new Scene(pane);
            stage.setScene(scene);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setResizable(false);
            ((LoginController)loader.getController()).init(stage);
            stage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Label getErrorPrinter() {
        return ErrorPrinter;
    }

    public void setErrorPrinter(Label errorPrinter) {
        ErrorPrinter = errorPrinter;
    }

    public Button getAdminCreate() {
        return adminCreate;
    }

    public void setAdminCreate(Button adminCreate) {
        this.adminCreate = adminCreate;
    }

    public TextField getBuildingBlock() {
        return buildingBlock;
    }

    public void setBuildingBlock(TextField buildingBlock) {
        this.buildingBlock = buildingBlock;
    }

    public PasswordField getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(PasswordField confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public TextField getHint() {
        return hint;
    }

    public void setHint(TextField hint) {
        this.hint = hint;
    }

    public TextField getNumberOfHouse() {
        return numberOfHouse;
    }

    public void setNumberOfHouse(TextField numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public PasswordField getStartUpPassword() {
        return startUpPassword;
    }

    public void setStartUpPassword(PasswordField startUpPassword) {
        this.startUpPassword = startUpPassword;
    }

    public TextField getStartupUserName() {
        return startupUserName;
    }

    public void setStartupUserName(TextField startupUserName) {
        this.startupUserName = startupUserName;
    }
}
