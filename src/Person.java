import java.util.Objects;

public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;

    Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    Person() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, phone);
    }
}