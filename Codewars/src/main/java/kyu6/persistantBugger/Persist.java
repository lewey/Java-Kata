package kyu6.persistantBugger;

import java.util.List;

class Persist {
    public static int persistence(long n) {
        return persistence(Math.toIntExact(n), 0);
    }

    private static int persistence(int number, int counter){
       if(isSingleDigit(number)){
           return counter;
       }else{
           return persistence(performCalculation(stringToDigits(number)), ++counter);
       }
    }

    private static List<Integer> stringToDigits(long number){
        return String.valueOf(number).chars()
                .mapToObj(c -> (char) c)
                .mapToInt(c -> Integer.parseInt(c.toString()))
                .boxed().toList();
    }

    private static int performCalculation(List<Integer> numbers){
        return numbers.stream().reduce(1, (num1, num2) -> num1 * num2);
    }

    private static boolean isSingleDigit(int result){
        return String.valueOf(result).length() == 1;
    }
}
