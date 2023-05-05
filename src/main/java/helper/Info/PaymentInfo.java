package helper.Info;


public class PaymentInfo extends BasicInfo{
    private String paymentPurpose;
    private String paymentAmount;
    private String dateAndTime;

    public PaymentInfo(String firstName, String nameId, String paymentPurpose, String paymentAmount, String dateAndTime) {
        super(firstName, nameId);
        this.paymentPurpose = paymentPurpose;
        this.paymentAmount = paymentAmount;
        this.dateAndTime = dateAndTime;

    }

    public String getPaymentPurpose() {
        return paymentPurpose;
    }

    public void setPaymentPurpose(String paymentPurpose) {
        this.paymentPurpose = paymentPurpose;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
