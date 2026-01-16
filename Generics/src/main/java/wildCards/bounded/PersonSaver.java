package wildCards.bounded;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class PersonSaver
{
    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException
    {
        this.file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException
    {
        file.writeUTF(person.getClass().getName());
        file.writeUTF(person.getName());
        file.writeInt(person.getAge());
    }

    /*
       <? extends Person> implies that we can save a List that contains things that extend from Person
       this, a list of Employees or a list of Partners and of course Person
       use extends when you are getting things
       This is covariance
     */
    public void saveAll(final List<? extends Person> people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }

    public void saveAll(final Person[] people) throws IOException
    {
        for (Person person : people)
        {
            save(person);
        }
    }
}
