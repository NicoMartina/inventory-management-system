import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.AccessFlag;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Product> products  = new ArrayList<>();

    public void addProduct(String name, double price, int quantity, String category){
        Product product = new Product(name, price, quantity, category);
        products.add(product);
        System.out.println("Product added successfully.");
    }

    public void deleteProduct(int id){
        if (products.isEmpty()){
            System.out.println("There are no products.");
            return;
        }

        boolean found = false;
        for (int i = products.size() - 1; i >= 0; i--) {
            Product p = products.get(i);

            if (p.getId() == id){
                products.remove(i);
                System.out.println("Product with id " + id + " has been removed.");
                System.out.println("----------");
                found = true;
            }
        }

        if (!found){
            System.out.println("The product was not found.");
        }
    }

    public void showAllProducts(){
        for (Product p : products){
            System.out.println("ID: " + p.getId());
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Quantity: " + p.getQuantity());
            System.out.println("Category: " + p.getCategory());
            System.out.println("---------");
        }
    }

    public void searchProduct(int id){
        if (products.isEmpty()){
            System.out.println("Your inventory is empty.");
            return;
        }

        boolean found = false;
        for (Product p : products){
            if (p.getId() == id){
                System.out.println("ID: " + p.getId());
                System.out.println("Name: " + p.getName());
                System.out.println("Price: " + p.getPrice());
                System.out.println("Quantity: " + p.getQuantity());
                System.out.println("Category: " + p.getCategory());
                System.out.println("---------");
                found = true;
            }


        }

        if (!found){
            System.out.println("product was not found");
        }
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter("products.txt");
            for (Product p : products){
                writer.write(p.getId() + "," + p.getName() + "," + p.getPrice() + "," + p.getQuantity() + "," + p.getCategory());
            }
            writer.close();
            System.out.println("Products saved successfully");
        } catch (IOException e){
            throw new RuntimeException("Error saving products data: " + e.getMessage());
        }
    }

    public void loadFromFile(){
        try {
            File file = new File("products.txt");
            if (file.exists()){
                return;
            }
            Scanner scanner = new Scanner(file);
             while (scanner.hasNextLine()){
                 String line = scanner.nextLine();
                 String[] parts = line.split(",");
                 if (parts.length == 5){
                     String productId = parts[0];
                     String productName = parts[1];
                     String productPriceStr = parts[1];
                     String productQuantityStr = parts[1];
                     String productCategory = parts[1];

                     double productPrice = Double.parseDouble(productPriceStr);
                     int productQuantity = Integer.parseInt(productQuantityStr);

                     products.add(new Product(productName, productPrice, productQuantity, productCategory));
                 }
             }

             scanner.close();
            System.out.println("Products loaded successfully");
        } catch (FileNotFoundException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }


}
