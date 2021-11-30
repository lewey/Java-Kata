package com.opencast.tdd.fizzbuzz;

import java.util.*;

public class FizzBuzz {

    private static final String LUCK = "luck";
    private static final String NUMBER = "number";
    private static final String BUZZ = "buzz";
    private static final String FIZZ = "fizz";
    private static final String FIZZBUZZ = "fizzbuzz";


    public static String determineFizzBuzz(int range) {

        Map<String,Integer> stats = new HashMap<>();
        stats.put(LUCK, 0);
        stats.put(NUMBER, 0);
        stats.put(BUZZ, 0);
        stats.put(FIZZ, 0);
        stats.put(FIZZBUZZ, 0);

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=range; i++){

             if(String.valueOf(i).contains("3")){
                 updateStats(stats, LUCK);
                 updateFizBuzzResult(sb, LUCK);
                 continue;
             }

             if(i % 15 == 0){
                 updateStats(stats, FIZZBUZZ);
                 updateFizBuzzResult(sb, FIZZBUZZ);
             }else if(i % 3 == 0){
                 updateStats(stats,FIZZ);
                 updateFizBuzzResult(sb,FIZZ);
             }else if(i % 5 == 0){
                 updateStats(stats,BUZZ);
                 updateFizBuzzResult(sb,BUZZ);
             }else{
                 updateStats(stats,NUMBER);
                 updateFizBuzzResult(sb,String.valueOf(i));
             }
         }

         String statistics = createStats(stats);

         return sb.append("\n").append(statistics).toString();
    }

    private static void updateStats(Map<String,Integer> statsMap, String key){
        int statCounter = statsMap.get(key);
        statsMap.put(key,++statCounter);
    }

    private static void updateFizBuzzResult(StringBuilder sb, String key){
        sb.append(key).append(" ");
    }

    private static String createStats(Map<String,Integer> statsMap){
       StringBuilder statBuilder = new StringBuilder();

       List<String> statOrdering = Arrays.asList(FIZZ, BUZZ, FIZZBUZZ, LUCK, NUMBER);

       for(String key: statOrdering){
           if(statsMap.containsKey(key)){

               if(statsMap.get(key) > 0){
                   statBuilder.append(key).append(": " + statsMap.get(key)).append("\n");
               }
           }
       }

       return statBuilder.toString().trim();
    }

}
