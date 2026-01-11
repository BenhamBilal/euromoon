package persons.staffMembers;

import persons.StaffMember;

import java.time.LocalDate;

public class Driver extends StaffMember {

    public Driver(String name, String lastName, String IDNumber, LocalDate birthDate) {
        super(name, lastName, IDNumber, birthDate);

    }

    @Override
    public void addCertification(String certification){

    }
}
