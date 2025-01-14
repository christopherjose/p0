import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class POS {

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        POS menu = new POS();
        menu.runMainMenu();
        menu.scanner.close();

    }

    public void runMainMenu() {

        boolean exit=false;

        while(true) {
            mainMenu();

            String menuInput = scanner.nextLine();

            switch(menuInput) {
                case("1"):
                    runOrderMenu();
                    break;
                case("2"):
                    runInventoryMenu();
                    break;
                case("3"):
                    runCustomerMenu();
                    break;
                case("4"):
                    runDeliveryMenu();
                    break;
                case("5"):
                    runSystemMenu();
                    break;
                case("6"):
                    exit=true;
                    break;
                default:
            }
            if (exit) {
                break;
            }
        }
    }


    public void runOrderMenu() {

        OrderMenu menu = new OrderMenu();
        menu.runOrderMenu();

    }

    public void runInventoryMenu() {

        while(true) {

            invMenu();
            String nameInput = scanner.nextLine();
            if(nameInput.equals("b")){break;}

            else {
                invSubMenu();
                String sizeInput = scanner.nextLine();
                if(sizeInput.equals("b")){break;}
                invQueryResults(nameInput, sizeInput);
            }
        }
    }

    public void runCustomerMenu() {

        while(true) {

            custMenu();
            String nameInput = scanner.nextLine();
            if(nameInput.equals("b")){break;}

            else {
                custSubMenu1();
                String phoneInput = scanner.nextLine();
                if(phoneInput.equals("b")){break;}

                else {
                    custSubMenu2();
                    String addressInput = scanner.nextLine();
                    if(addressInput.equals("b")){break;}
                    custQueryResults(nameInput, phoneInput, addressInput);
                }
            }
        }
    }

    public void runDeliveryMenu() {

        while(true) {
            delivMenu();
            String input = scanner.nextLine();
            if(input.equals("b")){break;}
        }

    }



    public void mainMenu() {
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Main Menu");
        System.out.println("---------------");
        System.out.println("");
        System.out.println("1. Order");
        System.out.println("2. Inventory");
        System.out.println("3. Customer");
        System.out.println("4. Delivery");
        System.out.println("5. System");
        System.out.println("6. Exit");
        System.out.println("");
    }

    public void invMenu() {
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Inventory Menu");
        System.out.println("---------------");
        System.out.println("");
        System.out.println("Specify Product name ('b' to exit)");
        System.out.println("");
    }

    public void invSubMenu() {
        System.out.println("");
        System.out.println("Specify Product size ('b' to exit)");
        System.out.println("Twin, Twin XL, Full, Queen, King, CalKing");
        System.out.println("");
    }

    public void invQueryResults(String nameInput, String sizeInput) {
        System.out.println("");
        System.out.println("Product: "+nameInput);
        System.out.println("Size: "+sizeInput);
        System.out.println("");
        System.out.println("[Query Sql Database and print results:]");
        System.out.println("Quantity: 2");
        System.out.println("ATP Date: 10/2/2021");
    }

    public void custMenu() {
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Customer Menu");
        System.out.println("---------------");
        System.out.println("");
        System.out.println("Specify Customer Name (‘b’ to exit)");
        System.out.println("- Press Enter to leave blank.");
        System.out.println("");
    }

    public void custSubMenu1() {
        System.out.println("");
        System.out.println("Specify Phone Number (‘b’ to exit)");
        System.out.println("- Press Enter to leave blank");
        System.out.println("");

    }

    public void custSubMenu2() {
        System.out.println("");
        System.out.println("Specify Address (‘b’ to exit)");
        System.out.println("- Press Enter to leave blank");
        System.out.println("");
    }

    public void custQueryResults(String nameInput, String phoneInput, String addressInput) {
        System.out.println("");
        System.out.println("Full Name   : "+nameInput);
        System.out.println("Phone Number: "+phoneInput);
        System.out.println("Address     : "+addressInput);
        System.out.println("");
        System.out.println("[Query Sql Database and print results:]");
        System.out.println("Customer Num: C183023021");
        System.out.println("Full Name   : Bobby Borowitz");
        System.out.println("Phone Number: 313-737-2095");
        System.out.println("Address     : 341 Chestnut St, San Francisco, 94123 ");
        System.out.println("Email       : magicsecretsauce029@gmail.com");
        System.out.println("Order Hist  : S103890831, S13803481");
    }


    public void delivMenu() {
        System.out.println("");
        System.out.println("---------------");
        System.out.println("Delivery Menu");
        System.out.println("---------------");
        System.out.println("");
        System.out.println("Date            Slots Available");

        LocalDate today = LocalDate.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("MM-dd-yy");

        for(int j=0; j<30; j++ ) {
            System.out.println(today.plusDays(j));
        }
        System.out.println("");
        System.out.println("- Type 'b' to exit");

    }

    public void sysMenu() {

    }


    public void runSystemMenu() {

    }

}





