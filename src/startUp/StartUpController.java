package startUp;

import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import login.Login;

public class StartUpController {

    @FXML
    private Label ErrorPrinter;

    @FXML
    private Button adminCreate;

    @FXML
    private TextField buildingBlock;

    @FXML
    private TextField numberOfHouse;

    @FXML
    private PasswordField startUpPassword;

    @FXML
    private TextField startupUserName;

    public void adminCreate(ActionEvent event){
        String table = "Login";
        String access = "Admin";
        SqlDataMode sqlDataMode = new SqlDataMode();
        sqlDataMode.loginTable(table);
        sqlDataMode.loginTableAdd(table,startupUserName.getText(),startUpPassword.getText(),access);
        sqlDataMode.createTableResident("Resident");
    }

    public void Login(){

    }
}
