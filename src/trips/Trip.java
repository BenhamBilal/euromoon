package trips;

import persons.staffMembers.Driver;
import persons.staffMembers.Stewart;
import trains.Train;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Trip {

    private String departureStation;
    private String arrivalStation;
    private LocalTime tripTime;
    private LocalDate date;
    private Train train;
    private List<Driver> driverList;
    private List<Stewart> stewartList;

    public Trip(String departureStation, String arrivalStation, LocalTime tripTime, LocalDate date, Train train) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.tripTime = tripTime;
        this.date = date;
        this.train = train;
        this.driverList = new ArrayList<Driver>();
        this.stewartList = new ArrayList<Stewart>();
    }
    public Trip(String departureStation, String arrivalStation, LocalDate date, LocalTime tripTime) {
        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.date = date;
        this.tripTime = tripTime;
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
                ", date=" + date +
                ", train=" + train +
                ", driverList=" + driverList +
                ", stewartList=" + stewartList +
                '}';
    }
}
