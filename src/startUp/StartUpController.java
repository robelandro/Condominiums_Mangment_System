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
import java.util.InputMismatchException;

public class StartUpController {

    @FXML
    private Label ErrorPrinter1;

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
        String sqlTable = "CREATE TABLE Login (NumCount INTEGER GENERATED ALWAYS AS IDENTITY, UserName VARCHAR(30), Password VARCHAR(30), AccessLevel VARCHAR(30), Hint VARCHAR(40))";
        String sqlInsert = "INSERT INTO Login ( UserName,Password,AccessLevel,Hint) VALUES (?,?,?,?)";
        String sqlResident ="CREATE TABLE Resident (NumCount VARCHAR(30), ResidentId VARCHAR(30), FirstName VARCHAR(10), LastName VARCHAR(10), Address VARCHAR(20), Age VARCHAR(3), Sex VARCHAR(10), PhoneNumber VARCHAR(20), BlockNumber VARCHAR(5), HouseNumber VARCHAR(10), RentStatus VARCHAR(10))";
        String access = "Admin";
        String [] credential = {getStartupUserName().getText(),getStartUpPassword().getText(),access,getHint().getText()};
        String trackerName ="Program";
        boolean check =getStartUpPassword().getText().endsWith(getConfirmPassword().getText());
        if (check && !getNumberOfHouse().getText().isEmpty() && checkForInteger()){
            int countNu = 1;
            SqlDataMode sqlDataMode = new SqlDataMode();
            sqlDataMode.programTracker(trackerName);
            sqlDataMode.createTable(sqlTable);
            sqlDataMode.createTableId();
            sqlDataMode.insertTable(sqlInsert,credential);
            sqlDataMode.createTable(sqlResident);
            while (!(countNu == Integer.parseInt(getNumberOfHouse().getText())+1)){
                sqlDataMode.makeTable("NumCount","Resident",String.valueOf(countNu));
                countNu++;
            }
            Stage stage = (Stage) this.getAdminCreate().getScene().getWindow();
            stage.close();
            loginPage();
        }
        else {
            if(getNumberOfHouse().getText().isEmpty() && !check && !checkForInteger()){
                ErrorPrinter1.setText("Number of House Can Not Be Empty");
                getErrorPrinter().setText("Password not match");
            }
            else if (getNumberOfHouse().getText().isEmpty() || !checkForInteger()){
                getErrorPrinter().setText(" ");
                ErrorPrinter1.setText("Please Enter Number of House" +
                        "\nCorrectly");
            }
            else {
            getErrorPrinter().setText("Password not match");
            ErrorPrinter1.setText(" ");
            }
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

    public boolean checkForInteger (){
        try{
            int add =3+Integer.parseInt(getNumberOfHouse().getText());
            return true;
        }
        catch (InputMismatchException | NumberFormatException e){
            return false;
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
