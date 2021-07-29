import java.util.*;


public class LoadMenu {

    CustomerAccount selectedCustomer;
    Map<String,SalesOrder> selectedSalesOrder;
    String selectedSalesOrderId;
    SalesOrder selectedSalesOrderObj;
    Map<String,SalesOrder> placeholder;
    Scanner scanner = new Scanner(System.in);

    public Map<String, SalesOrder> runLoadMenu() {

        while (true) {

            loadMenu(selectedSalesOrder);
            boolean exit = false;
            String input = scanner.nextLine();

            switch (input) {
                case ("1"):
                    placeholder = runCustSearchMenu();
                    break;
                case ("2"):
                    placeholder = runSalesOrderMenu();
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
        return selectedSalesOrder;
    }

    public Map<String,SalesOrder> runSalesOrderMenu() {

        while (true) {

            boolean exit = false;
            boolean search = false;

            salesOrderMenu();
            String OrderIDInput = scanner.nextLine();
            if (OrderIDInput.equals("b")) {exit = true;}
            else {placeholder =queryOrderData(OrderIDInput); }
            if (exit) {break;}
        }

        return selectedSalesOrder;
    }


    public void loadMenu(Map<String, SalesOrder> selectedSalesOrder) {

        System.out.println("");
        System.out.println("---------------");
        System.out.println("Load Menu");
        System.out.println("---------------");
        System.out.println("");

        if (OrderMenu.salesOrder == null) { System.out.println("Selected Order: ");}
        else {
            System.out.println("Selected Order: ");
            System.out.println(OrderMenu.salesOrderId); }//selectedSalesOrder.keySet().toString().replaceAll("\\p{P}","")); }//can replace with selectedSalesOrderId
        System.out.println("");
        System.out.println("1. Search by Customer    : ");
        System.out.println("2. Search by Sales Order : ");
        System.out.println("Press 'b' to go back");
        System.out.println("");

    }

    public void salesOrderMenu() {

            System.out.println("");
            System.out.println("---------------");
            System.out.println("Order Menu");
            System.out.println("---------------");
            System.out.println("");
            System.out.println("Enter Sales Order ID below ('b' for back):");
            System.out.println("");
    }
    public Map<String, SalesOrder> runCustSearchMenu() {

        String customerId = "";
        String firstName = "";
        String lastName = "";
        String primaryPhoneNo = "";
        String emailAddress = "";
        String address = "";
        String address2 = "";
        String city = "";
        String state = "";
        String zip = "";

        while (true) {

            System.out.println("");
            System.out.println("---------------");
            System.out.println("Search Menu");
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
            System.out.println("Press 's' to search");
            System.out.println("Press 'b' to go back");
            System.out.println("");

            boolean exit = false;
            boolean search = false;
            String input = scanner.nextLine();

            switch (input) {
                case ("1"):
                    customerId = scanner.nextLine();
                    break;
                case ("2"):
                    firstName = scanner.nextLine();
                    break;
                case ("3"):
                    lastName = scanner.nextLine();
                    break;
                case ("4"):
                    primaryPhoneNo = scanner.nextLine();
                    break;
                case ("5"):
                    emailAddress = scanner.nextLine();
                    break;
                case ("6"):
                    address = scanner.nextLine();
                    break;
                case ("7"):
                    address2 = scanner.nextLine();
                    break;
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

                case ("s"):

                    placeholder = queryCustomerData(customerId, firstName, lastName, primaryPhoneNo,
                      emailAddress, address, address2, city, state, zip);
                    break;
                default:
            }

            if (exit) {
                break;
            }
        }
        return placeholder;
    }

    public Map<String, SalesOrder> queryCustomerData(String customerId, String firstName, String lastName, String primaryPhoneNo, String emailAddress,
                                       String address, String address2, String city, String state, String zip) {

        Scanner scanner = new Scanner(System.in);
        Map<String, CustomerAccount> selectedCustomer;
        Map<String, SalesOrder> selectedOrder;

        while (true) {

            boolean exit = false;

            searchResultMenu();
            CustomerLookupQuery findCustomer = new CustomerLookupQuery();
            Map<String, CustomerAccount> searchResult = findCustomer.customerQuery(
                    customerId, firstName, lastName, primaryPhoneNo, emailAddress, address, address2, city, state, zip);

            selectedOrder=selectOrderFromCustomer(searchResult);
            selectedCustomer=new HashMap<String, CustomerAccount>();
/*
            for(boolean key: selection.keySet() ){
                exit = key;
                try {
                    selectedCustomer.put( selection.get(key).customerId,selection.get(key));
                }
                catch (Exception e) {

                }

        }
*/          exit=true;
            if (exit) { break; }
      }
        return selectedOrder;
    }

    public void searchResultMenu (){
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Search Results");
        System.out.println("---------------");
        System.out.println("");
    }

    public Map<String,SalesOrder> selectOrderFromCustomer(Map<String, CustomerAccount> searchResult){

        Map<Boolean, CustomerAccount> selectCustomerAndExit = new HashMap<Boolean, CustomerAccount>();
        boolean exit = false;
        CustomerAccount selectedCustomer=null;
        Map<String,SalesOrder> selectedOrder=null;
        while (true) {

            System.out.println("");
            System.out.println("Select Customer ID ('b' to exit):");
            String selectedCustomerId = scanner.nextLine();

            if (selectedCustomerId.equals("b")) {
                exit = true;
                break;}
            if (searchResult.containsKey(selectedCustomerId)) {
                selectedCustomer = searchResult.get(selectedCustomerId);
                selectedOrder = queryOrderData(selectedCustomerId);
                exit = true;
                break;}
            else {
                System.out.println("Select Again.  Customer ID is not in search result."); }
        }


       // selectCustomerAndExit.put(exit,selectedCustomer);
       // return selectCustomerAndExit;
        return selectedOrder;
        }



//ORDER SELECTION MENU-------------------------------------------------------------------------------------------------


    public Map<String, SalesOrder> queryOrderData(String Id) {

        Scanner scanner = new Scanner(System.in);
        Map<String, SalesOrder> selectedOrder;

        while (true) {

            boolean exit = false;

            searchResultMenu();
            orderLookupQuery findOrder = new orderLookupQuery();
            productLookupQuery findProduct = new productLookupQuery();
            CustomerLookupQuery findCustomer = new CustomerLookupQuery();
            HashMap<String,OrderProduct> orderProducts = new HashMap<String,OrderProduct>();
            Map<String, SalesOrder> searchResult = findOrder.orderQuery(Id);
            Map<Boolean, SalesOrder> selection=selectOrder(searchResult);
            selectedOrder=new HashMap<String, SalesOrder>();

            for(boolean key: selection.keySet() ){
                exit = key;
                try {

                    selectedOrder.put( selection.get(key).orderId,selection.get(key));
                    selectedSalesOrder=selectedOrder; //(OrderId,Sales Order obj)
                    selectedSalesOrderId=selection.get(key).orderId;
                    selectedSalesOrderObj=selection.get(key);
                    selectedCustomer=findCustomer.createCustomerQuery(selectedSalesOrderObj.customerId);

                    OrderMenu.salesOrderMap = selectedSalesOrder;
                    OrderMenu.salesOrderId = selectedSalesOrderId;
                    OrderMenu.salesOrder =selectedSalesOrderObj;
                    OrderMenu.salesOrder.customerAccount = selectedCustomer;

                    orderProducts = findProduct.productQuery(selectedSalesOrderId);

                    for (String k: orderProducts.keySet()){
                        OrderMenu.salesOrder.orderProductList.put(k,orderProducts.get(k)); }

                    for (String k: orderProducts.keySet()){
                        OrderMenu.products.put(k,orderProducts.get(k)); }
                }


                catch (Exception e) {}

            }
            if (exit) { break; }
        }
        return selectedOrder;
    }


    public Map<Boolean, SalesOrder> selectOrder(Map<String, SalesOrder> searchResult){

        Map<Boolean, SalesOrder> selectOrderAndExit = new HashMap<Boolean, SalesOrder>();
        boolean exit = false;
        SalesOrder selectedOrder=null;

        while (true) {

            System.out.println("");
            System.out.println("Confirm Order Selection ('b' to exit)");
            System.out.println("");
            String selectedOrderId = scanner.nextLine();

            if (selectedOrderId.equals("b")) {
                exit = true;
                break;}
            if (searchResult.containsKey(selectedOrderId)) {
                selectedOrder = searchResult.get(selectedOrderId);
                exit = true;
                break;}
            else {
                System.out.println("Select Again.  Order ID is not in search result."); }
        }
        selectOrderAndExit.put(exit,selectedOrder);

            return selectOrderAndExit;
    }

    }















