package filters;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilterExample {

    public static void main(String args[]){

        Predicate<String> p1 = s -> s.length() > 3;
        Predicate<String> p2 = Predicate.isEqual("two");
        Predicate<String> p3 = Predicate.isEqual("three");

        Stream<String> stream = Stream.of("one", "two", "three", "four", "five", "six");
        stream.filter(p1.and(p2.or(p3))).forEach(System.out::println);

        boolean isTwo = p2.test("two");
        System.out.println(isTwo);
    }


}
