package classesAndInterfaces.before;

import java.util.Comparator;

/*
   This class simply reverses the comparator that is passed in
   T is used so that any comparator can be used
 */
public class ReverseComparator<T> implements Comparator<T>
{
    private final Comparator<T> delegateComparator;

    public ReverseComparator(final Comparator<T> delegateComparator) {
        this.delegateComparator = delegateComparator;
    }

    public int compare(final T left, final T right) {
        // -1 simply flips the answer of the original comparator
        return -1 * delegateComparator.compare(left, right);
    }
}
