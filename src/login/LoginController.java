package login;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label dbStatues;

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
}
