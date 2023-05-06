package helper.physical;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HouseHoldData {
    private final StringProperty name;
    private final StringProperty residentId;
    private final StringProperty nameOfObject;
    private final StringProperty risky;

    public HouseHoldData(String name, String residentId, String nameOfObject, String risky) {
        this.name = new SimpleStringProperty(name);
        this.residentId = new SimpleStringProperty(residentId);
        this.nameOfObject = new SimpleStringProperty(nameOfObject);
        this.risky = new SimpleStringProperty(risky);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getResidentId() {
        return residentId.get();
    }

    public StringProperty residentIdProperty() {
        return residentId;
    }

    public void setResidentId(String residentId) {
        this.residentId.set(residentId);
    }

    public String getNameOfObject() {
        return nameOfObject.get();
    }

    public StringProperty nameOfObjectProperty() {
        return nameOfObject;
    }

    public void setNameOfObject(String nameOfObject) {
        this.nameOfObject.set(nameOfObject);
    }

    public String getRisky() {
        return risky.get();
    }

    public StringProperty riskyProperty() {
        return risky;
    }

    public void setRisky(String risky) {
        this.risky.set(risky);
    }
}
