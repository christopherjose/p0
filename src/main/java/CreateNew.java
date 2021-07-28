import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateNew {
        static Connection conn = null;


        public static void connectCustomer() throws SQLException {

            try {
                conn = DriverManager.getConnection("jdbc:sqlite:sales_orders.db");

                System.out.println("Connection to SQLite has been established.");
            } catch (SQLException e1) {
                System.out.println(e1.getMessage());
            }

        }

        public static void close() {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection to SQLite has been closed");
                }
            } catch (SQLException e2) {
                System.out.println(e2.getMessage());
            }
            System.out.println(conn);

        }

        public static void selectAll(String table) {
            String sql = "select * from "+table;

            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                String customerId = rs.getString("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String primaryPhoneNo = rs.getString("primary_phone_no");
                String emailAddress = rs.getString("email_address");
                String address = rs.getString("address");
                String address2 = rs.getString("address_2");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");

                System.out.println(customerId);
            }
            catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
        }

        public static void main(String[] args) throws SQLException {

            connectCustomer();
            selectAll("customer_accounts");
            close();

        }





    }
