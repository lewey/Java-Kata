package collectors.toCollections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToCollectionsTest {

    @Test
    public void testToUnmodifiableMap(){
        final Map<String, Integer> result = ToCollections.toMapExample(Arrays.asList("one", "two", "three", "four", "five"));
        final Map<String, Integer> expectedMap = Map.of("one", 3, "two", 3, "three", 5, "four", 4, "five", 4);

        assertEquals(expectedMap, result);

        Assertions.assertThrows(UnsupportedOperationException.class, () -> result.put("foo", 3));
    }


}
