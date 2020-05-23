package Model;

import java.util.Objects;

public class Person {
    private String name;
    private String phoneno;
    private String address;

    public Person() {
    }

    public Person(String name, String phoneno, String address) {
        this.name = name;
        this.phoneno = phoneno;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return this.phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person name(String name) {
        this.name = name;
        return this;
    }

    public Person phoneno(String phoneno) {
        this.phoneno = phoneno;
        return this;
    }

    public Person address(String address) {
        this.address = address;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(phoneno, person.phoneno) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneno, address);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", phoneno='" + getPhoneno() + "'" +
            ", address='" + getAddress() + "'" +
            "}";
    }
}