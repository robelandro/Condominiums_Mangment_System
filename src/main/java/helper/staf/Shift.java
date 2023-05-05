package helper.staf;

import dbUtil.SqlDataMode;

public class Shift {
    public void registerShift(String staffName , String [] values){
        String [] days ={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        String insert ="Insert Into Shift (StaffName,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday)" +
                "Values (?,?,?,?,?,?,?,?)";
        if (values.length == 7){
            String [] list ={staffName,values[0],values[1],values[2],values[3],values[4],values[5],values[6]};
            SqlDataMode dataMode = new SqlDataMode();
            dataMode.insertTable(insert,list);
        }
        else{
            System.out.println("Error");
        }
    }
    public String shiftCheck(String name,String dateName){
        String string ="Select "+dateName+" From Shift Where StaffName ='"+name+"'";
        String[] column ={dateName};
        SqlDataMode dataMode =new SqlDataMode();
        String[][] read =dataMode.readTable(string,column);
        if (!(read.length==0)){
            return read[0][0];
        }
        else {
            return null;
        }
    }


}
