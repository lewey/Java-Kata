package collections.algorithms;

import collections.Product;
import collections.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static void main(String[] args){

        List<Product> products = new ArrayList<>();
        products.add(ProductFixtures.door);
        products.add(ProductFixtures.floorPanel);
        products.add(ProductFixtures.window);

        System.out.println(products);
        System.out.println();

        // simply sort using a comparator
        products.sort(Product.BY_NAME);
        System.out.println(products);

        products.sort(Product.BY_WEIGHT);
        System.out.println(products);

    }
}
