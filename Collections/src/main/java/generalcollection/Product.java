package generalcollection;

import java.util.Comparator;

public class Product
{
    private final String name;
    private final int weight;

    public Product(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    // create an anonymous instance and assign it to a static
    public static final Comparator<Product> BY_WEIGHT = new Comparator<Product>(){
        public int compare(final Product p1, final Product p2)
        {
            return Integer.compare(p1.getWeight(), p2.getWeight());
        }
    };

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
}
