import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean quitFlag = false;

        final String qId = "Enter product id: ";
        final String qPrice = "Enter product price: ";
        final String qQty= "Enter product quantity: ";
        final String MENU = "[1] Add new product\n" +
                "[2] Add product stock\n" +
                "[3] Reduce product stock\n" +
                "[4] Remove product from inventory\n" +
                "[5] Calculate product stock value\n" +
                "[6] Calculate inventory value\n" +
                "[0] Quit\n" +
                "\nOption: ";

        while (!quitFlag) {
            System.out.print(MENU);
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print(qId);
                    String id1 = sc.nextLine();
                    System.out.print(qPrice);
                    double price = sc.nextDouble();
                    System.out.print(qQty);
                    int qty1 = sc.nextInt();
                    sc.nextLine();

                    inventory.addProduct(id1, price, qty1);
                    break;
                case 2:
                    System.out.print(qId);
                    String id2 = sc.nextLine();
                    System.out.print(qQty);
                    int qty2 = sc.nextInt();

                    inventory.addProductQty(id2, qty2);
                    break;
                case 3:
                    System.out.print(qId);
                    String id3 = sc.nextLine();
                    System.out.print(qQty);
                    int qty3 = sc.nextInt();

                    inventory.removeProductQty(id3, qty3);
                    break;
                case 4:
                    System.out.print(qId);
                    String id4 = sc.nextLine();

                    inventory.removeProduct(id4);
                    break;
                case 5:
                    System.out.print(qId);
                    String id5 = sc.nextLine();

                    System.out.println(inventory.getProductTotalPrice(id5));
                    break;
                case 6:
                    System.out.println(inventory.getInventoryPrice());
                    break;
                case 0:
                    quitFlag = true;
                    break;
            }

        }

        sc.close();
    }
}
