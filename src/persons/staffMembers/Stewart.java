package persons.staffMembers;

import persons.StaffMember;

import java.time.LocalDate;


public class Stewart extends StaffMember {


    public Stewart(String name, String lastName, String IDNumber, LocalDate birthDate) {
        super(name, lastName, IDNumber, birthDate);
    }

    public Stewart(String name){
        super(name);
    }

}
