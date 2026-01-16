package streams.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReduceExamples {

    /*
         Reduce: once single result from a stream of elements

         Identity – an element that is the initial value of the reduction operation and the default result if the stream is empty
         Accumulator – a function that takes two parameters: a partial result of the reduction operation and the next element of the stream
         Combiner – a function used to combine the partial result of the reduction operation when the reduction is parallelized or
         when there’s a mismatch between the types of the accumulator arguments and the types of the accumulator implementation


     */

    public static void main(String[] args){

        final List<String> words = Arrays.asList("at", "ball", "cat", "drop", "edge");
        final String sentence = "I am not reversed";

        // REVERSE STRING
        System.out.println("Sentence reversed = " + reverse(sentence));

        //SUM NUMBERS
        System.out.println("Numbers summed = " + sum());

        //TYPE CHANGE
        System.out.println("Type change. Words total length = " + typeChange(words));

        //PARALLEL


    }

    public static int sum(){
        final List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static String reverse(String input){
        return input.chars()                // InputStream
                .mapToObj(c -> (char) c)
                .reduce("",
                        (acc, currentCharacter) -> currentCharacter + acc, // Characters reversed as currentCharacter comes before accumulator
                        (char1, char2) -> char1 + char2);  // combiner used to convert to Strings
    }

    public static int typeChange(List<String> words){
        return words.stream()
                .reduce(0, // int is different from list type which is String
                        (acc, currentWord) -> acc + currentWord.length(), // sum word length
                        Integer::sum); // combiner is required for change of types
    }




}
