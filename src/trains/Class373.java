package trains;

/**
 * Class soort locomotief naargelang maximum aantalcapaciteit wagon
 */
public class Class373 implements Locomotive{
    public Class373() {
    }

    /**
     * Class soort locomotief naargelang maximum aantalcapaciteit wagon
     */
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
