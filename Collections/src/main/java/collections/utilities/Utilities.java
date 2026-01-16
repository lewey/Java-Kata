package collections.utilities;

import collections.Product;
import collections.ProductFixtures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utilities {

    public static void main(String[] args){

        Product door = ProductFixtures.door;
        Product floorPanel = ProductFixtures.floorPanel;
        Product window = ProductFixtures.window;

        List<Product> products = new ArrayList<>();

        //add elements in one go instead of one by one
        Collections.addAll(products,door,floorPanel,window);
        System.out.println(products);

        //max and min
        final Product productMin = Collections.min(products, Product.BY_NAME);
        System.out.println(productMin);

        final Product productMax = Collections.max(products, Product.BY_WEIGHT);
        System.out.println(productMax);
    }


}
