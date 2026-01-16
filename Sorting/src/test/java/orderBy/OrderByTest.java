package orderBy;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/*
    Order By - implement a "dynamic" sorting function (like database group by) where an object can be sorted by one or many fields (referenced by field name).

    Exact problem statement:
    Implement database "order by" functionality.
    Given we have the below class already implemented:

 */

public class OrderByTest {


    private final String testMajor = "testMajor";
    private final String testAddress = "testAddress";

    private final String id = "id";
    private final String major = "major";
    private final String address = "address";

    @Test
    public void testSortCanSortWithOneCriteria(){
        final List<Person> unorderedList = List.of(new Person("2", testMajor, testAddress),
                                                   new Person("1", testMajor, testAddress),
                                                   new Person("3", testMajor, testAddress));

        final List<Person> orderedPersonList = OrderBy.sort(unorderedList, new String[]{id});

        assertEquals("1", orderedPersonList.get(0).getProperty(id));
        assertEquals("2", orderedPersonList.get(1).getProperty(id));
        assertEquals("3", orderedPersonList.get(2).getProperty(id));
    }

    @Test
    public void testSortCanSortWithTwoCriteria(){
        final List<Person> unorderedList = List.of(new Person("1", "b", testAddress),
                                                   new Person("1", "a", testAddress),
                                                   new Person("2", "c", testAddress));


        final List<Person> orderedPersonList = OrderBy.sort(unorderedList, new String[]{id, major});

        assertEquals("a", orderedPersonList.get(0).getProperty("major"));
        assertEquals("b", orderedPersonList.get(1).getProperty("major"));
        assertEquals("c", orderedPersonList.get(2).getProperty("major"));
    }

    @Test
    public void testSortCanSortWithThreeCriteria(){
        final List<Person> unorderedList = List.of(new Person("1", "a", "2 test street"),
                                                   new Person("1", "a", "1 test street"),
                                                   new Person("2", "b", "3 test street"));

        final List<Person> orderedPersonList = OrderBy.sort(unorderedList, new String[]{id, major, address});

        assertEquals("1 test street", orderedPersonList.get(0).getProperty(address));
        assertEquals("2 test street", orderedPersonList.get(1).getProperty(address));
        assertEquals("3 test street", orderedPersonList.get(2).getProperty(address));
    }

}
