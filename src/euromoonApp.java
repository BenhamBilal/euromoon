import persons.StaffMember;
import persons.passengers.Passenger;
import persons.staffMembers.Driver;
import persons.staffMembers.Stewart;
import trains.Class373;
import trains.Class374;
import trains.Locomotive;
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
   List<Stewart> stewardList = new ArrayList<>();
    List<String> certificationList = new ArrayList<>();

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
                case 2:
                    creatTrip();
                    System.out.println(tripList);
                    break;
                case 3:
                    creatTrain();
                    bookTrain();
                    System.out.println("Train gekoppeld");
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

    public void creatTrip() {

        System.out.println("Van waar wil je vertrekken ?");

        String departureStation = scan.nextLine();

        System.out.println("Waar wil je naartoe gaan ?");

        String arrivalStation = scan.nextLine();

        System.out.println("Waneer wil je riezen ? :(dd-MM-yyyy)");

        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate date = LocalDate.parse(scan.nextLine(), formatDate);

        System.out.println("Om hoelaat wil je reizen ? :(HH-mm)");

        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH-mm");

        LocalTime time = LocalTime.parse(scan.nextLine(), formatTime);

        while (stewardList.size() < 3) {
            System.out.println("Naam van steward (" + (stewardList.size() + 1) + "):");
            String name = scan.nextLine();

            Stewart stewart = new Stewart(name);

            do {
                System.out.println("Certificaat:");
                stewart.addCertification(scan.nextLine());

                System.out.println("Nog een? (ja/nee)");
            } while (!scan.nextLine().equalsIgnoreCase("nee"));

            stewardList.add(stewart);
        }

        System.out.println("Naam van Driver : ");

        String driverNaam = scan.nextLine();

        Driver driver = new Driver(driverNaam);




        Trip trip = new Trip();

        tripList.add(trip);

        System.out.println("Reis aangemaakt");

    }

    public void creatTrain() {
        Locomotive locomotive = null;

        int choiceLocomotive;

        do {
            System.out.println("Welke lokomotiefclasse wil je ? (1.Class373 of 2.Class374 )");
            choiceLocomotive = scan.nextInt();
            switch (choiceLocomotive) {
                case 1:
                    locomotive = new Class373();
                    System.out.println("Je hebt Class 373 gekozen");
                    break;
                case 2:
                    locomotive = new Class374();
                    System.out.println("Je hebt Class 374 gekozen");
                    break;
                default:
                    System.out.println("ongeldige keuze");
            }
        } while (locomotive == null);
        Train train1 = new Train(locomotive);
        trainList.add(train1);

    }

    public void bookTrain() {
        if (tripList.isEmpty()) {
            System.out.println("Geen reizen beschikbaar");
            return;
        }

        System.out.println("Kies een reis :");

        for (int i = 1; i < tripList.size(); i++) {
            System.out.println(i + ":" + tripList.get(i));
        }
    }


}
