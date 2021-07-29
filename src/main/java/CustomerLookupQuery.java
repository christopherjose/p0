import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerLookupQuery  {

    Map<String, CustomerAccount> customerSearchResults = new HashMap<String,CustomerAccount>();
    CustomerAccount customerObj;
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
              //  System.out.println("Connection to SQLite has been closed");
            }
        } catch (SQLException e2) {
            System.out.println(e2.getMessage());
        }
    }

    public static StringBuilder buildSQLWhere(
            String customerId, String firstName, String lastName, String primaryPhoneNo, String emailAddress,
            String address, String address2, String city, String state, String zip){

        String[] searchValues = {customerId, firstName, lastName, primaryPhoneNo,
                emailAddress, address, address2, city, state, zip};

        String[] searchTerms = {"customer_id", "first_name", "last_name", "primary_phone_no",
                "email_address", "address", "address2", "city", "state", "zip"};

        StringBuilder sqlWhere = new StringBuilder("WHERE ");

        for(int j=0; j<9;j++){

            if(j==0){ if(!searchValues[j].equals("")){
                sqlWhere.append(searchTerms[j]).append("= '").append(searchValues[j]).append("'"); }}

            else if(sqlWhere.toString().equals("WHERE ")){
                if(!searchValues[j].equals("")){
                    sqlWhere.append(searchTerms[j]).append("= '").append(searchValues[j]).append("'"); }}

            else if(!searchValues[j].equals("")){
                sqlWhere.append(" AND ").append(searchTerms[j]).append("= '").append(searchValues[j]).append("'"); }}

        if(sqlWhere.toString().equals("WHERE ")){
            sqlWhere = new StringBuilder("WHERE customer_id = 'xxxx';"); } //prevents all customers from being returned
        else{sqlWhere.append(";"); }

        return sqlWhere;

    }

    public Map<String, CustomerAccount> viewCustomer(
            String customerId, String firstName, String lastName, String primaryPhoneNo, String emailAddress,
            String address, String address2, String city, String state, String zip){

        String sql = "select * from "+"customer_accounts"+" " +buildSQLWhere(customerId,
                firstName,lastName, primaryPhoneNo, emailAddress, address, address2, city, state, zip);


        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String qCustomerId = rs.getString("customer_id");
                String qFirstName = rs.getString("first_name");
                String qLastName = rs.getString("last_name");
                String qPrimaryPhoneNo = rs.getString("primary_phone_no");
                String qEmailAddress = rs.getString("email_address");
                String qAddress = rs.getString("address");
                String qAddress2 = rs.getString("address2");
                String qCity = rs.getString("city");
                String qState = rs.getString("state");
                String qZip = rs.getString("zip");

                customerSearchResults.put(qCustomerId,
                        new CustomerAccount(qCustomerId, qFirstName,qLastName, qPrimaryPhoneNo,
                                qEmailAddress, qAddress, qAddress2, qCity, qState, qZip));

                System.out.println("Customer ID  : "+qCustomerId);
                System.out.println("First Name   : "+qFirstName);
                System.out.println("Last Name    : "+qLastName);
                System.out.println("Phone Number : "+qPrimaryPhoneNo);
                System.out.println("Email Address: "+qEmailAddress);
                System.out.println("Address      : "+qAddress);
                System.out.println("Address2     : "+qAddress2);
                System.out.println("City         : "+qCity);
                System.out.println("State        : "+qState);
                System.out.println("Zip          : "+qZip);
                System.out.println("");
                System.out.println("Press 'b' to go back");
                System.out.println("");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customerSearchResults;
    }



    public CustomerAccount createCustomer(String customerId){

        String sql = "select * from "+"customer_accounts where customer_id = '"+customerId+"'";;

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String qCustomerId = rs.getString("customer_id");
                String qFirstName = rs.getString("first_name");
                String qLastName = rs.getString("last_name");
                String qPrimaryPhoneNo = rs.getString("primary_phone_no");
                String qEmailAddress = rs.getString("email_address");
                String qAddress = rs.getString("address");
                String qAddress2 = rs.getString("address2");
                String qCity = rs.getString("city");
                String qState = rs.getString("state");
                String qZip = rs.getString("zip");

               customerObj = new CustomerAccount(qCustomerId, qFirstName,qLastName, qPrimaryPhoneNo,
                                qEmailAddress, qAddress, qAddress2, qCity, qState, qZip);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return customerObj;
    }


    public CustomerAccount createCustomerQuery(String customerId) {

        connectDatabase();
        CustomerAccount result = createCustomer(customerId);
        close();
        return result;
    }

    public Map<String, CustomerAccount> customerQuery(
            String customerId, String firstName, String lastName, String primaryPhoneNo, String emailAddress,
            String address, String address2, String city, String state, String zip) {

        connectDatabase();
        Map<String, CustomerAccount> result = viewCustomer(customerId, firstName, lastName, primaryPhoneNo, emailAddress, address, address2, city, state, zip);
        close();
        return result;
    }

    public static void main(String[] args) { //throws SQLException
        CustomerLookupQuery custLookup = new CustomerLookupQuery();
        custLookup.connectDatabase();
        custLookup.viewCustomer("","","Bluetooth","","","","","","","");
        custLookup.close();

    }


}
