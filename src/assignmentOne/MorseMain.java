package assignmentOne;

import  java.util.Scanner;

public class MorseMain {
    public static void main(String[] args) {
        MorseLogic logic = new MorseLogic();
        Scanner scanner = new Scanner(System.in);

        boolean korrektInput = true;

        //  Huvudloop för allt
        while (korrektInput) {
            skrivMeny();
            int menyVal = läsMenyVal(scanner);
            //  Om val 3 avsluta loopen
            if (menyVal == 3) {
                korrektInput = false;
                System.out.println("Programmet avslutas.");
            } else {
                //  Hanterar användarens val
                menyValsHantering(logic, scanner, menyVal);
            }
        }
        scanner.close();
    }

    //  Skriver ut menyn när den körs
    public static void skrivMeny() {
        //  Meny för användaren
        System.out.println("""
                Välj konverteringstyp
                1. Morsekod till engelska
                2. Engelska till morsekod
                3. Avsluta
                """);
    }

    //  läser in menyVal och validerar det
    public static int läsMenyVal(Scanner scanner) {
        int menyVal;
        while (true) {
            try {
                System.out.println("Ange ditt val (1-3): ");
                // omvandlar input till int
                menyVal = Integer.parseInt(scanner.nextLine());
                //  Kontrollera om input är 1-3
                if (menyVal >= 1 && menyVal <= 3) {
                    return menyVal;
                } else {
                    System.out.println("Ogiltigt val. Vänligen välj 1, 2 eller 3.");
                }
            } catch (NumberFormatException e) {
                //  Hantera allt som inte är siffror
                System.out.println("Ogiltigt val. Vänligen ange ett nummer.");
            }
        }
    }

    //  Hanterar konvertering beroende på menyVal
    public static void menyValsHantering(MorseLogic logic, Scanner scanner, int menyVal) {
        System.out.println("Skriv text som du vill konvertera");
        String input = scanner.nextLine();
        try {
            String result = (menyVal == 1) ? logic.morseTillEngelska(input) : logic.engelskaTillMorse(input);
            System.out.println("Resultat: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Fel: " + e.getMessage());

        }
    }
}