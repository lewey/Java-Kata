package sets.hashset;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import static sets.hashset.Product.BY_NAME;

public class ProductCatalogueTreeSet implements Iterable<Product> {

    //provide the constructor with a comparator
    private final Set<Product> products = new TreeSet<>(BY_NAME);

    public void isSuppliedBy(Supplier supplier){
        products.addAll(supplier.getProducts());
    }

    public Iterator<Product> iterator(){
        return products.iterator();
    }

}
