package trains;

public class Class373 implements Locomotive{


    @Override
    public int getMaxWagon() {

        return 12;
    }

    public int getCapacity() {
        return maxCapacityIncludedLuggage;
    }

    @Override
    public String toString() {
        return "Class373";
    }


}
