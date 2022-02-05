package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String DB_URL="jdbc:derby:cmsDatabase;create=true";
    private static final String DB_DRIVER ="org.apache.derby.jdbc.EmbeddedDriver";
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection(DB_URL);
        if (conn != null){
            System.out.println("Database Connection Successfully");
        }
        else {
            System.out.println("Database Connection Failed");
        }
        return conn;
    }
}
