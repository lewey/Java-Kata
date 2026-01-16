package erasure.compatibility.implicationsOfErasure;

public class InstanceOf<T>
{
    public boolean equals(Object o)
    {
        // Banned as T does not exist at runtime
        if (o instanceof InstanceOf/*<T>*/)
        {
            return true;
        }

        return false;
    }
}
