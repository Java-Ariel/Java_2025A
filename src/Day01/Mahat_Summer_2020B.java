package Day01;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2020B {

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
                    String str;
                    int counterA = 0;
                    int counterDig = 0;

                    for (int i = 0; i < 50; i++) {
                        str = in.next();
                        int size = str.length();

                        char chE = str.charAt(size - 1);
                        char chS = str.charAt(0);

                        if (size % 2 == 0) {
                            System.out.println(ANSI_YELLOW + str.charAt(0) + ANSI_RESET);
                        } else {
                            System.out.println(str.charAt(size - 1));
                        }
                        counterA += (str.charAt(0) == 'A') ? 1 : 0;

//                        if(str.charAt(0)=='A')
//                            counterA++;

                        if (chE >= '0' && chE <= '9')
                            counterDig++;

//                        if (chE >= 48 && chE <= 57)
//                            counterDig++;

                    }

                    System.out.println("Start A - " + counterA);
                    System.out.println("End Digit - " + counterDig);
                    break;
                case 2:
                    Jumper[] jumpers = new Jumper[20];
                    for (int i = 0; i < 20; i++) {
                        jumpers[i] = new Jumper("name-" + i, new Random().nextDouble(0, 11));
                    }
                    double avg = Q2_A(jumpers);
                    System.out.println(avg);
                    Q2_B(jumpers);
                    break;
                case 3:
                    break;
                case 4:
                    int[] arr = {22, 56, 10, 13, 31, 44};
                    boolean bool = Q4_A(arr);
                    break;
                case 9:
                    str = "READ ONLY MEMORY";
                    String new_str = Q9(str);
                    System.out.println(new_str);
                    break;
                case 10:
                    num = 71;
                    arr = new int[]{4,10,13,71,10,10,71,71,2,10};
                    int dis = Q10_A(arr, num);
                    System.out.println(dis);
                    dis = Q10_A(arr, 13);
                    System.out.println(dis);

                    dis = Q10_A(arr, 133);
                    System.out.println(dis);
                    break;
                case -1:
                    return;
            }
        }
    }

    private static String Q9(String str) {
        String newString = "";
        newString += str.charAt(0) + ".";
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newString += str.charAt(i + 1) + ".";
            }
        }
        return newString;
    }

    //O(n)
    private static boolean Q4_A(int[] arr) {

        if (arr.length < 4 || arr.length % 2 != 0)
            return false;

        int half = arr.length / 2;
        int sum = 0;
        for (int i = 0; i < half; i++) {
            sum += arr[i];
        }

        for (int i = half; i < arr.length; i++) {
            sum -= arr[i];
        }

        return sum == 0;
    }

    private static void Q2_B(Jumper[] jumpers) {
        double avg = Q2_A(jumpers);
        for (int i = 0; i < jumpers.length; i++) {
            if (jumpers[i].getScore() > avg)
                System.out.println(jumpers[i].getName() + ANSI_RED + " Score -> " + ANSI_YELLOW + jumpers[i].getScore() + ANSI_RESET);
        }
    }

    private static double Q2_A(Jumper[] jumpers) {
        double sum = 0;
        for (int i = 0; i < jumpers.length; i++) {
            sum += jumpers[i].getScore();
        }
        return sum / jumpers.length;
    }

    private static int Q10_A(int[] arr, int num) {


        int dis = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                dis = i;
                break;
            }
        }

        if (dis == -1)
            return dis;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == num)
                break;

            dis++;
        }
        return dis;

    }
}

class Jumper {

    private String name;
    private double score;

    public Jumper(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
