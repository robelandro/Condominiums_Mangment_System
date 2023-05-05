package helper.Info;


import dbUtil.DbConnection;
import dbUtil.SqlDataMode;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResidentInfo extends BasicInfo{
    private String blockNumber;
    private String phoneNumber;
    private String houseNumber;
    private String rentStatus;
    private String area;
    private String floor;
    private String part;
    private String scenario;
    private String money;
    private String saleOr;

    public ResidentInfo(String firstName, String lastName, String age, String sex, String blockNumber, String phoneNumber, String houseNumber, String rentStatus, String area, String floor, String part) {
        super(firstName, lastName, age, sex);
        this.blockNumber = blockNumber;
        this.phoneNumber = phoneNumber;
        this.houseNumber = houseNumber;
        this.rentStatus = rentStatus;
        this.area = area;
        this.floor = floor;
        this.part = part;
    }

    public ResidentInfo(String area, String floor, String saleOr) {
        this.area = area;
        this.floor = floor;
        this.saleOr = saleOr;
    }

    public ResidentInfo(String area, String saleOr) {
        this.area = area;
        this.saleOr = saleOr;
    }
    public boolean register(){
        boolean register = false;
        String idGen = null;
        if (getRentStatus().equals("Rent")){
            idGen ="RT";
        }
        else {
            idGen ="OW";
        }
        SqlDataMode dataMode = new SqlDataMode();
        String residentId;
        String sqlRegister ="UPDATE Resident SET  ResidentId = ?,FirstName = ?,LastName = ?,Age = ?,Sex =?,PhoneNumber = ?,BlockNumber= ?,HouseNumber=?, RentStatus =? "+
                ",Area =?,Floor =?,Part =? WHERE numCount=?";
        String sqlCheck ="SELECT * FROM IDGenerator";
        String sqlIn="INSERT INTO IDGenerator (residentGenerated) VALUES (2)";
        String [] checkabel ={"Resident","FirstName","LastName","HouseNumber",getHouseNumber()};
        Connection connection = null;
        PreparedStatement insert = null;
        PreparedStatement check;
        PreparedStatement autoIncrease;
        ResultSet resultSetCheck;
        try {
            connection = DbConnection.getConnection();
            insert = connection.prepareStatement(sqlIn);
            check =connection.prepareStatement(sqlCheck);
            resultSetCheck = check.executeQuery();
            if (resultSetCheck.next()){
                residentId =idGen+resultSetCheck.getInt("residentGenerated");
                int count;
                count =resultSetCheck.getInt("residentGenerated")+1;
                String counted =String.valueOf(count) ;
                String sqlUpdate ="UPDATE IDGenerator SET residentGenerated = "+counted;
                autoIncrease=connection.prepareStatement(sqlUpdate);
                autoIncrease.executeUpdate();
                autoIncrease.close();
                connection.close();

            }
            else {
                insert.executeUpdate();
                residentId =idGen+"1";
            }
            connection.close();
            String which;
            if(!dataMode.dbCheckInsertExit(checkabel[0],checkabel[1],checkabel[3],checkabel[4]).equals("error")){
                which =dataMode.dbCheckInsertExit(checkabel[0],checkabel[1],checkabel[3],checkabel[4]);
                System.out.println("erro");
            }
            else if(dataMode.houseNumberExit(getHouseNumber())){
                System.out.println("ppp");
                which = "error";
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("UNHALLOWED ACTION");
                alert.setHeaderText("Duplicated House Number");
                alert.showAndWait();
            }
            else{
                which = dataMode.dbCheckInsert(checkabel[0],checkabel[1],checkabel[2]);
                System.out.println("no et");
            }
            String [] valueRe ={residentId,getFirstName(),getLastName(),getAge(),getSex(),getPhoneNumber(),getBlockNumber(),getHouseNumber(),getRentStatus(),getArea(),getFloor(),getPart(),which};
            dataMode.updateTableSql(sqlRegister,valueRe);
            register = true;
        } catch (SQLException e) {
            try {
                insert.executeUpdate();
                connection.close();
                residentId =idGen+"1";
                String which = dataMode.dbCheckInsert(checkabel[0],checkabel[1],checkabel[2]);
                String [] valueRe ={residentId,getFirstName(),getLastName(),getAge(),getSex(),getPhoneNumber(),getBlockNumber(),getHouseNumber(),getRentStatus(),which};
                dataMode.updateTableSql(sqlRegister,valueRe);
                register =true;

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println(e);
            e.printStackTrace();
        }
        return register;
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

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getSaleOr() {
        return saleOr;
    }

    public void setSaleOr(String saleOr) {
        this.saleOr = saleOr;
    }
}
