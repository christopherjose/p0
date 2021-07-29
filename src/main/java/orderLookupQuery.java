import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class orderLookupQuery {

    Map<String, SalesOrder> orderSearchResults = new HashMap<String,SalesOrder>();
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
                //System.out.println("Connection to SQLite has been closed");
            }
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public Map<String, SalesOrder> viewOrder(String Id) {
        String sql = null;

        if(Id.toString().contains("s") ) {
            sql = "select * from "+"sales_orders"+" where order_id = '"+Id+"'"; }
        else if(Id.toString().contains("c") ) {
            sql = "select * from "+"sales_orders"+" where customer_id = '"+Id+"'"; }

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String qCustomerId = rs.getString("customer_id");
                String qOrderId = rs.getString("order_id");
                String qStatus = rs.getString("status");
                String qComment = rs.getString("comment");
                String qSalesAssociate = rs.getString("sales_associate");
                String qOrderDate = rs.getString("order_date");
                float qSubTotal = rs.getFloat("sub_total");
                float qSalesTax = rs.getFloat("sales_tax");
                float qTotalOrderAmount = rs.getFloat("total_order_amount");
                float qFinancing = rs.getFloat("financing");
                float qBalancedDue = rs.getFloat("balance_due");


                orderSearchResults.put(qOrderId,
                        new SalesOrder(qCustomerId, qOrderId,qStatus, qComment,
                                qSalesAssociate, qOrderDate, qSubTotal, qSalesTax, qTotalOrderAmount, qFinancing, qBalancedDue));

                System.out.println("Order ID     : "+qOrderId);
                System.out.println("Order Date   : "+qOrderDate);
                System.out.println("Order Amount : "+qTotalOrderAmount);
                System.out.println("Status       : "+qStatus);
                System.out.println("Associate    : "+qSalesAssociate);
                System.out.println("");
                System.out.println("Press 'b' to go back");
                System.out.println("");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return orderSearchResults;
    }

    public Map<String, SalesOrder> orderQuery(String orderId) {

        connectDatabase();
        Map<String, SalesOrder> result = viewOrder(orderId);
        close();
        return result;
    }

    public static void main(String[] args) { //throws SQLException
        orderLookupQuery findOrder = new orderLookupQuery();
        findOrder.connectDatabase();
        findOrder.viewOrder("s0001");
        findOrder.close();

    }


}
