package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DB_DRIVER ="org.sqlite.JDBC";
    private static final String USERNAME ="dbUser";
    private static final String PASSWORD ="dbPassword";
    private static final String SQCONN ="jdbc:sqlite:cms.sqlite";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(SQCONN);
        if (conn != null){
            System.out.println("Database Connection Successfully");
        }
        else {
            System.out.println("Database Connection Failed");
        }
        return conn;
    }
}
