package login;

import dbUtil.SqlDataMode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import startUp.StartUpController;

public class ForgetPassword {

    @FXML
    private Button backButton;

    @FXML
    private Button hintPressed;

    @FXML
    private Label hintPrint;

    @FXML
    private TextField hintToCheck;

    public void HintPressed(ActionEvent event){
        String table ="Login";
        SqlDataMode dataMode =new SqlDataMode();
        String credential=dataMode.hintForget(table,hintToCheck.getText());
        hintPrint.setText(credential);
    }

    public void backToLogin(ActionEvent event) {
        Stage stage = (Stage)this.backButton.getScene().getWindow();
        stage.close();
        StartUpController controller = new StartUpController();
        controller.loginPage();
    }

}
