package Exercises.exeptions;

import java.util.Scanner;

public class Exercise1o2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] names = {"Ada", "Beda", "Cålle"};

        while (true) {
            System.out.println("Ange ett nummer 0-2 för att skriva ut motsvarande namn");

            try {
                int index = Integer.parseInt(scanner.nextLine());

                System.out.println(names[index]);
                break;
            } catch (NumberFormatException | NullPointerException | ArrayIndexOutOfBoundsException e)  {
                System.out.println("Ange ett heltal melllan 0-2.");
            } catch (Exception e) {
                System.out.println("UnknownError");
            }
        }
        scanner.close();

    }
}