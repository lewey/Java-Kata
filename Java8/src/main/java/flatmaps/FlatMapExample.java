package flatmaps;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args){

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(2,4,6);
        List<Integer> list3 = Arrays.asList(3,5,7);


        //create a list of lists
        List<List<Integer>> list = Arrays.asList(list1,list2,list3);
        System.out.println(list);

        Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();

        list.stream()
                .flatMap(flatMapper)
                .forEach(System.out::println);

        //------------------------

        /*
             Streams can hold different data types
             Stream<String[]>
             Stream<List<String>>

             Stream operations don't support the above. Thus flatmap converts to a
             supported format

             Stream<List<String>>   ->   flatmap  ->   Stream<String>

         */

        List<String> letters = Arrays.asList("a","b", "c");
        List<String> names = Arrays.asList("bob","pete");
        List<List<String>> stringList = Arrays.asList(letters,names);

        //obtain the Stream from the list of lists
        Stream<List<String>> stringStream = stringList.stream();

        //flatmap to just the strings of each list
        Stream<String> stream = stringStream.flatMap(s -> s.stream());

        //upon the strings filter so that only characters are kept
        Stream<String> onlySingleDigits = stream.filter(s -> s.length() == 1);

        onlySingleDigits.forEach(System.out::println);


        //the above can simply be put as
        stringList.stream()
                .flatMap(s -> s.stream())
                .filter(s -> s.length() == 1)
                .forEach(System.out::println);

    }
}
