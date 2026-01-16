package kyu6.foxesAndChickens;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FoxesAndChickens {


    public static String hungryFoxes(final String farm) {
        final String[] splitFarm = Arrays.stream(farm.split(""))
                .map(FoxesAndChickens::delimiterCheck)
                .collect(Collectors.collectingAndThen(
                        Collectors.joining(""), x -> x.split("\\|"))
                );

        final boolean foxOutsideCage = isFoxOutsideCages(splitFarm);

        return Arrays.stream(splitFarm)
                .map(section -> isFoxInCage.test(section) ? eatTheChickens.apply(section) : section)
                .map(section -> foxOutsideCage && !isCageSection.test(section) ?  eatTheChickens.apply(section) : section)
                .collect(Collectors.joining(""));

    }
    private static String delimiterCheck(String value){
        return switch (value) {
            case "[" -> "|[";
            case "]" -> "]|";
            default -> value;
        };
    }

    private static boolean isFoxOutsideCages(String[] farmSections){
      return Arrays.stream(farmSections).anyMatch(Predicate.not(isCageSection).and(containsFox));
    }

    private static final Predicate<String> isCageSection = farmSection -> farmSection.contains("[");

    private static final Predicate<String> containsFox = farmSection -> farmSection.contains("F");

    private static final Predicate<String> isFoxInCage = isCageSection.and(containsFox);

    private static final Function<String, String> eatTheChickens = section -> section.replaceAll("C", ".");
}
