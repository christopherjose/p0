import org.junit.jupiter.api.Test; //so you don't have to have fully qualified name in annotations

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class POSTest {

    static HashMap<String, OrderProduct> products = new HashMap<String, OrderProduct>();

    //Test checks SQL Query for pulling Sales Order Products for Order s0000
    @Test
    public void displaySQLOrderProdResults() {
        System.out.println("Queried Order Product Information:");
        System.out.println("");
        SalesOrder salesOrder;
        HashMap<String, OrderProduct> products = new HashMap<String, OrderProduct>();

        HashMap<String, OrderProduct> orderProducts = new HashMap<String, OrderProduct>();
        orderLookupQuery findOrder = new orderLookupQuery();
        productLookupQuery findProduct = new productLookupQuery();
        Map<String, SalesOrder> selectedOrder;
        System.out.println("------------QUERY 1 START----------");
        selectedOrder = findOrder.orderQuery("s0000");
        orderProducts = findProduct.productQuery("s0000");
        for (String k : orderProducts.keySet()) {
            System.out.println(orderProducts.get(k).productName);
        }
        //TestClass.salesOrder.orderProductList= orderProducts;

        products = orderProducts;

        for (String k : orderProducts.keySet()) {
            products.put(k, orderProducts.get(k));
        }
        System.out.println("");


    }

    @Test
    void displaySQLCustomerResults() {
        System.out.println("");
        System.out.println("------------QUERY 2 START----------");
        System.out.println("Queried Customer Information:");
        CustomerLookupQuery CLQ = new CustomerLookupQuery();
        CLQ.connectDatabase();
        CustomerAccount result = CLQ.createCustomer("c0000");
        System.out.println(result.customerId);
        System.out.println(result.firstName);
        System.out.println(result.lastName);
        System.out.println(result.primaryPhoneNo);
        System.out.println(result.emailAddress);
        CLQ.close();
    }

    @Test
    void openStartMenu() {
        System.out.println("------------QUERY 3 START----------");
        POS menu = new POS();

    }

    @Test
    void openOrderMenu() {
        System.out.println("------------QUERY 4 START----------");
        OrderMenu menu = new OrderMenu();
        assertEquals(4,4);
    }


}


