package persons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class StaffMember extends Person {

    private List<String> certificationList ;

    public StaffMember(String name, String lastName, String IDNumber, LocalDate birthDate) {
        super(name, lastName, IDNumber, birthDate);
        this.certificationList = new ArrayList<String>();
    }

    public void addCertification(String certification) {
        this.certificationList.add(certification);
    }

    public List<String> getCertificationList(){
        return certificationList;
    }

    @Override
    public String toString() {
        return "StaffMember{" +
                "certificationList=" + certificationList +
                '}';
    }
}
