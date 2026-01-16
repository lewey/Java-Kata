package polymorphism;

import java.util.ArrayList;
import java.util.List;

public class PolymorphismExamples {

    public static void main(String[] args) {
        //List -> ArrayList is fine. Generics are fine due to both being Integer
        List<Integer> intsStandard = new ArrayList<Integer>();

        // fine as we are using the diamond to infer
        List<Integer> intsDiamond = new ArrayList<>();

        //Not allowed as both sides must match. This may be to do with erasure.
        //List<Object> obj = new ArrayList<Integer>();


    }
}
