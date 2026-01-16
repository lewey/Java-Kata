package sets.treeset;


public class ProductFixtures
{
    public static Product door = new Product("Wooden Door", 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    public static Supplier bobs = new Supplier("Bob's Household Supplies");
    public static Supplier kates = new Supplier("Kate's Home Goods");

    // static block used to populate products
    static
    {
        bobs.getProducts().add(door);
        bobs.getProducts().add(floorPanel);
        bobs.getProducts().add(window);

        kates.getProducts().add(floorPanel);
        kates.getProducts().add(new Product("Wooden Door", 35));
    }
}
