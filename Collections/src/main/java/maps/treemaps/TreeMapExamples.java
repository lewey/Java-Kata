package maps.treemaps;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapExamples {

    /*
        TreeMap is a map implementation that keeps its entries sorted according to the natural ordering of its keys or
        better still using a comparator if provided by the user at construction time.
     */

    public static void main(String[] args){

        final TreeMap<Integer, String> map = (TreeMap<Integer, String>) Map.of(
                3, "val1",
                2, "val",
                1, "val",
                5, "val",
                4, "val"
        );

    }

}
