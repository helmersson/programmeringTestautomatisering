package Exercises.arrayListoHashMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class exercise2 {
    public static void main(String[] args) {
        List<String> namn = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Ange namn, skriv stop för att avsluta:");
        while (!(input = scanner.nextLine()).equalsIgnoreCase("stop")) {
            namn.add(input);
        }

        System.out.println("\nSparade namn:\n" + namn);

        if (!namn.isEmpty()) {
            System.out.println("\nAnge ett nytt namn för första platsen;");
            namn.set(0, scanner.nextLine());
        }

        if (namn.size() > 1) {
            System.out.println("\nVill du byta plats på första och sista namnet? (ja/nej)");
            if (scanner.nextLine().equalsIgnoreCase("ja")) {
                var first = namn.getFirst();
                var last = namn.getLast();
                namn.set(0, last);
                namn.set(namn.size() - 1, first);
                System.out.println("Namnen har bytt plats.");
            } else {
                System.out.println("Ingen platsändring gjordes.");
            }
        }


        System.out.println("\nUppdaterad lista:\n" + namn);
        scanner.close();
    }
}
