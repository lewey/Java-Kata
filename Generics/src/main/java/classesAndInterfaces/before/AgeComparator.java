package classesAndInterfaces.before;

import java.util.Comparator;

// specifiying an interface on a Comparator
public class AgeComparator implements Comparator<Person>
{
    public int compare(final Person left, final Person right) {
        return Integer.compare(left.getAge(), right.getAge());
    }
}
