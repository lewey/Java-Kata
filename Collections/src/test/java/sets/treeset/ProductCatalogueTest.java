package sets.treeset;

import org.junit.Test;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class ProductCatalogueTest {

    @Test
    public void shouldOnlyHoldUniqueProducts() throws Exception{
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.isSuppliedBy(ProductFixtures.bobs);
        catalogue.isSuppliedBy(ProductFixtures.kates);

        assertThat(catalogue,containsInAnyOrder(ProductFixtures.door, ProductFixtures.floorPanel, ProductFixtures.window));
    }

    @Test
    public void shouldFindHeavyVanProducts() throws Exception{
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.isSuppliedBy(ProductFixtures.bobs);
        catalogue.isSuppliedBy(ProductFixtures.kates);

        assertThat(catalogue.heavyVanProducts(), containsInAnyOrder(ProductFixtures.door, ProductFixtures.floorPanel));

    }

    @Test
    public void shouldFindLightVanProducts() throws Exception{
        ProductCatalogue catalogue = new ProductCatalogue();

        catalogue.isSuppliedBy(ProductFixtures.bobs);
        catalogue.isSuppliedBy(ProductFixtures.kates);

        assertThat(catalogue.lightVanProducts(), containsInAnyOrder(ProductFixtures.window));
    }


}
