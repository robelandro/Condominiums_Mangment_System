package helper;

import dbUtil.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Resident extends Person{
    public Resident(String firstName, String lastName, int age, String address, String sex) {
        super(firstName, lastName, age, address, sex);
    }
    public void registration(){

    }
    public static void createTable(String tableName){
        String sqlTable = "CREATE TABLE "+tableName+" (Id INTEGER PRIMARY KEY AUTOINCREMENT,FirstName STRING,LastName STRING,Id_Number INTEGER,Age INTEGER,Gender STRING)";
        Connection connection ;
        PreparedStatement statement ;
        try {
            connection = DbConnection.getConnection();
            statement =connection.prepareStatement(sqlTable);
            statement.execute();
            statement.close();
            connection.close();
            System.out.println("Table created successfully.");
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("Table created Excite.");

            /*System.exit(1);*/
        }
    }
}
