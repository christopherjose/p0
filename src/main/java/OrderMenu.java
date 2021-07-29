import java.util.Map;
import java.util.PropertyPermission;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class OrderMenu {

    Scanner  scanner = new Scanner(System.in);

    static Map<String, SalesOrder> salesOrderMap;
    static String                   salesOrderId;
    static SalesOrder                 salesOrder;
    static HashMap<String, OrderProduct>    products;
    HashMap<String,OrderProduct>         placeholder;


    public static void main(String[] args) {

        OrderMenu menu = new OrderMenu();
        menu.runOrderMenu();
        menu.scanner.close();

    }

    //-----------------------------------------------------------------------------------------------------------------
    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU
    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU
    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU
    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU    //ORDER MENU
    //-----------------------------------------------------------------------------------------------------------------


    public void orderMenu() {
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Order Menu");
        System.out.println("---------------");
        System.out.println("");
        System.out.println("1. View Order");
        System.out.println("2. Inventory");
        System.out.println("3. Customer");
        System.out.println("4. Delivery");
        System.out.println("5. Load");
        System.out.println("6. New");
        System.out.println("7. Exit");
        System.out.println("");
    }


    public void runOrderMenu() {

        while (true) {

            orderMenu();
            boolean exit = false;
            String input = scanner.nextLine();

            switch (input) {
                case ("1"):
                    runViewMenu();
                    break;
                case ("2"):
                    runInventoryMenu();
                    break;
                case ("3"):
                    runCustomerMenu();
                    break;
                case ("4"):
                    runDeliveryMenu();
                    break;
                case ("5"):
                    runLoadMenu();
                    break;
                case ("6"):
                    runNewMenu();
                    break;
                case ("7"):
                    exit = true;
                    break;
                default:
            }
            if (exit) {
                break;
            }
        }
    }



    private void runDeliveryMenu() {
        // TODO Auto-generated method stub

    }

    private void runNewMenu() {
        // TODO Auto-generated method stub

    }

    private void runLoadMenu() {
        LoadMenu menu = new LoadMenu();
        menu.runLoadMenu();

    }

    //-----------------------------------------------------------------------------------------------------------------
    //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU
    //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU
    //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU
    //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU     //VIEW MENU
    //-----------------------------------------------------------------------------------------------------------------

    void viewMenu(){
        System.out.println("");
        System.out.println("---------------");
        System.out.println("View Order");
        System.out.println("---------------");
        System.out.println("");
    }

    private void runViewMenu() {

        while (true) {

            boolean exit = false;

            viewMenu();

            for (String k1 : OrderMenu.products.keySet()) {
                System.out.println(OrderMenu.products.get(k1).productName);}



            try {
                if (salesOrder != null) {

                    String customerId = OrderMenu.salesOrder.customerAccount.customerId;
                    String firstName = OrderMenu.salesOrder.customerAccount.firstName;
                    String lastName = OrderMenu.salesOrder.customerAccount.lastName;
                    String primaryPhoneNo = OrderMenu.salesOrder.customerAccount.primaryPhoneNo;
                    String emailAddress = OrderMenu.salesOrder.customerAccount.emailAddress;
                    String address = OrderMenu.salesOrder.customerAccount.address;
                    String address2 = OrderMenu.salesOrder.customerAccount.address2;
                    String city = OrderMenu.salesOrder.customerAccount.city;
                    String state = OrderMenu.salesOrder.customerAccount.state;
                    String zip = OrderMenu.salesOrder.customerAccount.zip;

                    System.out.println("Order ID : " + salesOrderId);
                    System.out.println("Date     : " + salesOrder.orderDate);
                    System.out.println("");
                    System.out.println("Customer ID    : " + customerId);
                    System.out.println("Contact Name   : " + firstName + " " + lastName);
                    System.out.println("Phone No       : " + primaryPhoneNo);
                    System.out.println("Email          : " + emailAddress);
                    System.out.println("Address        : " + address);
                    System.out.println("Address 2      : " + address2);
                    System.out.println("City           : " + city);
                    System.out.println("State          : " + state);
                    System.out.println("Zip Code       : " + zip);
                    System.out.println("");

                    System.out.println("Total Order Amt: " + salesOrder.totalOrderAmount);
                    for (String k1 : OrderMenu.products.keySet()) {
                        System.out.println(OrderMenu.products.get(k1).productName);}

                    for (String k : OrderMenu.salesOrder.orderProductList.keySet()) {
                        System.out.println("Product Name   :" + OrderMenu.salesOrder.orderProductList.get(k).productName);
                        System.out.println("Size           :" + OrderMenu.salesOrder.orderProductList.get(k).size);
                        System.out.println("Disposition    :" + OrderMenu.salesOrder.orderProductList.get(k).disposition);
                        System.out.println("Quantity       :" + OrderMenu.salesOrder.orderProductList.get(k).quantity);
                        System.out.println("Sticker Price  :" + OrderMenu.salesOrder.orderProductList.get(k).stickerPrice);
                        System.out.println("Sale Price     :" + OrderMenu.salesOrder.orderProductList.get(k).salePrice);
                        System.out.println("Delivery Date  :" + OrderMenu.salesOrder.orderProductList.get(k).deliveryDate);
                    }
                }
            }
                catch (Exception e) { }
            System.out.println("Press 'b' to exit");

            String input = scanner.nextLine();

            if (input.equals("b")) {
                exit = true;
            }

            if (exit) {
                break;
            }
        }


    }

    //-----------------------------------------------------------------------------------------------------------------
    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU
    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU
    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU
    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU    //INVENTORY MENU
    //-----------------------------------------------------------------------------------------------------------------


    private void runInventoryMenu() {

        String productId = "";
        String productName = "";
        String size = "";
        String disposition = "";
        String vendorName = "";
        String type = "";
        HashMap<String,OrderProduct> selectedProducts=new HashMap<String,OrderProduct>();

        while (true) {

            System.out.println("");
            System.out.println("---------------");
            System.out.println("Inventory Menu");
            System.out.println("---------------");
            System.out.println("");
            System.out.println("1. Product ID     : " + productId);
            System.out.println("2. Product Name   : " + productName);
            System.out.println("3. Size           : " + size);
            System.out.println("4. Disposition    : " + disposition);
            System.out.println("5. Vendor Name    : " + vendorName);
            System.out.println("6. Type           : " + type);
            System.out.println("");

            System.out.println("Press 'v' to view selected products");
            System.out.println("Press 's' to search inventory");
            System.out.println("Press 'b' to go back");
            System.out.println("");

            boolean exit = false;
            boolean search = false;
            String input = scanner.nextLine();

            switch (input) {
                case ("1"):
                    productId = scanner.nextLine();
                    break;
                case ("2"):
                    productName = scanner.nextLine();
                    break;
                case ("3"):
                    size = scanner.nextLine();
                    break;
                case ("4"):
                    disposition = scanner.nextLine();
                    break;
                case ("5"):
                    vendorName = scanner.nextLine();
                    break;
                case ("6"):
                    type = scanner.nextLine();
                    break;
                case("v"):
                    runViewProductMenu(selectedProducts);
                    break;
                case ("s"):
                  // try {
                    HashMap<String,OrderProduct> result=queryProductData(productId, productName, size, disposition,vendorName,type);
                    if (result!=null) {
                          try {
                              String resultKey = result.keySet().iterator().next();
                              OrderProduct resultProduct = result.get(resultKey);
                              selectedProducts.put(resultKey,resultProduct);
                          }

                          catch (Exception e) {};

                      }

                    break;
                case ("b"):
                    exit = true;
                    break;
                default:
            }

            if (exit) {
                break;
            }
        }
    }

    //VIEW SELECTED PRODUCTS    //VIEW SELECTED PRODUCTS    //VIEW SELECTED PRODUCTS    //VIEW SELECTED PRODUCTS
    //VIEW SELECTED PRODUCTS    //VIEW SELECTED PRODUCTS    //VIEW SELECTED PRODUCTS    //VIEW SELECTED PRODUCTS

    public void runViewProductMenu(HashMap<String,OrderProduct> selectedProducts) {



        while(true) {
            boolean exit = false;

            System.out.println("");
            System.out.println("---------------");
            System.out.println("Selected Product");
            System.out.println("---------------");
            System.out.println("");

            try {

                System.out.println("");

                for (String j : selectedProducts.keySet()) {
                    System.out.println("1. Product ID     : " + selectedProducts.get(j).productId);
                    System.out.println("2. Product Name   : " + selectedProducts.get(j).productName);
                    System.out.println("3. Size           : " + selectedProducts.get(j).size);
                    System.out.println("4. Disposition    : " + selectedProducts.get(j).disposition);
                    System.out.println("5. Quantity       : " + selectedProducts.get(j).quantity);
                    System.out.println("");
                }
            } catch (Exception e) {
            }
            System.out.println("Press 'a' to add products to order");
            System.out.println("Press 'r' to remove a product");
            System.out.println("Press 'b' to exit");

            String input = scanner.nextLine();
            if (input.equals("b")) { break;}
            if (input.equals("r")) {
                while(true) {
                    boolean exit2 = false;
                    System.out.println("Specify Product ID to remove ('b' for back):");
                    String input2 = scanner.nextLine();
                    if(input2.equals("b")) {
                        exit2=true;
                    }
                    if(selectedProducts.containsKey(input2)) {
                        selectedProducts.remove(input2);
                        exit2 = true;
                    }
                    else{System.out.println("Try again.  Specified Product ID is not a selected product. ") ; }
                    if(exit2=true) {
                        break;
                    }
                }


            }




            //COMMIT CHANGES
            //OrderMenu.salesOrder.orderProductList.get(selectedProductId).quantity = selectedQuantity;
        }
    }



    public void InventorySearchResultsMenu (){
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Search Results");
        System.out.println("---------------");
        System.out.println("");
    }




    //QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY
    //Queries database, returns a map of (product id, product) as Search Result + prints result , Uses selectProduct Query to pick a product (id, product)

public HashMap<String, OrderProduct> queryProductData(String productId,String productName, String size, String disposition, String vendorName,String type) {

    HashMap<String, OrderProduct> selectedProduct;

        while(true) {

            boolean exit = false;
            InventorySearchResultsMenu();
            inventoryLookupQuery findProduct = new inventoryLookupQuery();
            HashMap<String, OrderProduct> searchResult = findProduct.productQuery(productId,productName, size, disposition,vendorName,type);
            selectedProduct=selectProduct(searchResult);



            exit=true;
            if (exit) { break; }
        }

    return selectedProduct;

}

    //QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY QUERY
 //selects a String, Product and returns it
  public HashMap<String,OrderProduct> selectProduct(HashMap<String, OrderProduct> searchResult){

      boolean exit = false;
      HashMap<String,OrderProduct> selectedProduct=new HashMap<String,OrderProduct>();
      String selectedProductId;

      while (true) {

          System.out.println("");
          System.out.println("Select Product ID ('b' to exit):");
          selectedProductId = scanner.nextLine();

          if (selectedProductId.equals("b")) {
              exit = true;
              break;}
          if (searchResult.containsKey(selectedProductId)) {
              try {
                  selectedProduct.put(selectedProductId,searchResult.get(selectedProductId));
                  OrderMenu.salesOrder.orderProductList.put(selectedProductId,searchResult.get(selectedProductId)); }
              catch (Exception e) {}

              //If you select a product, then you select the quantity--->
              while(true) {
                    System.out.println("");
                    System.out.println("Select Quantity:");
                  try {
                      String selectedQuantityStr = scanner.nextLine();
                      selectedProduct.get(selectedProductId).quantity = Integer.parseInt(selectedQuantityStr);
                      break;}
                  catch (Exception e) {System.out.println("Select Again.  Provided quantity is not a valid number.");}

              }
              exit = true;
              break;}

          else {
              System.out.println("Select Again.  Product ID is not in search result."); }
      }







      return selectedProduct;
  }











    //-----------------------------------------------------------------------------------------------------------------
    //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU
    //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU
    //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU
    //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU   //CUSTOMER MENU
    //------------------------------------------------------------------------------------------------------------------

    public void runCustomerMenu() {
        customerMenu();
    }

    public void customerMenu() {

        if (OrderMenu.salesOrder != null) {

                String customerId = OrderMenu.salesOrder.customerAccount.customerId;
                String firstName = OrderMenu.salesOrder.customerAccount.firstName;
                String lastName = OrderMenu.salesOrder.customerAccount.lastName;
                String primaryPhoneNo = OrderMenu.salesOrder.customerAccount.primaryPhoneNo;
                String emailAddress = OrderMenu.salesOrder.customerAccount.emailAddress;
                String address = OrderMenu.salesOrder.customerAccount.address;
                String address2 = OrderMenu.salesOrder.customerAccount.address2;
                String city = OrderMenu.salesOrder.customerAccount.city;
                String state = OrderMenu.salesOrder.customerAccount.state;
                String zip = OrderMenu.salesOrder.customerAccount.zip;

                while (true) {

                    System.out.println("");
                    System.out.println("---------------");
                    System.out.println("Customer Menu");
                    System.out.println("---------------");
                    System.out.println("");
                    System.out.println("1. Customer ID    : " + customerId);
                    System.out.println("2. First Name     : " + firstName);
                    System.out.println("3. Last Name      : " + lastName);
                    System.out.println("4. Phone No.      : " + primaryPhoneNo);
                    System.out.println("5. Email          : " + emailAddress);
                    System.out.println("6. Address        : " + address);
                    System.out.println("7. Address 2      : " + address2);
                    System.out.println("8. City           : " + city);
                    System.out.println("9. State          : " + state);
                    System.out.println("10. Zip Code      : " + zip);
                    System.out.println("");
                    System.out.println("Press 's' to save");
                    System.out.println("Press 'b' to go back");
                    System.out.println("");


                    boolean exit = false;
                    boolean change = false;
                    String input = scanner.nextLine();

                    switch (input) {
                        case ("1"):
                            System.out.println("Customer ID cannot be manually specified.");
                            break;
                        case ("2"):
                            firstName = scanner.nextLine();
                            break;
                        case ("3"):
                            lastName = scanner.nextLine();
                            break;
                        case ("4"):
                            primaryPhoneNo = scanner.nextLine();
                        case ("5"):
                            emailAddress = scanner.nextLine();
                            break;
                        case ("6"):
                            address = scanner.nextLine();
                            break;
                        case ("7"):
                            address2 = scanner.nextLine();
                        case ("8"):
                            city = scanner.nextLine();
                            break;
                        case ("9"):
                            state = scanner.nextLine();
                            break;
                        case ("10"):
                            zip = scanner.nextLine();
                            break;
                        case ("b"):
                            exit = true;
                            break;
                        case("s"):

                           OrderMenu.salesOrder.customerAccount.customerId =  customerId;
                           OrderMenu.salesOrder.customerAccount.firstName  =  firstName;
                           OrderMenu.salesOrder.customerAccount.lastName = lastName;
                           OrderMenu.salesOrder.customerAccount.primaryPhoneNo = primaryPhoneNo;
                           OrderMenu.salesOrder.customerAccount.emailAddress = emailAddress;
                           OrderMenu.salesOrder.customerAccount.address = address;
                           OrderMenu.salesOrder.customerAccount.address2 = address2;
                           OrderMenu.salesOrder.customerAccount.city = city;
                           OrderMenu.salesOrder.customerAccount.state = state;
                           OrderMenu.salesOrder.customerAccount.zip = zip;

                        default:
                    }

                    if (exit) { break; }
                }
            }

            else {
                while (true) {

                    System.out.println("");
                    System.out.println("---------------");
                    System.out.println("Customer Menu");
                    System.out.println("---------------");
                    System.out.println("");
                    System.out.println("1. Customer ID    : ");
                    System.out.println("2. First Name     : ");
                    System.out.println("3. Last Name      : ");
                    System.out.println("4. Phone No.      : ");
                    System.out.println("5. Email          : ");
                    System.out.println("6. Address        : ");
                    System.out.println("7. Address 2      : ");
                    System.out.println("8. City           : ");
                    System.out.println("9. State          : ");
                    System.out.println("10. Zip Code      : ");
                    System.out.println("");
                    System.out.println("Press 'b' to go back");
                    System.out.println("");

                    boolean exit = false;
                    boolean change = false;
                    String input = scanner.nextLine();

                    if (input.equals("b")) {
                        break;
                    }
                }

            }
        }





}



