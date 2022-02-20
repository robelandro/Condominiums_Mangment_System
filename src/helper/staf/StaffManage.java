package helper.staf;

import dbUtil.SqlDataMode;

public class StaffManage {
    public void registerStaffLogin(String userName,String password,String accessLevel,String hint){
        String sqlInsert = "INSERT INTO Login ( UserName,Password,AccessLevel,Hint) VALUES (?,?,?,?)";
        String [] sqlValue ={userName,password,accessLevel,hint};
        SqlDataMode dataMode = new SqlDataMode();
        dataMode.insertTable(sqlInsert,sqlValue);
    }
    public boolean isCorrect(String userName,String password,String accessLevel){
        String[] columnName = {"UserName","Password","AccessLevel"};
        String check ="Select UserName,Password,AccessLevel From Login Where UserName ='" + userName+"' And Password='" + password+"' And AccessLevel='" + accessLevel+"'";
        SqlDataMode sqlDataMode = new SqlDataMode();
        String[][] readTable =sqlDataMode.readTable(check,columnName);
        return !(readTable.length == 0);
    }
    public void remove(String userName,String password,String accessLevel){
        String delete ="DELETE FROM Login Where UserName ='" + userName+"' And Password='" + password+"' And AccessLevel='" + accessLevel+"'";
        SqlDataMode dataMode = new SqlDataMode();
        dataMode.sqlExecute(delete);
    }
    public void registerStaff(){

    }
}
