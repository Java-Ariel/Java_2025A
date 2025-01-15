package Day04;

import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2021_B {

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
    static Random rd = new Random();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:

                    int sum = 0;
                    for (int i = 0; i < 39; i++) {
                        int mis = rd.nextInt(100, 1000);
//                       mis = rd.nextInt(900)+100;
                        sum += mis;
                        if (mis % 2 == 0) {
                            int sumDigit = 0;
                            while (mis != 0) {
                                // ---- Iter 1 ----
                                //598%10 = 8
                                //598/10 = 59

                                // ---- Iter 2 ----
                                //59%10 = 9
                                //59/10 = 5

                                // ---- Iter 3 ----
                                //5%10 = 5
                                //5/10 = 0

                                //598%10 = 8
                                //598/10 = 59
                                sumDigit += mis % 10;
                                mis = mis / 10;

                            }
//                            sumDigit=mis%10+mis/10%10+mis/100;
                            System.out.println(sumDigit);


                        }


                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    String str = "abchdj";
                    boolean bool = Q4_a(str);
                    int cnt = 0;
                    while (!Q4_a(str)) {
                        str = "";
                        for (int i = 0, rand = rd.nextInt(20); i < rand; i++) {
                            if (rd.nextBoolean()) {
                                str += (rd.nextBoolean()) ? "" + (char) rd.nextInt(65, 92) : "" + (char) rd.nextInt(97, 123);
                            } else
                                str += rd.nextInt(48, 59);
                        }
                        System.out.println(str);
                        cnt++;
                    }

                    break;
                case 5:
                    Q5();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:

                    int[] arr = {3, 2, 2, 2, 5, 6, 6, 1, 3, 3, 3, 3, 1, 2};
                    int b = Q9(arr, 2);
                    System.out.println(b);
                    b = Q9(arr, 1);
                    System.out.println(b);

                    b = Q9_v2(arr, 2);
                    System.out.println(b);
                    b = Q9_v2(arr, 1);
                    System.out.println(b);
                    break;
                case 10:
                    int mis = rd.nextInt(9658);
                    int w = Q10_a(mis);
                    int[] arrW = {132, -564, 987, 456, -12, 45, 65, 877, 542};
                    bool = Q10_b(arrW);
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

    //O(n^2)
    private static boolean Q10_c(int[] arrWA, int[] arrWB) {

        if (!Q10_b(arrWA) || !Q10_b(arrWB))
            return false;

        for (int i = 0; i < arrWA.length; i++) {
            boolean bool = false;
            for (int j = 0; j < arrWB.length; j++) {
                if (Q10_a(arrWA[i]) == Q10_a(arrWB[j])) {
                    bool = true;
                }
            }
            if (!bool)
                return false;
        }
        return true;
    }

    //O(n^2)
    private static boolean Q10_b(int[] arrW) {

        for (int i = 0; i < arrW.length; i++) {
            for (int j = 0; j < arrW.length; j++) {
                if (Q10_a(arrW[i]) == Q10_a(arrW[j]) && i != j)
                    return false;
            }
        }
        return true;
    }


    private static int Q10_a(int mis) {
        int sumDigit = 0;
        while (mis != 0) {
            sumDigit += mis % 10;
            mis /= 10;
        }
        return sumDigit;
    }

    private static boolean Q4_a(String str) {
        if (str.length() < 8)
            return false;
        if (str.charAt(0) < 'A' || str.charAt(0) > 'Z')
            return false;
        if (str.charAt(str.length() - 1) < '0' || str.charAt(str.length() - 1) > '9')
            return false;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1))
                return false;
        }
        return true;

    }

    private static void Q5() {

        int num = in.nextInt();
        int prev = -1;
        while (num != 0) {
            int rand = rd.nextInt(10, 100);
            System.out.println(rand);
            if (rand > prev && (num - 1) <= 99 - rand) {
                num--;
                prev = rand;
                System.out.printf(rand + ", ");
            }
        }
        System.out.println();
    }

    private static int Q9(int[] arr, int num) {


        int cntBlock = 0;
        int countSeq = 1;

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                countSeq++;
            } else if (countSeq >= num) {
                cntBlock++;
                countSeq = 1;
            }

        }

        return (arr[arr.length - 1] != arr[arr.length - 2] && num == 1) ? cntBlock + 1 : cntBlock;
    }

    private static int Q9_v2(int[] arr, int num) {


        int cntBlock = 0;
        int countSeq = 1;

        for (int i = 0; i < arr.length; ) {
            int j = i + 1;
            for (; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    countSeq++;
                else
                    break;
            }
            if (countSeq >= num) {
                countSeq = 1;
                cntBlock++;
            }
            i = j;

        }


        return cntBlock;
    }


    public static boolean what(String s1, String s2) {
        while (true) {
            if (s1.length() == 0)
                return true;
            if (s2.length() == 0)
                return false;
            if (s1.charAt(0) == s2.charAt(0)) {
                s1 = s1.substring(1);
                s2 = s2.substring(1);
            } else
                s2 = s2.substring(1);
        }
    }
}
