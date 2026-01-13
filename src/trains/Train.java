package trains;

import persons.passengers.Passenger;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private Locomotive locomotive;
    private int currentPassengers;
    private List<String> wagonList;
    private List<Passenger> passengerList = new ArrayList<>();

    public Train(Locomotive locomotive) {
        this.locomotive = locomotive;
        this.wagonList = new ArrayList<>();
        this.currentPassengers = 0;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

   public int getMaxCapacityIncludedLuggage(){
        return Locomotive.maxCapacityIncludedLuggage;
   }

    public int getCurrentPassengers() {
        return currentPassengers;
    }

    public boolean addPassenger(Passenger passenger){
        if (currentPassengers >= getMaxCapacityIncludedLuggage()){
            System.out.println("geen plaats meer");
            return false;
        }
        passengerList.add(passenger);
        currentPassengers++;
        return true;
    }

    public int getMaxWagons() {
        return locomotive.getMaxWagon();
    }

    public boolean addWagons(String wagonNaam){
        if(wagonList.size() >= getMaxWagons()){
            System.out.println("Maximaal wagon bereikt (" + getMaxWagons() + ")");
            return false;
        }
        wagonList.add(wagonNaam);
        System.out.println("Wagon toegevoegd " + wagonNaam);
        return true;
    }

    public List<String> getWagons() {
        return wagonList;
    }

    @Override
    public String toString() {
        return "Train{" +
                "locomotive=" + locomotive +
                ", currentPassengers=" + currentPassengers +
                ", wagonList=" + wagonList +
                '}';
    }
}
