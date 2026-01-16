package kyu6.curlyBraces.stack;

import java.util.*;

public class BraceChecker {

    private final Stack<String> braceEntries = new Stack<>();
    private final Set<String> leftBraces = Set.of("(", "[", "{");

    public boolean isValid(String braces){
        final List<String> listOfBraces = Arrays.stream(braces.split("")).toList();
        final boolean allValid = listOfBraces.stream().allMatch(this::isNextBraceValid);
        return listOfBraces.size() % 2 == 0 && allValid && braceEntries.empty();
    }

    private String findMatchingLeftBrace(String brace){
        return switch(brace) {
            case ")" -> "(";
            case "]" -> "[";
            case "}" -> "{";
            default -> "";
        };
    }

    private boolean isNextBraceValid(String brace){
        if(leftBraces.contains(brace)){
            braceEntries.push(brace);
            return true;
        }else{
            if(!braceEntries.empty()){
                return findMatchingLeftBrace(brace).equals(braceEntries.pop());
            }else{
                return false;
            }
        }
    }
}
