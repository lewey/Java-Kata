package circularBufferExample;

public class CircularBuffer
{
    private final Object[] buffer;  //non generic will use an object
    private int readCursor = 0;
    private int writeCursor = 0;

    public CircularBuffer(int size) {
        buffer = new Object[size];
    }

    //offer method inserts objects into the buffer
    public boolean offer(Object value) {
        // no available space
        if (buffer[writeCursor] != null) {
            return false;
        }

        buffer[writeCursor] = value; //insert the value
        writeCursor = next(writeCursor); //move the cursor along
        return true;
    }

    //remove a value
    public Object poll() {
        Object value = buffer[readCursor];
        if (value != null) {
            buffer[readCursor] = null;
            readCursor = next(readCursor);
        }
        return value;
    }

    private int next(int index) {
        return (index + 1) % buffer.length;
    }
}
