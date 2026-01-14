package persons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Houd gegevens van persoon waar staff member extend is en houd een certification lijst in
 */
public abstract class StaffMember extends Person {

    protected List<String> certificationList;

    public StaffMember(String name, String lastName, String IDNumber, LocalDate birthDate) {
        super(name, lastName, IDNumber, birthDate);
        this.certificationList = new ArrayList<String>();
    }

    public StaffMember(String name){
        super(name);
        this.certificationList = new ArrayList<String>();
    }

    /**
     * voegt een String in StringLijst certificationList
     * @param certification om een certifaat te in dienen
     */
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
