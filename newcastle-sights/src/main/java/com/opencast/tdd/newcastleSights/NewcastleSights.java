package com.opencast.tdd.newcastleSights;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewcastleSights {

    private static final List<String> KNOWN_SIGHTS = Collections.unmodifiableList(
            Arrays.asList("St James park", "Big Market", "Tyne Bridge", "Monument", "Millennium Bridge", "The Sage",
                    "Theatre Royal","Greggs Sausage Roll"));

    private static final String NO_NEWCASTLE_RESULTS = "No fog to be found here!";

    // Original example seen uses a String builder. This can be improved upon
    public static String lookUpSights(List<String> sights){
        final StringBuilder result = new StringBuilder("Fog on the Tyne");
        final int numberOfSights = Math.toIntExact(sights.stream().filter(KNOWN_SIGHTS::contains).distinct().count());
        return numberOfSights > 0 ? result.append(String.join("", Collections.nCopies(numberOfSights,"!"))).toString() : NO_NEWCASTLE_RESULTS;
    }

    // remove the need for the StringBuilder
    public static String lookUpSights1(List<String> sights){
        final int numberOfSights = Math.toIntExact(sights.stream().filter(KNOWN_SIGHTS::contains).distinct().count());
        return numberOfSights > 0 ? IntStream.rangeClosed(1, numberOfSights).mapToObj(entry -> "!").collect(Collectors.joining("", "Fog on the Tyne", "")) : NO_NEWCASTLE_RESULTS;
    }

    // Second example eliminates the String builder but the prefix is somewhat confusing
    public static String lookUpSights2(List<String> sights){

        final String prefix = "Fog on the Tyne";
        final String result = sights.stream()
                .filter(KNOWN_SIGHTS::contains)
                .distinct()
                .map(sight -> "!")
                .collect(Collectors.joining("",prefix, ""));

        return result.equals(prefix) ? NO_NEWCASTLE_RESULTS : result;
    }

    // slightly better update then on
    public static String lookUpSights3(List<String> sights){
        final String prefix = "Fog on the Tyne";
        return sights.stream()
                .filter(KNOWN_SIGHTS::contains)
                .distinct()
                .map(sight -> "!")
                .collect(Collectors.collectingAndThen(
                        Collectors.joining("",prefix, ""), result -> result.equals(prefix) ? NO_NEWCASTLE_RESULTS : result)
                );
    }

    public static String lookUpSightsNonFunctional(List<String> sights){

        int numberOfSights = 0;
        StringBuilder result = new StringBuilder("Fog on the Tyne");
        Set<String> uniqueList = new HashSet<>(sights);

        for(String sight : uniqueList){
            if(KNOWN_SIGHTS.contains(sight)){
                numberOfSights++;
                result.append("!");
            }
        }

        return numberOfSights > 0 ? result.toString() : NO_NEWCASTLE_RESULTS;
    }




}
