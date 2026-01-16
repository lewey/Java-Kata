package com.kata.quarterOfYear;

import java.util.List;
import java.util.Map;

public class QuarterOfYear {

    public static int getQuarterForValue1(int month) {
        if (month <= 3) {
            return 1;
        } else if (month <= 6) {
            return 2;
        } else if (month <= 9){
            return 3;
        }else{
            return 4;
        }
    }

    public static int getQuarterForValue2(int month) {
        return (int) Math.ceil((float) month / 3);
    }

    public static int getQuarterForValue(int month) {
      final Map<Integer, List<Integer>> quarters = Map.of(1, List.of(1, 2, 3),
                                                          2, List.of(4, 5, 6),
                                                          3, List.of(7, 8, 9),
                                                          4, List.of(10, 11, 12));

      return quarters.entrySet().stream()
              .parallel()
              .filter(es -> es.getValue().contains(month))
              .map(Map.Entry::getKey)
              .findFirst()
              .orElseThrow(() -> new RuntimeException("Invalid input"));
    }

}
