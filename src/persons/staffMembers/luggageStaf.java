package persons.staffMembers;

import persons.StaffMember;

import java.time.LocalDate;

/**
 * houd gegevens van een personeelslid
 */
public class luggageStaf extends StaffMember {

    public luggageStaf(String name, String lastName, String IDNumber, LocalDate birthDate) {
        super(name, lastName, IDNumber, birthDate);
    }
}
