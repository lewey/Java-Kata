package erasure.compatibility.rawTypes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LegacyCode {

    public static void main(String[] args) {
        // This is fine
        List<Object> values = new ArrayList();
        values.add("abc");
        values.add(1);
        values.add(new Object());

        //this will print fine
        for (Object currentObject: values) {
            System.out.println(currentObject);
        }

        List rawtype = values;
        List<String> strings = rawtype;

        //A class cast exception will occur at runtime
        for(String element : strings) {
            System.out.println(element);
        }

        Iterator iterator = values.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            System.out.println(element);
        }
    }
}
