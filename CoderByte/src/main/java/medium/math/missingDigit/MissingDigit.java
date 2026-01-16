package medium.math.missingDigit;

import java.util.function.BiFunction;
import java.util.stream.IntStream;


public class MissingDigit {

    final static BiFunction<Integer, Integer, Integer> addition = Integer::sum;
    final static BiFunction<Integer, Integer, Integer> subtraction = (x, y) -> x - y;
    final static BiFunction<Integer, Integer, Integer> multiplication = (x, y) -> x * y;
    final static BiFunction<Integer, Integer, Integer> division = (x, y) -> x / y;

    public static String missingDigit(String str){

        final String[] formulaParts = str.split( " ");
        final String leftOperand = formulaParts[0];
        final String operator = formulaParts[1];
        final String rightOperand = formulaParts[2];
        final String result = formulaParts[4];

        final int indexContainingX = IntStream.range(0, formulaParts.length)
                .filter(x -> formulaParts[x].contains("x"))
                .boxed()
                .findFirst()
                .orElse(0);

        final String calculationResult = String.valueOf(performCalculation(indexContainingX, operator, leftOperand, rightOperand, result));
        return isXEmbedded(formulaParts[indexContainingX]) ? findValueX(calculationResult, formulaParts[indexContainingX]) : calculationResult;
    }

    private static int performCalculation(int xIndex, String operator, String leftOperand, String rightOperand, String result){
        return switch (xIndex) {
            case 0 -> applyFunction(chooseFormula(complementaryOperator(operator)), result, rightOperand);
            case 2 -> {
                if(operator.equals("-") || operator.equals("/")){
                    yield applyFunction(chooseFormula(operator), leftOperand, result);
                }else{
                    yield applyFunction(chooseFormula(complementaryOperator(operator)), result, leftOperand);
                }
            }
            case 4 -> applyFunction(chooseFormula(operator), leftOperand, rightOperand);
            default -> throw new IllegalStateException("Unexpected value: " + xIndex);
        };
    }

    private static int applyFunction(BiFunction<Integer, Integer, Integer> function, String leftOperand, String rightOperand){
        final int leftNumeric = Integer.parseInt(leftOperand);
        final int rightNumeric = Integer.parseInt(rightOperand);

        return function.apply(leftNumeric, rightNumeric);
    }

    private static BiFunction<Integer, Integer, Integer> chooseFormula(String operator) {
        return switch (operator) {
            case "+" -> addition;
            case "-" -> subtraction;
            case "*" -> multiplication;
            case "/" -> division;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private static String complementaryOperator(String operator){
        return switch (operator) {
            case "+" -> "-";
            case "-" -> "+";
            case "*" -> "/";
            case "/" -> "*";
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private static String findValueX(String value, String valueContainingX){
        final int indexOfX = valueContainingX.indexOf("x");
        return String.valueOf(value.charAt(indexOfX));
    }

    private static boolean isXEmbedded(String xValue){return xValue.length() > 1;}
}
