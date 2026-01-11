package persons;

import java.time.LocalDate;
import java.util.Objects;

public class Person {

    private String name;
    private String lastName;
    private String IDNumber;
    private LocalDate birthDate;

    public Person(String name, String lastName, String IDNumber, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.IDNumber = IDNumber;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getIDNumber(), person.getIDNumber()) && Objects.equals(getBirthDate(), person.getBirthDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLastName(), getIDNumber(), getBirthDate());
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", IDNumber='" + IDNumber + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
