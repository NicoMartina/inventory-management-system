public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;
    private static int nextId = 1;
    private final int id;

    public Product(String name, double price, int quantity, String category) {
        if ( name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be less than 0");
        }
        if (category == null || category.trim().isEmpty()){
            throw new IllegalArgumentException("Category cannot be empty");
        }
        this.id = nextId++;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
