package helper.Info;


import dbUtil.SqlDataMode;

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
    public void registerStaff(){
        String add ="Insert Into Staff (FirstName, NameId, LastName, Age, Address, Sex, Responsibility)" +
                "Values (?,?,?,?,?,?,?)";
        String [] values ={getFirstName(),getNameId(),getLastName(),getAge(),getAddress(),getSex(),getResponsibility()};
        SqlDataMode dataMode = new SqlDataMode();
        dataMode.insertTable(add,values);
    }
}
