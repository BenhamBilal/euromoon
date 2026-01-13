package persons.staffMembers;

import persons.StaffMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Driver extends StaffMember {

    public Driver(String name, String lastName, String IDNumber, LocalDate birthDate) {
        super(name, lastName, IDNumber, birthDate);

    }

    public Driver(String name) {
        super(name);

    }

}
