package filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

    public static void main(String args[]){

        List<String> numbers = Arrays.asList("one","two","three","four","five");

        Stream<String> streamIntermediary = numbers.stream();
        Stream<String> streamFinal = numbers.stream();

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        List<String> list = new ArrayList<>();

        /*
           Nothing will be printed from the following stream as each operation is
           intermediary. The evaluation is Lazy.
         */
        streamIntermediary
                .peek(System.out::println)
                .filter(p1.or(p2))
                .peek(list::add);

        System.out.println("size " + list.size());


        /*
            The only difference in the next stream is the forEach method which is final.
            Because of this, the previous intermediary declarations will be printed.
            ForEach is not lazy
         */
        streamFinal
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(list::add);

        System.out.println("size " + list.size());
    }
}
