import java.util.Scanner;

public class Main {
    static ProductService productService = new ProductService("products.txt");
    static CartService cartService = new CartService();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
           
            System.out.println("1. View All Products");
            System.out.println("2. Search Product");
            System.out.println("3. Add to Cart");
            System.out.println("4. Remove from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Clear Cart");
            System.out.println("0. Exit");
            

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    productService.getAllProducts().forEach(System.out::println);
                    break;
                case "2":
                    System.out.print("Enter keyword: ");
                    String keyword = input.nextLine();
                    var results = productService.searchProducts(keyword);
                    if (results.isEmpty()) System.out.println("Product not found.");
                    else results.forEach(System.out::println);
                    break;
                case "3":
                    System.out.print("Enter product ID or name to add: ");
                    String addInput = input.nextLine();
                    Product toAdd = productService.findProductByIdOrName(addInput);
                    if (toAdd != null) {
                        cartService.addToCart(toAdd);
                        System.out.println("Added to cart.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;
                case "4":
                    System.out.print("Enter product ID or name to remove: ");
                    String removeInput = input.nextLine();
                    cartService.removeFromCart(removeInput);
                    System.out.println("Removed from cart if it existed.");
                    break;
                case "5":
                    System.out.println("Cart:");
                    cartService.getCartItems().forEach(System.out::println);
                    System.out.println("Total: $" + cartService.getTotal());
                    break;
                case "6":
                    cartService.clearCart();
                    System.out.println("Cart cleared.");
                    break;
                case "0":
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
