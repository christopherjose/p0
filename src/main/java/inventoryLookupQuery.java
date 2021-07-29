import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inventoryLookupQuery {

    HashMap<String, OrderProduct> productSearchResults = new HashMap<String, OrderProduct>();
    OrderProduct product;
    CustomerAccount customerObj;
    Connection conn = null;


    //----------------------------------------------------------------------------------------------------------------
    //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE
    //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE //CONNECT AND CLOSE
    //----------------------------------------------------------------------------------------------------------------


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
                //  System.out.println("Connection to SQLite has been closed");
            }
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }


    //----------------------------------------------------------------------------------------------------------------
    //BUILD WHERE STATEMENT  //BUILD WHERE STATEMENT     //BUILD WHERE STATEMENT     //BUILD WHERE STATEMENT
    //BUILD WHERE STATEMENT  //BUILD WHERE STATEMENT     //BUILD WHERE STATEMENT     //BUILD WHERE STATEMENT=
    //----------------------------------------------------------------------------------------------------------------


    public static StringBuilder buildSQLWhere(String productId, String productName, String size, String disposition, String vendorName, String type){

        String[] searchValues = {productId, productName, size, disposition,vendorName,type};
        String[] searchTerms = {"product_id", "product_name", "size", "disposition", "vendor_name","type"};

        StringBuilder sqlWhere = new StringBuilder("WHERE ");

        for(int j=0; j<6;j++){

            if(j==0){ if(!searchValues[j].equals("")){
                sqlWhere.append(searchTerms[j]).append("= '").append(searchValues[j]).append("'"); }}

            else if(sqlWhere.toString().equals("WHERE ")){
                if(!searchValues[j].equals("")){
                    sqlWhere.append(searchTerms[j]).append("= '").append(searchValues[j]).append("'"); }}

            else if(!searchValues[j].equals("")){
                sqlWhere.append(" AND ").append(searchTerms[j]).append("= '").append(searchValues[j]).append("'"); }}

        if(sqlWhere.toString().equals("WHERE ")){
            sqlWhere = new StringBuilder("WHERE product_id = 'xxxx';"); } //prevents all customers from being returned
        else{sqlWhere.append(";"); }

        return sqlWhere;

    }

    //--------------------------------------------------------------------------------------------------------------------------
    //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE
    //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE //QUERY DATABASE
    //--------------------------------------------------------------------------------------------------------------------------



    public HashMap<String, OrderProduct> viewProduct(String productId, String productName, String size, String disposition,String vendorName, String type){

        String sql = "select * from "+"inventory"+" " +buildSQLWhere(productId, productName, size, disposition,vendorName, type);

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String qProductId = rs.getString("product_id");
                String qVendorName = rs.getString("vendor_name");
                String qStickerPrice = rs.getString("sticker_price");
                String qProductName = rs.getString("product_name");
                String qSize = rs.getString("size");
                String qDisposition = rs.getString("disposition");
                String qQuantity = rs.getString("quantity");
                String qAtpDate = rs.getString("atp_date");
                String qType = rs.getString("type");


                productSearchResults.put(qProductId, new OrderProduct(qProductId, qProductName,qSize, qDisposition, qVendorName, qAtpDate));

                System.out.println("----------------------------------------");
                System.out.println("Product Name    : "+qProductName);
                System.out.println("Size            : "+qSize);
                System.out.println("Disposition     : "+qDisposition);
                System.out.println("Quantity        : "+qQuantity);
                System.out.println("ATP Date        : "+qAtpDate);
                System.out.println("");


                System.out.println("Sticker Price   : $"+qStickerPrice);
                System.out.println("Product Type    : "+qType);
                System.out.println("Vendor Name     : "+qVendorName);
                System.out.println("Product ID      : "+qProductId);
                System.out.println("");
                System.out.println("Press 'b' to go back");
                System.out.println("----------------------------------------");
                System.out.println("");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return productSearchResults;
    }



    public HashMap<String, OrderProduct> productQuery(String productId, String productName, String size, String disposition,String vendorName, String type) {

        connectDatabase();
        HashMap<String, OrderProduct> result = viewProduct(productId, productName, size, disposition,vendorName,type);
        close();
        return result;
    }

    public static void main(String[] args) { //throws SQLException
        inventoryLookupQuery inventoryLookup = new inventoryLookupQuery();
        inventoryLookup.connectDatabase();
        inventoryLookup.viewProduct("","","Queen","","","");
        inventoryLookup.close();

    }


}