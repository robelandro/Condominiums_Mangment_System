package login;

import dbUtil.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginMode {

    public boolean isCorrect(String tableName,String userName,String password,String accessLeve){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sqlCheck="SELECT * FROM "+tableName+" WHERE UserName =? AND Password =? AND AccessLevel =?";
        try{
            connection = DbConnection.getConnection();
            preparedStatement = connection.prepareStatement(sqlCheck);
            preparedStatement.setString(1,userName);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,accessLeve);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
        finally {
            try {
                preparedStatement.close();
                resultSet.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
