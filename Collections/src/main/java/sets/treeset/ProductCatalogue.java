package sets.treeset;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProductCatalogue implements Iterable<Product> {

    private final SortedSet<Product> products = new TreeSet<>(Product.BY_WEIGHT);

    public void isSuppliedBy(Supplier supplier){
        products.addAll(supplier.getProducts());
    }

    public Iterator<Product> iterator(){
        return products.iterator();
    }

    public Set<Product> lightVanProducts(){

        // find the heaviest lightvan product to obtain the split point.
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();

        // return a subset of the products upto the split point
        return products.headSet(heaviestLightVanProduct);
    }

    public Set<Product> heavyVanProducts(){
        // find the heaviest lightvan product to obtain the split point.
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();

        //return the products after the split point
        return products.tailSet(heaviestLightVanProduct);
    }

    private Product findHeaviestLightVanProduct() {

        // get the first product that is over the weight category point else return the last
        for(Product product: products){
            if(product.getWeight() > 20){
                return product;
            }
        }

        return products.last();

    }
}
