package Day02;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2020A {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    int number;
                    int counter = 0, cntE = 0, cntP = 0;
                    double avg = 0;
                    int sum = 0;
                    while ((number = in.nextInt()) != 0) {
                        counter++;
                        if (number % 2 == 0)
                            cntE++;

                        if (number > 0) {
                            cntP++;
                            avg += number;
                            sum += number;
                        }
//                        cntP += (number > 0) ? 1 : 0;
//                        avg += (number > 0) ? number : 0;
                    }
                    System.out.println(counter);
                    System.out.println(cntE);
                    System.out.println(avg / cntP);
                    System.out.println((double) sum / cntP);

                    break;
                case 2:
                    break;
                case 3:
                    Clock c = new Clock(20, 45);
                    System.out.println(c.Q3_A());
                    Clock flight1 = new Clock(new Random().nextInt(1, 24), new Random().nextInt(0, 60));
                    System.out.println(flight1);
                    Clock flight2 = new Clock(new Random().nextInt(1, 24), new Random().nextInt(0, 60));
                    System.out.println(flight2);

                    System.out.println((flight1.Q3_A() < flight2.Q3_A()) ? flight1 : flight2);

                    break;
                case 4:
                    int[] arr = {22, 56, 123, 12, 10, -4, 2};
                    boolean bool = Q4_A(arr);
                    bool = TestQ4(arr, 2);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case -1:
                    return;
            }
        }
    }

    // {1,2,10,9,15,16,19,18}
    private static boolean helpQ4_A(int[] arr, int index, int k) {
        for (int i = index; i < index + k - 1; i++) {
            if (arr[i] >= arr[i + 1])
                return false;
        }
        return true;
    }

    private static boolean helpQ4_B(int[] arr, int index, int k) {
        for (int i = index; i < index + k - 1; i++) {
            if (arr[i] <= arr[i + 1])
                return false;
        }

        return true;
    }


    private static boolean TestQ4(int[] arr, int k) {
        if (arr.length < 100 || arr.length % 2 != 0)
            return false;

        boolean bool = true;
        for (int i = 0; i < arr.length; i += k) {
            if (bool) {
                if (!helpQ4_A(arr, i, k))
                    return false;
            } else {
                if (!helpQ4_B(arr, i, k))
                    return false;
            }
            bool = !bool;
        }


        return true;
    }

    //O(n)
    private static boolean Q4_A(int[] arr) {
        if (arr.length < 3 || arr.length % 2 == 0)
            return false;

        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            if (arr[mid] >= arr[i])
                return false;
        }

        for (int i = mid + 1; i < arr.length; i++) {
            if (arr[mid] <= arr[i])
                return false;
        }
        return true;
    }


}

class Clock {
    private int hour; // העש 23-0
    private int min; // תוקד 59-0

    public Clock(int hour, int min) {
        this.hour = hour;
        this.min = min;
    }

    public int Q3_A() {

        int t1 = 24 * 60;
        int t2 = hour * 60;
        return t1 - t2 - min;
    }

    @Override
    public String toString() {
        return ((hour < 10) ? "0" + hour : hour) + ":" + ((min < 10) ? "0" + min : min);
    }
}