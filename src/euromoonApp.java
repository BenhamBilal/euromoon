import persons.StaffMember;
import persons.passengers.Passenger;
import persons.staffMembers.Driver;
import persons.staffMembers.Stewart;
import trains.Class373;
import trains.Class374;
import trains.Locomotive;
import trains.Train;
import trips.Trip;

import java.io.FileWriter;
import java.io.IOException;
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
    List<Driver> driverList = new ArrayList<>();

    Scanner scan = new Scanner(System.in);


    public void start() throws IOException {

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
                    System.out.println("Trein gekoppeld");
                    break;
                case 4:
                    sellTicket();
                    break;
                case 5:
                    printBoardingList();
                    break;
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

        List<Stewart> stewardList = new ArrayList<>();
        System.out.println("Van waar wil je vertrekken ?");
        String departureStation = scan.nextLine();
        System.out.println("Waar wil je naartoe gaan ?");
        String arrivalStation = scan.nextLine();

        LocalDate date = null;
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (date == null) {
            try {
                System.out.println("Wanneer wil je reizen? (dd-MM-yyyy)");
                String dateInput = scan.nextLine();
                date = LocalDate.parse(dateInput, formatDate);
            } catch (Exception e) {
                System.out.println("Ongeldige datum, probeer opnieuw (dd-MM-yyyy).");
            }
        }

        LocalTime time = null;
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH-mm");

        while (time == null) {
            try {
                System.out.println("Om hoelaat wil je reizen? (HH-mm)");
                String timeInput = scan.nextLine();
                time = LocalTime.parse(timeInput, formatTime);
            } catch (Exception e) {
                System.out.println("Ongeldige tijd, probeer opnieuw (HH-mm).");
            }
        }

        while (stewardList.size() < 3) {
            System.out.println("Naam van steward (" + (stewardList.size() + 1) + "):");
            String stewartName = scan.nextLine();

            Stewart stewart = new Stewart(stewartName);

            do {
                System.out.println("Certificaat:");
                stewart.addCertification(scan.nextLine());

                System.out.println("Nog een? (ja/nee)");
            } while (!scan.nextLine().equalsIgnoreCase("nee"));

            stewardList.add(stewart);
        }

        System.out.println("Naam van Driver : ");

        String driverName = scan.nextLine();

        Driver driver = new Driver(driverName);

        driverList.add(driver);

        do {
            System.out.println("Certificaat:");
            driver.addCertification(scan.nextLine());

            System.out.println("Nog een? (ja/nee)");
        } while (!scan.nextLine().equalsIgnoreCase("nee"));


        Trip trip = new Trip(departureStation, arrivalStation, date, time, null, driver, stewardList);

        tripList.add(trip);

        System.out.println("Reis aangemaakt");

    }

    public void creatTrain() {
        Locomotive locomotive = null;

        int choiceLocomotive;

        do {
            System.out.println("Welke lokomotiefclasse wil je ? (1.Class373 of 2.Class374 )");
            choiceLocomotive = Integer.parseInt(scan.nextLine());
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

        if (trainList.isEmpty()) {
            System.out.println("Geen trein is beschikbaar");
            return;
        }

        System.out.println("Kies een reis :");

        for (int i = 0; i < tripList.size(); i++) {
            System.out.println(i + ":" + tripList.get(i));
        }

        Trip selectedTrip;

        try {
            int tripIndex = Integer.parseInt(scan.nextLine());
            selectedTrip = tripList.get(tripIndex);
        } catch (NumberFormatException nfe) {
            System.out.println("Dit is geen nummer, gelieve een nummer te geven :");
            return;
        } catch (IndexOutOfBoundsException ioobe) {
            System.out.println("Index is niet geldig , geef een geldige index");
            return;
        }


        if (selectedTrip.getTrain() != null) {
            System.out.println("Deze reis heeft al een trein");
            return;
        }

        System.out.println("Kies een trein :");

        for (int i = 0; i < trainList.size(); i++) {
            System.out.println(i + ":" + trainList.get(i));
        }

        Train selectedTrain;

        try {
            int trainIndex = Integer.parseInt(scan.nextLine());
            selectedTrain = trainList.get(trainIndex);
        }catch (NumberFormatException nbe){
            System.out.println("Dit is geen nummer, gelieve een nummer te geven :");
            return;
        }catch (IndexOutOfBoundsException ioobe){
            System.out.println("Index is niet geldig , geef een geldige index");
            return;
        }

        selectedTrip.setTrain(selectedTrain);
    }

    public void sellTicket(){
        if (tripList.isEmpty()) {
            System.out.println("Geen reizen beschikbaar");
            return;
        }
        if (passengerList.isEmpty()) {
            System.out.println("Geen passagiers beschikbaar");
            return;
        }

        System.out.println("Kies een reis:");
        for (int i = 0; i < tripList.size(); i++) {
            System.out.println(i + ": " + tripList.get(i));
        }
        int tripIndex = Integer.parseInt(scan.nextLine());
        Trip selectedTrip = tripList.get(tripIndex);

        System.out.println("Kies een passagier:");
        for (int i = 0; i < passengerList.size(); i++) {
            System.out.println(i + ": " + passengerList.get(i).getName());
        }
        int passengerIndex = Integer.parseInt(scan.nextLine());
        Passenger selectedPassenger = passengerList.get(passengerIndex);

        selectedTrip.sellTicket(selectedPassenger);
    }

    public void printBoardingList() throws IOException {
        System.out.println("Kies een reis om de boardinglijst te printen:");
        for (int i = 0; i < tripList.size(); i++) {
            System.out.println(i + ": " + tripList.get(i));
        }
        int tripIndex;
        try {
            tripIndex = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ongeldige invoer, probeer opnieuw.");
            return;
        }

        if (tripIndex < 0 || tripIndex >= tripList.size()) {
            System.out.println("Ongeldige index, probeer opnieuw.");
            return;
        }

        Trip selectedTrip = tripList.get(tripIndex);

        String safeTime = selectedTrip.getTripTime().toString().replace(":", "-");

        String filename = selectedTrip.getDepartureStation() + "_" + selectedTrip.getArrivalStation() + "_" + selectedTrip.getDate() + "T" + safeTime + ".txt";

        try (FileWriter writer = new FileWriter(filename)) {
            if (selectedTrip.getPassengerList().isEmpty()) {
                writer.write("Er zijn nog geen passagiers voor deze reis.\n");
            } else {
                for (Passenger p : selectedTrip.getPassengerList()) {
                    writer.write("Naam: " + p.getName() + " " + p.getLastName() + "\n");
                    writer.write("ID: " + p.getIDNumber() + "\n");
                    writer.write("Geboortedatum: " + p.getBirthDate() + "\n");
                    writer.write("\n");
                    writer.write("vertekStation : " + selectedTrip.getDepartureStation()+ "\n");
                    writer.write("aankomsStation : " + selectedTrip.getArrivalStation()+ "\n");
                    writer.write("rijstijdstip : " + selectedTrip.getTripTime()+ "\n");
                    writer.write("rijsdatum : " + selectedTrip.getDate()+ "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Fout bij het schrijven van het bestand: " + e.getMessage());
        }

    }

}
