package helper.payment;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PaymentData {
    private final StringProperty name;
    private final StringProperty residentId;
    private final StringProperty paymentPurpose;
    private final StringProperty paymentAmount;
    private final StringProperty dateAndTime;

    public PaymentData(String name,String residentId,String paymentPurpose,String paymentAmount,String dateAndTime) {
        this.name = new SimpleStringProperty(name);
        this.residentId = new SimpleStringProperty(residentId);
        this.paymentPurpose = new SimpleStringProperty(paymentPurpose);
        this.paymentAmount = new SimpleStringProperty(paymentAmount);
        this.dateAndTime = new SimpleStringProperty(dateAndTime);
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

    public String getPaymentPurpose() {
        return paymentPurpose.get();
    }

    public StringProperty paymentPurposeProperty() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose.set(paymentPurpose);
    }

    public String getPaymentAmount() {
        return paymentAmount.get();
    }

    public StringProperty paymentAmountProperty() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount.set(paymentAmount);
    }

    public String getDateAndTime() {
        return dateAndTime.get();
    }

    public StringProperty dateAndTimeProperty() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime.set(dateAndTime);
    }
}
