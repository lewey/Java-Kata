package erasure.compatibility.implicationsOfErasure;
import java.util.List;

public class Overloading
{

    public void print(String param)
    {

    }

    public void print(Integer param)
    {

    }

    public void print(List<String> param)
    {

    }

    /*

    This is not possible due to erasure as they will both be List as byte code.
    The generics is removed

    public void print(List<Integer> param)
    {

    }
    */

}
