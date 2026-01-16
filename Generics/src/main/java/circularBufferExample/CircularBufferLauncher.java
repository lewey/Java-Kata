package circularBufferExample;

public class CircularBufferLauncher
{
    public static void main(String[] args)
    {
        CircularBuffer buffer = new CircularBuffer(10);

        buffer.offer("a");
        buffer.offer("bc");
        buffer.offer("d");

        //buffer.offer(1);  //this code will fail at runtime with a class cast exception

        String value = concatenate(buffer);
        System.out.println(value);
    }

    private static String concatenate(CircularBuffer buffer)
    {
        StringBuilder result = new StringBuilder();

        String value;
        while ((value = (String) buffer.poll()) != null) // there is a need for a cast here
        {
            result.append(value);
        }

        return result.toString();
    }
}
