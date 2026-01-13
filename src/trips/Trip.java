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
    private Driver driver;
    private List<Stewart> stewartList;

    public Trip(String departureStation,
                String arrivalStation,
                LocalDate date,
                LocalTime tripTime,
                Train train,
                Driver driver,
                List<Stewart> stewartList) {

        if (driver == null) {
            throw new IllegalArgumentException("Driver is verplicht");
        }

        if (stewartList == null || stewartList.size() < 3) {
            throw new IllegalArgumentException("Minstens 3 stewards vereist");
        }

        this.departureStation = departureStation;
        this.arrivalStation = arrivalStation;
        this.date = date;
        this.tripTime = tripTime;
        this.train = train;
        this.driver = driver;
        this.stewartList = stewartList;
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



    public List<Stewart> getStewartList() {
        return stewartList;
    }

    public void addStewart(Stewart stewart) {
        if (stewartList.size() >= 3) {
            stewartList.add(stewart);
        }
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
}
