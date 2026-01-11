package persons.passengers;

import persons.Person;

import java.time.LocalDate;

public class Passenger extends Person {

    public Passenger(String name, String lastName, String IDNumber, LocalDate birthDate){
        super(name,lastName,IDNumber,birthDate);
    }
}
