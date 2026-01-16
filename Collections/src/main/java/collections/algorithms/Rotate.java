package collections.algorithms;

import collections.Product;
import collections.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Rotate {

    public static void main(String[] args){

        List<Product> products = new ArrayList<>();
        products.add(ProductFixtures.door);
        products.add(ProductFixtures.floorPanel);
        products.add(ProductFixtures.window);

        System.out.println(products);
        System.out.println();

        // simply moves the last element and places it as the first element. All others are shuffled up.
        Collections.rotate(products,1);
        System.out.println(products);

    }
}
