import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class productLookupQuery {

    HashMap<String, OrderProduct> productSearchResults = new HashMap<String,OrderProduct>();
    Connection conn = null;


    //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE
    //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE
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

    //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE
    //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE   //CONNECT AND CLOSE




    public HashMap<String, OrderProduct> viewProduct(String orderId) {

        String sql = "select * from "+"order_products"+" where order_id = '"+orderId+"'";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {


                String qOrderId = rs.getString("order_id");
                String qProductId = rs.getString("product_id");
                String qProductName = rs.getString("product_name");
                String qSize = rs.getString("size");
                String qDisposition = rs.getString("disposition");
                int qQuantity = rs.getInt("quantity");
                float qStickerPrice = rs.getFloat("sticker_price");
                float qSalePrice = rs.getFloat("sale_price");
                float qPercDiscount = rs.getFloat("perc_discount");
                float qTotalSalePrice = rs.getFloat("total_sale_price");

                System.out.println(qProductName);


                productSearchResults.put(qOrderId,
                        new OrderProduct(qOrderId, qProductId,qProductName, qSize,
                                qDisposition, qQuantity, qStickerPrice, qSalePrice, qPercDiscount, qTotalSalePrice));
            }


        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productSearchResults;
    }



    public HashMap<String, OrderProduct> productQuery(String orderId) {

        connectDatabase();
        HashMap<String, OrderProduct> result = viewProduct(orderId);
        close();
        return result;
    }






    public static void main(String[] args) { //throws SQLException
        productLookupQuery findOrder = new productLookupQuery();
        findOrder.connectDatabase();
        findOrder.viewProduct("s0001");
        findOrder.close();

    }











}
