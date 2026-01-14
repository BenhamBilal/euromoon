package trains;

/**
 * Class soort locomotief naargelang maximum aantalcapaciteit wagon
 */
public class Class374 implements Locomotive{

    public Class374() {
    }

    public int getMaxWagon(){

        return 14;
    }

    public int getcapacity(){
        return maxCapacityIncludedLuggage;
    }

    @Override
    public String toString() {
        return "Class374";
    }

}
