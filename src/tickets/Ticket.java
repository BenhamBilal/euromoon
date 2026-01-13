package tickets;

import persons.passengers.Passenger;
import trains.Locomotive;
import trips.Trip;

public class Ticket {

    private Passenger passenger;
    private Trip trip;

    public Ticket(Passenger passenger, Trip trip) {
        this.passenger = passenger;
        this.trip = trip;
    }

    public boolean isTicketAvailable(){
        return Locomotive.maxCapacityIncludedLuggage < 1;
    }
}
