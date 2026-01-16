package erasure.compatibility.implicationsOfErasure;

// can't extend exception with a generic type
public class UncompilableException/*<T> */ extends Exception
{
    public static void main(String[] args)
    {
        try
        {
            throw new UncompilableException();
        }// catch is an instance of runtime
        catch (UncompilableException/*<T>*/ e)
        {
            e.printStackTrace();
        }
    }
}
