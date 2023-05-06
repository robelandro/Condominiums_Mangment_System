package helper.staf;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BrokerData {
    private final StringProperty blockNumber;
    private final StringProperty phoneNumber;
    private final StringProperty houseNumber;
    private final StringProperty area;
    private final StringProperty floor;
    private final StringProperty part;
    private final StringProperty money;
    private final StringProperty scenario;
    public BrokerData(String blockNumber,String phoneNumber,String houseNumber,String money,String scenario,String area,String floor,String part){
        this.blockNumber = new SimpleStringProperty(blockNumber);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.houseNumber = new SimpleStringProperty(houseNumber);
        this.area = new SimpleStringProperty(area);
        this.floor = new SimpleStringProperty(floor);
        this.part = new SimpleStringProperty(part);
        this.money = new SimpleStringProperty(money);
        this.scenario = new SimpleStringProperty(scenario);
    }

    public String getBlockNumber() {
        return blockNumber.get();
    }

    public StringProperty blockNumberProperty() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber.set(blockNumber);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getHouseNumber() {
        return houseNumber.get();
    }

    public StringProperty houseNumberProperty() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber.set(houseNumber);
    }

    public String getArea() {
        return area.get();
    }

    public StringProperty areaProperty() {
        return area;
    }

    public void setArea(String area) {
        this.area.set(area);
    }

    public String getFloor() {
        return floor.get();
    }

    public StringProperty floorProperty() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor.set(floor);
    }

    public String getPart() {
        return part.get();
    }

    public StringProperty partProperty() {
        return part;
    }

    public void setPart(String part) {
        this.part.set(part);
    }

    public String getMoney() {
        return money.get();
    }

    public StringProperty moneyProperty() {
        return money;
    }

    public void setMoney(String money) {
        this.money.set(money);
    }

    public String getScenario() {
        return scenario.get();
    }

    public StringProperty scenarioProperty() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario.set(scenario);
    }
}
