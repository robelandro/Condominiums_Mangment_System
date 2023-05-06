package helper.staf;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginData {
    private final StringProperty userName;
    private final StringProperty password;
    private final StringProperty accessLevel;
    private final StringProperty hint;
    public LoginData(String userName,String password,String accessLevel,String hint){
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
        this.accessLevel = new SimpleStringProperty(accessLevel);
        this.hint = new SimpleStringProperty(hint);
    }

    public String getUserName() {
        return userName.get();
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getAccessLevel() {
        return accessLevel.get();
    }

    public StringProperty accessLevelProperty() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel.set(accessLevel);
    }

    public String getHint() {
        return hint.get();
    }

    public StringProperty hintProperty() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint.set(hint);
    }
}
