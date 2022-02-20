package helper.Info;


public class GuestInfo extends BasicInfo {

    private String blockNumber;
    private String phoneNumber;
    private String houseNumber;

    public GuestInfo(String firstName, String nameId, String lastName, String age, String address, String sex, String blockNumber, String phoneNumber, String houseNumber) {
        super(firstName, nameId, lastName, age, address, sex);
        this.blockNumber = blockNumber;
        this.phoneNumber = phoneNumber;
        this.houseNumber = houseNumber;
    }

    public GuestInfo(String firstName, String nameId, String lastName, String age, String address, String sex, String phoneNumber) {
        super(firstName, nameId, lastName, age, address, sex);
        this.phoneNumber = phoneNumber;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}