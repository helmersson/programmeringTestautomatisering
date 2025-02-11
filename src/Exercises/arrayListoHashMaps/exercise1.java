package Exercises.arrayListoHashMaps;

import java.util.ArrayList;
import java.util.Arrays;

public class exercise1 {
    double pi = 3.1415926535;
    double e = 2.7182818284;
    double sqt2 = 1.4142135623;
    double phi = 1.6180339887;
    double ln0 = 2.302585092;

     ArrayList<Double> constants = new ArrayList<>();

    {
        constants.add(pi);
        constants.add(e);
        constants.add(sqt2);
        constants.add(phi);
        constants.add(ln0);
    }

    public void printConstants() {
        for (Double constant : constants) {
            System.out.println(constant);
        }
    }
}