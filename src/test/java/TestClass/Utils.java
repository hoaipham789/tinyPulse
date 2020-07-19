package TestClass;

import java.util.Random;

public class Utils {

    public static int ranDom() {

        Random rand = new Random();
        int upperBound = 100;
        int min = 1;
        int max = 3;

        int randNum = rand.nextInt(upperBound);
        return randNum;

    }

}
