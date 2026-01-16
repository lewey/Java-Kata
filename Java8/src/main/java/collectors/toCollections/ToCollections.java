package collectors.toCollections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toUnmodifiableMap;

public class ToCollections {

    public static Map<String, Integer> toMapExample(List<String> inputList){
        final List<String> numbers = Collections.unmodifiableList(inputList);
        return numbers.stream().collect(toUnmodifiableMap(Function.identity(), String::length));
    }


}
