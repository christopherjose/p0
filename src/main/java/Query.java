import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Query {

    Connection conn = null;

    public void connectDatabase() {  //throws SQLException
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:sales_orders.db");

            //System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }

    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
    //            System.out.println("Connection to SQLite has been closed");
            }
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

}
