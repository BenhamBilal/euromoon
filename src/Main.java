import persons.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    /**
     * Start de applicatie en toont het hoofdmenu.
     *
     * @throws IOException wanneer het schrijven van bestanden mislukt
     */
    public static void main(String[] args) throws IOException {
        euromoonApp app = new euromoonApp();
        app.start();
    }

}