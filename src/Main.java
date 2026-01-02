import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        int option = 0;

        while (option != 5){
            System.out.println("==== Inventory Management ====");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Show All Products");
            System.out.println("4. Look up a product");
            System.out.println("5. Exit");
            System.out.println("Choose option: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                System.out.println("Invalid input. Choose options 1 through 5.");
                scanner.nextLine();
                continue;
            }


            switch (option){
                case 1:
                    System.out.println("Choose name of product: ");
                    String productName = scanner.nextLine();
                    System.out.println("Choose price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.println("How many units: ");
                    int productQuantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Choose category: ");
                    String productCategory = scanner.nextLine();

                    manager.addProduct(productName,productPrice,productQuantity,productCategory);
                    System.out.println("Product added successfully");
                    break;
                case 2:
                    System.out.println("Please enter the id of the product would you like to delete?: ");
                    int productToDelete = scanner.nextInt();
                    manager.deleteProduct(productToDelete);

                    System.out.println("product has been deleted successfully");
                    break;
                case 3:
                    manager.showAllProducts();
                    break;
                case 4:
                    System.out.println("Enter id of product to look up: ");
                    int productLookUp = scanner.nextInt();
                    manager.searchProduct(productLookUp);
                    break;
                case 5:
                    System.out.println("Good bye!");
                    break;

                default:
                    System.out.println("Invalid input. try again.");
            }
        }

        scanner.close();


    }
}
