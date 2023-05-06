package helper.staf;

import dbUtil.SqlDataMode;

public class Broker {
    public String [][] getInfo(String area,String saleOr,String part,boolean lessThan){
        String read;
        if (lessThan){
            read ="Select BlockNumber,PhoneNumber,HouseNumber,Money,Scenario,Area,Floor,Part From Resident Where Area <="+area+" And SaleOr ='"+saleOr+"' And Part ='"+part+"'";
        }
        else {
            read ="Select BlockNumber,PhoneNumber,HouseNumber,Money,Scenario,Area From Resident Where Area >="+area+" And SaleOr ='"+saleOr+"' And Part ='"+part+"'";
        }
        String [] column={"BlockNumber","PhoneNumber","HouseNumber","Money","Scenario","Area","Floor","Part"};
        SqlDataMode dataMode = new SqlDataMode();
        String[][] re = dataMode.readTable(read,column);
        return re;
    }
    public String [][] getInfo(String area,String saleOr,String floor,String part,boolean lessThan){
        String read;
        if (lessThan){
            read ="Select BlockNumber,PhoneNumber,HouseNumber,Money,Scenario,Area,Floor,Part From Resident Where Area <='"+area+"' And SaleOr ='"+saleOr+"' And Floor ='"+floor+"' And Part ='"+part+"'";
        }
        else {
            read ="Select BlockNumber,PhoneNumber,HouseNumber,Money,Scenario,Area,Floor,Part From Resident Where Area >='"+area+"' And SaleOr ='"+saleOr+"' And Floor ='"+floor+"' And Part ='"+part+"'";
        }
        String [] column={"BlockNumber","PhoneNumber","HouseNumber","Money","Scenario","Area","Floor","Part"};
        SqlDataMode dataMode = new SqlDataMode();
        String[][] re = dataMode.readTable(read,column);
        return re;
    }
    public String [][] froSaleOr(boolean forSale){
        String read;
        String saleOr;
        if (forSale){
            saleOr = "ForSale";
        }
        else {
            saleOr = "ForRent";
        }
        read ="Select BlockNumber,PhoneNumber,HouseNumber,Money,Scenario,Area,Floor,Part From Resident Where SaleOr ='"+saleOr+"'";
        String [] column={"BlockNumber","PhoneNumber","HouseNumber","Money","Scenario","Area","Floor","Part"};
        SqlDataMode dataMode = new SqlDataMode();
        String[][] re = dataMode.readTable(read,column);
        return re;
    }
}
