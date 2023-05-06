package helper.physical;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CarData {
    private final StringProperty name;
    private final StringProperty residentId;
    private final StringProperty typeOfcar;
    private final StringProperty plateNumber;

    public CarData(String name, String residentId, String typeOfcar, String plateNumber) {
        this.name = new SimpleStringProperty(name);
        this.residentId = new SimpleStringProperty(residentId);
        this.typeOfcar = new SimpleStringProperty(typeOfcar);
        this.plateNumber = new SimpleStringProperty(plateNumber);
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

    public String getTypeOfcar() {
        return typeOfcar.get();
    }

    public StringProperty typeOfcarProperty() {
        return typeOfcar;
    }

    public void setTypeOfcar(String typeOfcar) {
        this.typeOfcar.set(typeOfcar);
    }

    public String getPlateNumber() {
        return plateNumber.get();
    }

    public StringProperty plateNumberProperty() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber.set(plateNumber);
    }
}