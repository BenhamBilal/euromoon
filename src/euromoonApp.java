import persons.passengers.Passenger;
import trains.Train;
import trips.Trip;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class euromoonApp {

    List<Passenger> passengerList = new ArrayList<Passenger>();
    List<Trip> tripList = new ArrayList<>();
    List<Train> trainList = new ArrayList<>();

    Scanner scan = new Scanner(System.in);


    public void start() {

        boolean running = true;

        while (running) {


            System.out.println(
                    "Maak een keuze : \n" +
                            "\n" +
                            "1.Registreren passagiers. \n" +
                            "2.Aanmaken reis. \n" +
                            "3.Trein koppelen aan reis. \n" +
                            "4.Ticket verkopen aan passagier. \n" +
                            "5.Afdrukken boardinglijst. \n" +
                            "6.Afsluiten"
            );


            int choice;

            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ongeldig invoer , probeer opnieuw");
                continue;
            }

            switch (choice) {
                case 1:
                    PassengerRegister();
                    System.out.println(passengerList);
                    break;
                case 2 :
                    creatTrip();
                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Ongeldig keuze");
            }

        }

    }

    public void PassengerRegister() {
        Passenger p = creatPassenger();
        passengerList.add(p);
        System.out.println("Passenger registred ");

    }


    public Passenger creatPassenger() {

        System.out.println("Naam : ");

        String name = scan.nextLine();

        System.out.println("Achternaam : ");

        String lastName = scan.nextLine();

        System.out.println("Rijksregisternummer : ");

        String IDNumber = scan.nextLine();

        System.out.println("Geboortedatum : (format : yyyy-MM-dd)");

        LocalDate birthdate = LocalDate.parse(scan.nextLine());

        return new Passenger(name, lastName, IDNumber, birthdate);
    }

    public void creatTrip(){

        System.out.println("Van waar wil je vertrekken ?");

        String departureStation = scan.nextLine();

        System.out.println("Waar wil je naartoe gaan ?");

        String arrivalStation = scan.nextLine();

        System.out.println("Waneer wil je riezen ? :(HH-mm)");

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(scan.nextLine(),formatDate);

        System.out.println("Om hoelaat wil je riezen ? :(HH-mm)");

        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH-mm");

        LocalTime time = LocalTime.parse(scan.nextLine(),formatTime);

        Trip trip = new Trip(departureStation,arrivalStation,date,time);

        tripList.add(trip);

        System.out.println("Reis aangemaakt");

    }


}
