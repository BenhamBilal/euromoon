package trips;

import persons.staffMembers.Driver;
import persons.staffMembers.Stewart;
import trains.Train;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Trip {

    private Station departureStation;
    private Station arrivalStation;
    private LocalDateTime tripTime;
    private Train train;
    private List<Driver> driverList;
    private List<Stewart> stewartList;

    public Trip(Station departureStation, Station arrivalStation, LocalDateTime tripTime, Train train) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.tripTime = tripTime;
        this.train = train;
        this.driverList = new ArrayList<Driver>();
        this.stewartList = new ArrayList<Stewart>();
    }

    public Station getDepartureStation() {
        return departureStation;
    }

    public void setDepartureStation(Station departureStation) {
        this.departureStation = departureStation;
    }

    public Station getArrivalStation() {
        return arrivalStation;
    }

    public void setArrivalStation(Station arrivalStation) {
        this.arrivalStation = arrivalStation;
    }

    public LocalDateTime getTripTime() {
        return tripTime;
    }

    public void setTripTime(LocalDateTime tripTime) {
        this.tripTime = tripTime;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public List<Driver> getDriverList() {
        return driverList;
    }

    public void addDriver(Driver driver) {
        this.driverList.add(driver);
    }

    public List<Stewart> getStewartList() {
        return stewartList;
    }

    public void addStewart(Stewart stewart) {
        this.stewartList.add(stewart);
    }

    public boolean isTripBookable(){
        return !this.driverList.isEmpty() && this.stewartList.size() > 2;
    }



    @Override
    public String toString() {
        return "Trip{" +
                "departureStation=" + departureStation +
                ", arrivalStation=" + arrivalStation +
                ", tripTime=" + tripTime +
                ", train=" + train +
                ", driverList=" + driverList +
                ", stewartList=" + stewartList +
                '}';
    }
}
