package trips;

import persons.passengers.Passenger;
import persons.staffMembers.Driver;
import persons.staffMembers.Stewart;
import trains.Train;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Trip houd :vertrek station , aankomststation,tijdstip,datum,trein bij en zorgd dat constructor is gemaakt alleen maa als er minimum 1 bestuurder en minimum 3 stewards gebookd zijn
 */
public class Trip {

    private String departureStation;
    private String arrivalStation;
    private LocalTime tripTime;
    private LocalDate date;
    private Train train;
    private Driver driver;
    private List<Stewart> stewartList;
    private List<Passenger> passengerList;


    /**
     * Trip houd :vertrek station , aankomststation,tijdstip,datum,trein bij en zorgd dat constructor is gemaakt alleen maa als er minimum 1 bestuurder en minimum 3 stewards gebookd zijn
     */
    public Trip(String departureStation, String arrivalStation, LocalDate date, LocalTime tripTime, Train train, Driver driver, List<Stewart> stewartList) {

        if (driver == null) {
            throw new IllegalArgumentException("Driver is verplicht");
        }

        if (stewartList == null || stewartList.size() < 3) {
            throw new IllegalArgumentException("Minstens 3 stewards vereist");
        }

        if (departureStation == null || arrivalStation == null || date == null || tripTime == null) {
            throw new IllegalArgumentException("Reisgegevens mogen niet leeg zijn");
        }

        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.date = date;
        this.tripTime = tripTime;
        this.train = train;
        this.driver = driver;
        this.stewartList = new ArrayList<>(stewartList);
        this.passengerList = new ArrayList<>();
    }

    public String getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(String departureStation) {
        this.departureStation = departureStation;
    }

    public String getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(String arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public LocalTime getTripTime() {
        return tripTime;
    }

    public void setTripTime(LocalTime tripTime) {
        this.tripTime = tripTime;
    }

    public Train getTrain() {
        return train;
    }

    /**
     * methode om trein te registreren
     * @throws IllegalStateException wanneer trein niets bevat
     * @param train trainte registreren
     */
    public void setTrain(Train train) {
        if(this.train != null){
            throw new IllegalStateException("Deze reis beval een trein");
        }
        this.train = train;
    }

    /**
     * verkoopt ticket wanneer aan de hand van methode addpassenger() die controleert of er genoeg plaats is of niet
     * @param passenger de passagier die aan de trein wordt toegevoegd
     * @return fals je niet hebt kunne verkopen en true als je wel hebt kunnen verkopen
     */
    public boolean sellTicket(Passenger passenger){
        if (train == null){
            System.out.println("Sorry er kan geet tickets verkocht worden , geen trein is gekoppeld");
            return false;
        }
        boolean addedToTrein = train.addPassenger(passenger);
        if(!addedToTrein){
            System.out.println("Sorry, de trein is vol");
            return false;
        }

        passengerList.add(passenger);
        System.out.println("Ticket verkocht aan " + passenger.getName());
        return true;
    }

    public List<Stewart> getStewartList() {
        return stewartList;
    }

    public void addStewart(Stewart stewart) {
        if (stewartList.size() < 3) {
            stewartList.add(stewart);
        }else {
            throw new IllegalStateException("Maximaal 3 stewards toegestaan");
        }
    }


    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "departureStation=" + departureStation +
                ", arrivalStation=" + arrivalStation +
                ", tripTime=" + tripTime +
                ", date=" + date +
                ", train=" + train +
                ", stewartList=" + stewartList +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }
}
