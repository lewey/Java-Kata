package advanced.typeInference;

import advanced.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.partitioningBy;

public class LambdaExamples
{
    public static void main(String[] args)
    {
        final Person donDraper = new Person("Don Draper", 89);
        final Person peggyOlson = new Person("Peggy Olson", 75);
        final Person bertCooper = new Person("Bert Cooper", 100);

        List<Person> people = new ArrayList<>();
        people.add(donDraper);
        people.add(peggyOlson);
        people.add(bertCooper);

        Map<Boolean, List<Person>> oldAndYoungPeople =
            people.stream()
                  .collect(Collectors.partitioningBy(person -> person.getAge() > 80));

        Map<Boolean, Long> oldAndYoungPeopleCount =
                people.stream()
                        .collect(
                            partitioningBy(person -> person.getAge() > 80, counting())
                        );

        System.out.println(oldAndYoungPeople);
        System.out.println(oldAndYoungPeopleCount);
    }
}
