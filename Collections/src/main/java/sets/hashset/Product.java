package sets.hashset;

import java.util.Comparator;
import java.util.Objects;

import static java.util.Comparator.comparing;

public class Product
{

    public static final Comparator<Product> BY_NAME = comparing(Product::getName);
    public static final Comparator<Product> BY_WEIGHT = comparing(Product::getWeight);

    private final String name;
    private final int weight;

    public Product(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "Product{" +
            "name='" + name + '\'' +
            ", weight=" + weight +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (weight != product.weight) return false;
        //return name != null ? name.equals(product.name) : product.name == null;

        //easier way to check for nulls and equality
        return Objects.equals(name,product.name);
    }

    @Override
    public int hashCode() {
        //int result = name != null ? name.hashCode() : 0;
        //result = 31 * result + weight;
        // easier way to perform the hash
        return Objects.hash(name,weight);
    }
}
