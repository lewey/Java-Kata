package advanced.intersectionTypes;

import advanced.Person;

import java.io.*;

public class PersonReader
{
    public static void main(String[] args) throws FileNotFoundException {
        PersonReader reader = new PersonReader();

        DataInputStream stream = new DataInputStream(new FileInputStream(
            "src/main/resources/person"));

        //using the standard read method is fine as it accepts a DataInputStream
        Person person = reader.read(stream);
        System.out.println(person);

        RandomAccessFile randomAccessFile = new RandomAccessFile(
            "src/main/resources/person", "rw");
        person = reader.readGen(randomAccessFile);
        System.out.println(person);
    }

    public Person read(final DataInputStream source) {
        //try with resources
        try(DataInputStream input = source) {
            return new Person(input.readUTF(), input.readInt());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

   /*
        This is an example of an Intersection type
        T must implement Closable which is required for try with resource
        T must also implement DataInput as this is required to access readUTF and readInt
   */
    public <T extends DataInput & Closeable> Person readGen(final T source) {
        try(T input = source) {
            return new Person(input.readUTF(), input.readInt());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
