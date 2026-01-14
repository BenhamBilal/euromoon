package persons.passengers;

import persons.Person;

import java.time.LocalDate;

/**
 * houd gegevens van de passagier bij
 */
public class Passenger extends Person {

    /**
     * Maakt een nieuwe passagier aan.
     *
     * @param name voornaam
     * @param lastName achternaam
     * @param IDNumber rijksregisternummer
     * @param birthDate geboortedatum
     */
    public Passenger(String name, String lastName, String IDNumber, LocalDate birthDate){
        super(name,lastName,IDNumber,birthDate);
    }

}
