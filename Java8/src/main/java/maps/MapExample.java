package maps;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args){

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> list2 = Arrays.asList(2,4,6);
        List<Integer> list3 = Arrays.asList(3,5,7);


        //create a list of lists
        List<List<Integer>> list = Arrays.asList(list1,list2,list3);
        System.out.println(list);

        // declare a function that takes a list of any type and returns an Integer
        Function<List<?>,Integer> size = List::size;

        //maps take Functions
        list.stream()
                .map(size) //each list will be passed to map which will return its size
                .forEach(System.out::println);


        //----------------------------

        List<String> alpha = Arrays.asList("a","b","c","d");
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); // A B C D

        //----------------------------

        List<Integer> numbers = Arrays.asList(1,2,3,4);
        List<Integer> doubled = numbers.stream().map(i -> i*=2).collect(Collectors.toList());
        System.out.println(doubled); // 2,4,6,8

    }
}
