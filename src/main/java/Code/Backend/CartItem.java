/**
 * Class Name: CartItem
 * Date: April 17, 2025
 * Programmer: Gabriel Jose Lopez Reyes
 *
 * Description:
 * data structure representing a single item in the cart, including its quantity and associated product.
 *
 * Key Methods:
 * - getTotalPrice(): Calculates the total price for this item.
 *
 * Data Structures:
 * - Product: Represents the product.
 */

package Code.Backend;

import Code.Backend.Product;

public class CartItem {
    private Product product;

    public CartItem(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalPrice() {
        return product.getPrice();
    }
}
