package Exercises.exeptions;

import java.util.Scanner;

public class Exercise6o7o8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean readNumbers = true;
        int i = 0;

        while (readNumbers) {
            try {
                 i = Integer.parseInt(scanner.nextLine());

                readNumbers = false;
            } catch (NumberFormatException e){
                System.out.println("NumberFormatException" + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unknown Error" + e.getMessage());
            }
        }
        readNumbers = true;

        while (readNumbers) {
            try {
                int j = Integer.parseInt(scanner.nextLine());

                System.out.println(i / j);

                readNumbers = false;
            } catch (NumberFormatException e){
                System.out.println("NumberFormatException" + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unknown Error" + e.getMessage());
            }


        }


       // int j = Integer.parseInt(scanner.nextLine());

       // System.out.println(i / j);
    }
}