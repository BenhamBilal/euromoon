package persons.staffMembers;

import persons.StaffMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Stewart extends StaffMember {

    private List<String> certificationList;

    public Stewart(String name, String lastName, String IDNumber, LocalDate birthDate) {
        super(name, lastName, IDNumber, birthDate);
    }

    public Stewart(String name){
        super(name);
        this.certificationList = new ArrayList<String>();

    }

}
