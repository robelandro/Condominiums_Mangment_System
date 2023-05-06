package dbUtil;

import helper.people.ResidentData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlDataMode {

    public ObservableList<ResidentData> dataObservableList;

    public void createTableId(){
        String sqlTable ="CREATE TABLE IDGenerator (residentGenerated INTEGER)";
        Connection connection;
        PreparedStatement statement;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(sqlTable);
            statement.executeUpdate();
            statement.close();
            connection.close();
        }catch (SQLException e){

        }
    }

    public void addDataResident(String residentId,String tableName, String firstName, String lastName, String address , String age , String sex, String phoneNumber, String blockNumber, String houseNumber, String rentStatus){
        String sqlInsert = "INSERT INTO "+tableName+" (ResidentId,FirstName,LastName,Address,Age,Sex,PhoneNumber,BlockNumber,HouseNumber,RentStatus) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlInsert);
            statement.setString(1,residentId);
            statement.setString(2,firstName);
            statement.setString(3,lastName);
            statement.setString(4,address);
            statement.setString(5,age);
            statement.setString(6,sex);
            statement.setString(7,phoneNumber);
            statement.setString(8,blockNumber);
            statement.setString(9,houseNumber);
            statement.setString(10,rentStatus);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void programTracker(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (numCount INTEGER GENERATED ALWAYS AS IDENTITY,"+
                "StartUp BOOLEAN," +
                "RememberMe BOOLEAN," +
                "RememberName VarChar(30)," +
                "UserName VarChar(30))";
        String sqlInsert = "INSERT INTO "+tableName+" (StartUp,RememberMe) VALUES (true,false)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlTable);
            statement.execute();
            System.out.println("Table created successfully.");
            statement = connection.prepareStatement(sqlInsert);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Table created Excite.");

            /*System.exit(1);*/
        }
    }

    public boolean rememberMe(String tableName){
        String sqlRead = "SELECT * FROM "+tableName;
        Connection connection = null;
        PreparedStatement statement ;
        ResultSet resultSet;
        try {
            connection =DbConnection.getConnection();
            statement = connection.prepareStatement(sqlRead,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery();
            resultSet.first();
            if(resultSet.getBoolean("RememberMe")){
                return true;
            }
            return false;
        }
        catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void rememberMeUpdate(String tableName ,boolean rem){
        String rememberUpdater = "UPDATE "+tableName+
                " SET RememberMe = ?"+
                " WHERE numCount = 1";
        Connection connection = null;
        PreparedStatement statement ;
        try {
            connection=DbConnection.getConnection();
            statement = connection.prepareStatement(rememberUpdater);
            statement.setBoolean(1,rem);
            statement.executeUpdate();
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isStarUp(String tableName){
        String sqlRead = "SELECT * FROM "+tableName;
        Connection connection = null;
        PreparedStatement statement ;
        ResultSet resultSet ;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(sqlRead,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultSet = statement.executeQuery();
            resultSet.first();
            if (resultSet.getBoolean("StartUp")){
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException e){
            //e.printStackTrace();
            return false;
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public String hintForget(String tableName,String hint){

        String sqlRead = "SELECT * FROM "+tableName+" WHERE Hint = ?";
        Connection connection ;
        PreparedStatement statement ;
        ResultSet resultSet;
        try {
            connection = DbConnection.getConnection();
            statement = connection.prepareStatement(sqlRead);
            statement.setString(1,hint);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
            return "Your Credential \nUsername : "+resultSet.getString("UserName")+
                    "\nPassword : "+resultSet.getString("Password");
            }
            else {
                return "No Credential With this input";
            }

        }
        catch (SQLException e){
            return "No Credential With this input";
        }
    }
    public void readResident (String tableName){
        Connection connection = null;
        ResultSet resultSet = null;
        dataObservableList = FXCollections.observableArrayList();
        String sqlRead ="SELECT NumCount , ResidentId ,FirstName , LastName , Age , Sex ,PhoneNumber , BlockNumber , HouseNumber , RentStatus ,Area ,Floor,Part FROM "+tableName;

        try {
            connection = DbConnection.getConnection();
            dataObservableList = FXCollections.observableArrayList();
            PreparedStatement statement =connection.prepareStatement(sqlRead);
            resultSet =statement.executeQuery();
            while (resultSet.next()){
                dataObservableList.add(new ResidentData(resultSet.getInt("NumCount"),resultSet.getString("ResidentId"),resultSet.getString("FirstName"),resultSet.getString("LastName"),resultSet.getString("Age"),resultSet.getString("Sex"),resultSet.getString("PhoneNumber"),resultSet.getString("BlockNumber"),resultSet.getString("HouseNumber"),resultSet.getString("RentStatus"),resultSet.getString("Area"),resultSet.getString("Floor"),resultSet.getString("Part")));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //new added Database
    public void updateTableSql(String sqlUpdate,String[] updateValueSql){
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sqlUpdate);
            for (int i = 0 ;i<updateValueSql.length;i++){
                preparedStatement.setString(i+1,updateValueSql[i]);
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTable(String sqlTable){
        Connection conn ;
        PreparedStatement preparedStatement;
        try {
            conn=DbConnection.getConnection();
            preparedStatement=conn.prepareStatement(String.valueOf(sqlTable));
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public void remove(String sqlRemove, int[] indexValue){
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sqlRemove);
            for (int index :indexValue){
                preparedStatement.setString(index,"");
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertTable(String sqlInsert,String[] insertValue){
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sqlInsert);
            for (int i = 0;i<insertValue.length;i++){
                preparedStatement.setString(i+1,insertValue[i]);
            }
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String [][] readTable(String sql,String [] nameOfColumn){
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        int iValue = lastRow(sql);
        String[][] outRead = new String[iValue][nameOfColumn.length];
        int j =-1;
        try {
            connection=DbConnection.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                j++;
                for (int i = 0;i<nameOfColumn.length;i++){
                    outRead[j][i]=resultSet.getString(nameOfColumn[i]);
                }
            }
            connection.close();
            return outRead;
        }
        catch (SQLException e){
            System.out.println(e);
            return outRead;
        }
    }
    public int lastRow(String sql){
        Connection connection;
        PreparedStatement preparedStatement2;
        ResultSet resultSet2;
        try {
            int row = 0;
            connection =DbConnection.getConnection();
            preparedStatement2 = connection.prepareStatement(sql);
            resultSet2= preparedStatement2.executeQuery();
            while (resultSet2.next()){
                row++;
            }
            resultSet2.close();

            return row;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return 0;
        }
    }
    public void makeTable(String itrname,String tablename,String value){
        String sql = "INSERT INTO "+tablename+" ("+itrname+") VALUES (?)";
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection=DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,value);
            preparedStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String dbCheckInsert(String tablename,String where,String where2){
        String value="error";
        String sql ="SELECT * FROM "+tablename+" WHERE "+where+" IS NULL AND "+where2+" IS NULL";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet= preparedStatement.executeQuery();
            resultSet.first();
            value = resultSet.getString("numCount");
            System.out.println(value);
            connection.close();
            return value;
        } catch (SQLException e) {
            e.printStackTrace();
            return value;
        }
    }
    public String dbCheckInsertExit(String tablename,String where,String where3,String values){
        String value="error";
        String sql ="SELECT * FROM "+tablename+" WHERE "+where+" IS NULL AND "+where3+" = '"+values+"'";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet= preparedStatement.executeQuery();
            resultSet.first();
            value = resultSet.getString("numCount");
            System.out.println(value);
            connection.close();
            return value;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return value;
        }
    }
    public boolean houseNumberExit(String houseNumber){
        boolean chcked = false;
        String sql ="SELECT HouseNumber FROM Resident WHERE HouseNumber = ?";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,houseNumber);
            resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                if (resultSet.getString("HouseNumber").equals(houseNumber)){
                    chcked = true;
                }
                else {
                    chcked = false;
                }
            }
            return chcked;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return chcked;
        }
    }
    public void sqlExecute(String sql){
        Connection connection;
        PreparedStatement preparedStatement;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String rememberName(){
        String read ="Select RememberName From Program Where NumCount = 1";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String answer=null;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(read,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultSet = preparedStatement.executeQuery();
            resultSet.first();
            answer = resultSet.getString("RememberName");
            connection.close();
            return answer;
        } catch (SQLException e) {
            e.printStackTrace();
            return answer;
        }
    }
    public String userName(){
        String sqlRead ="Select UserName From Program Where NumCount = 1";
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String answer=null;
        try {
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sqlRead,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            resultSet = preparedStatement.executeQuery();
            resultSet.first();
            answer = resultSet.getString("UserName");
            connection.close();
            return answer;
        } catch (SQLException e) {
            e.printStackTrace();
            return answer;
        }
    }

}
