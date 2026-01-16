package classesAndInterfaces.after;

/*
  This sortedPair type parameter extends Comparable<T>
  This means anything passed in to Sorted<T> must implement Comparable
  This gives this class the knowledge that calling left.compareTo is a safe option
 */
public class SortedPair<T extends Comparable<T>>
{
    private final T first;
    private final T second;

    public SortedPair(final T left, final T right) {
        if (left.compareTo(right) < 0) {
            this.first = left;
            this.second = right;
        }
        else {
            first = right;
            second = left;
        }
    }

    public T getSecond()
    {
        return second;
    }

    public T getFirst()
    {
        return first;
    }

    @Override
    public String toString() {
        return "SortedPair{" +
            "first=" + first +
            ", second=" + second +
            '}';
    }
}
