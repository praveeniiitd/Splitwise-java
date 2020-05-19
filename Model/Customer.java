package Model;

import java.util.Objects;

public class Customer extends Account {
    private String name;
    private String phoneno;
    private String email;
    private String role;

    public Customer() {
    }

    public Customer(String name, String phoneno, String email, String role) {
        this.name = name;
        this.phoneno = phoneno;
        this.email = email;
        this.role = role;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    public Customer phoneno(String phoneno) {
        this.phoneno = phoneno;
        return this;
    }

    public Customer email(String email) {
        this.email = email;
        return this;
    }

    public Customer role(String role) {
        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) && Objects.equals(phoneno, customer.phoneno) && Objects.equals(email, customer.email) && Objects.equals(role, customer.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneno, email, role);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", phoneno='" + getPhoneno() + "'" +
            ", email='" + getEmail() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
}