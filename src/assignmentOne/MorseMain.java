package assignmentOne;

import  java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {
        MorseLogic logic = new MorseLogic();
        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {
                //  Meny för användaren
                System.out.println("Välj konverteringstyp");
                System.out.println("1. Morsekod till engelska");
                System.out.println("2. Engelska till morsekod");
                System.out.println("3. Avsluta");

                //  Läser användarens input
                int menyVal = scanner.nextInt();
                scanner.nextLine();

                //  Om val 3 avsluta loopen
                if (menyVal == 3) break;

                System.out.println("Ange text att konvertera");
                String input = scanner.nextLine();

                try {
                    String result = (menyVal == 1) ? logic.morseToEnglish(input) : logic.englishToMorse(input);
                    System.out.println("Resultat: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Fel: " + e.getMessage());
                }
            }
        }
    }
}