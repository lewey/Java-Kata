package orderBy;

import java.util.Objects;

public class Person {
    private String id;

    private String major;

    private String address;

    public Person(String id, String major, String address) {
        this.id = id;
        this.major = major;
        this.address = address;
    }

    public String getProperty(String property) {
        try {
            return (String) this.getClass().getDeclaredField(property).get(this);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            throw new RuntimeException("field not available", ex);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(major, person.major) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, major, address);
    }
}
