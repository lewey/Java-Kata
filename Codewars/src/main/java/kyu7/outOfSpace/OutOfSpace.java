package kyu7.outOfSpace;

import java.util.stream.IntStream;

public class OutOfSpace {

    public static String[] spacey(String[] array) {
        return IntStream.range(0, array.length).mapToObj(range -> IntStream.rangeClosed(0, range)
                .mapToObj(x -> array[x])
                .reduce("", String::concat)).toArray(String[]::new);
    }


    public static String[] spaceyOld(String[] array) {

        final String[] spaceyArray = new String[array.length];

        for(int i=0; i< array.length; i++){
            StringBuilder result = new StringBuilder();
            for(int j=0; j<= i; j++){
                  result.append(array[j]);
            }
            spaceyArray[i] = result.toString();
        }

        return spaceyArray;
    }


    /*
       Mutability with this but basically start at index 1
       then add the previous index.
    */
    public static String[] spaceyShort(String[] array) {
        for (int i=1;i<array.length;i++)
            array[i]=array[i-1]+array[i];
        return array;
    }


}
