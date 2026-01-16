package orderBy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderBy {
    public static List<Person> sortAlternative(List<Person> list, String[] criteria) {

        // set up the initial comparator by comparing a person by the first property
        final Comparator<Person> comparator = Comparator.comparing(person -> person.getProperty(criteria[0]));

        // to create a single comparator iterate over the remaining properties disregarding the above
        final Comparator<Person> comp2 = IntStream.range(1, criteria.length)
                .mapToObj(index -> Comparator.comparing((Person person) -> person.getProperty(criteria[index])))
                // with a stream of comparators we need to combine them into 1. Reduce does this.
                // the identity is the initial comparator, we then add the rest using comparing
                //.reduce(comparator, (comparator1, comparator2) -> comparator1.thenComparing(comparator2));
                .reduce(comparator, Comparator::thenComparing);

        // Now we have a single comparator we can sort the list of people
        return list.stream()
                .sorted(comp2)
                .collect(Collectors.toList());
    }

    /*
        Below is a more compact version of above.
        1. All criteria are placed into a single comparator.
        2. This is reduced into a single one. As there is no identity then the return type is an Optional
        3. check if present and then sort the list using it.
        4. if no criteria was present then the list simply would not be sorted.

     */
    public static List<Person> sort(List<Person> list, String[] criteria) {
        final List<Person> modifiableList = new ArrayList<>(list);
        Arrays.stream(criteria)
            .map(currentCriteria -> Comparator.comparing((Person p) -> p.getProperty(currentCriteria)))
            .reduce(Comparator::thenComparing)
            .ifPresent(modifiableList::sort);

        return modifiableList;
    }
}