package predicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class TestStreams {

    public static void main(String args[]){

        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");

        List<Employee> list = new ArrayList<>();
        Collections.addAll(list,e1,e2);

        /*
            The call to filter method is lazy. No data is processed.
            All methods that return a Stream are lazy
         */

        Stream<Employee> stream = list.stream();
        Stream<Employee> filtered = stream.filter(employee -> employee.getAge() > 26);
        System.out.println(filtered.count()); // result is 0 as streams don't hold data

    }
}
