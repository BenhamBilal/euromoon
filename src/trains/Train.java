package trains;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private Locomotive locomotive;
    private List<Wagon> wagons;

    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.wagons = new ArrayList<Wagon>();
    }

    public boolean canAddWagon(Wagon wagon) {

        if (this.wagons.size() < locomotive.getMaxWagon()) {
            wagons.add(wagon);
            return true;
        }else {
            return false;
        }
    }

}
