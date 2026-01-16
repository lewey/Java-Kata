package collections.factories;

import collections.Product;
import collections.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingBasket
{
    private final List<Product> items = new ArrayList<>();
    private int totalWeight = 0;

    public void add(Product product)
    {
        items.add(product);
        totalWeight += product.getWeight();
    }

    // getItems method returns an unmodifiableList so that it can't be updated. Instead the user must go through the add method which
    // calculates the weight correctly.
    public List<Product> getItems()
    {
        return Collections.unmodifiableList(items);
    }

    public String toString()
    {
        return "Shopping Basket of \n" + items + "\nwith weight: " + totalWeight;
    }

    public static void main(String[] args)
    {
        ShoppingBasket basket = new ShoppingBasket();
        basket.add(ProductFixtures.door);
        System.out.println(basket);

        basket.getItems().add(ProductFixtures.window);
        System.out.println(basket);
    }
}
