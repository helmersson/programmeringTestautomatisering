package Exercises.exeptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise3o4o5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Skriv in det första talet");
                double tal1 = Double.parseDouble(scanner.nextLine());

                System.out.println("Skriv in det andra talet");
                double tal2 = Double.parseDouble(scanner.nextLine());

                if (tal2 == 0) {
                    throw new ArithmeticException("Division med noll är inte möjligt");
                }

                double kvot = tal1 / tal2;
                System.out.println("Kvoten av " + tal1 + " och" + tal2 + " är: " + kvot);
            } catch (InputMismatchException e) {
                System.out.println("Fel: Ange ett numeriskt värde");
            } catch (ArithmeticException e) {
                System.out.println("Fel:" + e.getMessage());
            } catch (Exception e) {
                System.out.println("Oväntat fel:" + e.getMessage());
            }
            scanner.close();
        }

}
