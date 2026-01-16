package collections.factories;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Singletons {
    public static void main(String[] args){
        Set<Integer> set = Collections.singleton(1);
        System.out.println(set);
        //set.add(2);   this line will fail

        List<String> list = Collections.singletonList("One");
        System.out.println(list);

        Map<Integer,String> map = Collections.singletonMap(1,"one");
        System.out.println(map);
    }
}
