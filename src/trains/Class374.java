package trains;

public class Class374 implements Locomotive{

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
