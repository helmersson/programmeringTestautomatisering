package exercise3;

import java.util.Scanner;


public class Fibonacci {

    public static void main(String[] args) {
        boolean incorrectFibonacci = true;

        while (incorrectFibonacci) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Write the order of Fibonacci you want");
            try {
                int number = Integer.parseInt(scan.nextLine());


                int[] fibonacci = new int[40];

                fibonacci[0] = 1;
                fibonacci[1] = 1;

                for (int i = 2; i < 40; i++) {
                    fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
                }
                System.out.println("This corresponds to:");
                System.out.println(fibonacci[number - 1]);
                incorrectFibonacci = false;

            } catch (Exception e) {
                System.out.println("Please write a number between 1-40");

            }

        }
    }
}