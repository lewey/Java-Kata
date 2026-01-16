package streams;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeStreamsTest {

    @Test
    public void testARangeStreamWith0Index(){
        final int beginIndexInclusive = 0;
        final int endIndexExclusive = 10;
        List<Integer> generatedList = TypeStreams.generateRangeList(beginIndexInclusive, endIndexExclusive);
        List<Integer> expectedList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertEquals(expectedList, generatedList);
    }
}
