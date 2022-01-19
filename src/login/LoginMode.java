package login;

import dbUtil.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMode {

    public boolean isCorrect(String tableName,String userName,String password,String accessLeve){
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String sqlCheck="SELECT * FROM "+tableName+" WHERE UserId = 1 AND UserName =? AND Password =? AND AccessLevel =?";
        try{
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sqlCheck);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,accessLeve);
            resultSet = preparedStatement.executeQuery();
            preparedStatement.close();
            connection.close();
            resultSet.close();
            if (resultSet.next()){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
