package generalcollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionExamples {

    public static void main(String[] args){

        Product door = new Product("Wooden Door", 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        final Iterator<Product> productIterator =  products.iterator();
        while(productIterator.hasNext()){
            Product product = productIterator.next();

            if(product.getWeight() > 20){
                System.out.println(product);
            }else{
                // can't do this in for loop
                productIterator.remove();
            }
        }

        // this will desugar to the above
        for(Product product: products){
            System.out.println(product);
        }

        // multiples can be removed from a collection using removeAll
        Collection<Product> otherProducts = new ArrayList<>();
        products.add(door);

        products.removeAll(otherProducts);

    }
}
