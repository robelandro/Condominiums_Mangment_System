package helper.Info;


public class StaffInfo extends BasicInfo {

    private String responsibility;

    public StaffInfo(String firstName, String nameId, String lastName, String age, String address, String sex, String responsibility) {
        super(firstName, nameId, lastName, age, address, sex);
        this.responsibility = responsibility;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}
