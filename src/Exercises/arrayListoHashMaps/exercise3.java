package Exercises.arrayListoHashMaps;

import java.util.HashMap;
import java.util.Scanner;

public class exercise3 {
    public static void main(String[] args) {
        HashMap<String, Integer> people = new HashMap<>();

        people.put("Höder", 73);
        people.put("Freja", 36);
        people.put("Oden", 91);

        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();

        System.out.println(name + " is " + people.get(name) + " years old");

    }
}
