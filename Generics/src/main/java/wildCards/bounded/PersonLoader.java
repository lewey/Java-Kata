package wildCards.bounded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class PersonLoader
{
    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException
    {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws ClassNotFoundException
    {


        try
        {
            final String className = file.readUTF();
            final String personName = file.readUTF();
            final int age = file.readInt();

            final Class<?> personClass = Class.forName(className);
            final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            return (Person) constructor.newInstance(personName, age);
        }
        catch (IOException e)
        {
            return null;
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /*
       <? super Person> implies that we can save a List that contains things that are a Person
       or a parent of Person
       use super when you are adding things
       This is contravariance
     */
    public void loadAll(final List<? super Person> people) throws ClassNotFoundException
    {
        Person person;

        while ((person = load()) != null)
        {
            people.add(person);
        }
    }
}
