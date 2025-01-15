package Day06;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Summer_2021B {

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
        boolean bool;
        while (true) {
            System.out.println("Enter q number");
            int num = in.nextInt();
            switch (num) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    String str = "Java is a good language";
                    char ch = 'a';
                    Q3(str, ch);
                    Q3_v2(str, ch);
                    break;
                case 4:
                    int a[] = {1, 9, 2, 8, 4, 7, 7, 4, 12};
                    bool = Q4_a(a);
                    int min = Q4_b(a);
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
                    int[] arr = {23, 30, 24, 29, 25, 28, 26, 31, 27};
                    bool = Q9_v2(arr);
                    System.out.println(bool);

                    bool = Q9(arr);
                    System.out.println(Arrays.toString(arr));
                    System.out.println(bool);


                    break;
                case 10:
                    break;
                case 11:
                    int mis = 9587;
                    int degNumber = Q11_a(mis);
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

    private static int Q11_a(int mis) {

        int eDigitSum = 0;
        int oDigitSum = 0;

        while (mis != 0) {
            int digit = mis % 10;
            if (digit % 2 == 0)
                eDigitSum += digit;
            else
                oDigitSum += digit;


            mis /= 10;
        }

        return eDigitSum - oDigitSum;
    }

    private static boolean Q11_b(int[] arr1, int[] arr2) {

        for (int i = 0; i < arr1.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr2.length; j++) {
                if (Q11_a(arr1[i]) == Q11_a(arr2[j]))
                    flag = true;
            }
            if (!flag)
                return false;
        }


        return true;
    }

    private static boolean Q11_c(int[] arr) {

        int[] arrWithDeg = new int[arr.length * 2];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int deg = Q11_a(arr[i]);
            if (deg < 0) {
                arrWithDeg[index] = arr[i];
                arrWithDeg[index + 1] = deg;
                index += 2;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int deg = Q11_a(arr[i]);
            if (deg == 0) {
                arrWithDeg[index] = arr[i];
                arrWithDeg[index + 1] = deg;
                index += 2;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int deg = Q11_a(arr[i]);
            if (deg > 0) {
                arrWithDeg[index] = arr[i];
                arrWithDeg[index + 1] = deg;
                index += 2;
            }
        }

        return true;
    }


    private static void printSubStringIndex_v2(String s, int index) {
        String newStr = "";
        for (int i = index; i < s.length(); i++) {
            newStr += s.charAt(i) + "";
        }
        System.out.println(newStr);
    }

    private static void printSubStringIndex(String s, int index) {
        for (int i = index; i < s.length(); i++) {
            System.out.printf(s.charAt(i) + "");

        }
        System.out.println();
    }

    private static void Q3(String str, char ch) {
        //"Java is a good language";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                printSubStringIndex(str, i);
        }
    }

    private static void Q3_v2(String str, char ch) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                System.out.println(str.substring(i));
        }
    }

    private static int Q4_b(int[] a) {
        int size = a.length;

        return Math.min(a[0], (size % 2 == 0) ? a[size - 1] : a[size - 2]);

    }

    private static boolean Q4_a(int[] a) {
        // method 1 even
        for (int i = 0; i < a.length - 2; i += 2) {
            if (a[i] > a[i + 2])
                return false;
        }

        // method 2 even
        for (int i = 2; i < a.length; i += 2) {
            if (a[i - 2] > a[i])
                return false;
        }

        // method 1 odd
        for (int i = 1; i < a.length - 2; i += 2) {
            if (a[i] < a[i + 2])
                return false;
        }
        // method 2 odd
        for (int i = 3; i < a.length; i += 2) {
            if (a[i - 2] < a[i])
                return false;
        }

        return true;


    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static boolean Q9(int[] arr) {

        sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1])
                return false;
        }
        return true;


    }

    private static int contains(int[] arr, int num) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                cnt++;
        }

        return cnt;
    }

    private static int min(int[] arr) {

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }

        return min;
    }

    private static boolean Q9_v2(int[] arr) {

        int minValue = min(arr);
        for (int i = 0; i < arr.length; i++) {
            if (contains(arr, minValue + i) != 1)
                return false;
        }

        return true;
    }

    static class Ceremony {

        public int[] songPoint;

        public Ceremony() {
            songPoint = new int[30];
        }

        public void doChoicesRandomness() {

            int song1, song2, song3;

            while ((song1 = rd.nextInt(0, 31)) != 0 &&
                    (song2 = rd.nextInt(0, 31)) != 0 &&
                    (song3 = rd.nextInt(0, 31)) != 0) {

                System.out.printf("%d,%d,%d\n", song1, song2, song3);
                songPoint[song1 - 1] += 5;
                songPoint[song2 - 1] += 3;
                songPoint[song3 - 1] += 1;

            }


        }

        public void doChoices() {

            int song1, song2, song3;


//            while (true) {
//                song1 = in.nextInt();
//                song2 = in.nextInt();
//                song3 = in.nextInt();
//                if (song1 == 0 && song2 == 0 && song3 == 0)
//                    break;
//
//                songPoint[song1 - 1] += 5;
//                songPoint[song2 - 1] += 3;
//                songPoint[song3 - 1] += 1;
//
//            }
            // 6,5,9
            // 11,1,7
            // 6,5,9
            // 1,3,10
            // 6,5,9
            // 9,5,6

            while ((song1 = in.nextInt()) != 0 &&
                    (song2 = in.nextInt()) != 0 &&
                    (song3 = in.nextInt()) != 0) {

                songPoint[song1 - 1] += 5;
                songPoint[song2 - 1] += 3;
                songPoint[song3 - 1] += 1;

            }

            //[8,0,3,0,6,10,1,0,2,1,5]

        }

        public int winner() {

            int maxIndex = 0;
            for (int i = 0; i < songPoint.length; i++) {
                if (songPoint[i] > songPoint[maxIndex])
                    maxIndex = i;
            }
            return maxIndex + 1;
        }
    }

    static class Main {
        public static void main(String[] args) {
            Ceremony c = new Ceremony();
            c.doChoicesRandomness();
            System.out.println(Arrays.toString(c.songPoint));
            System.out.println(c.winner());
        }
    }
}

class Teacher {

    public String teachId;
    public String name;
    public boolean deg;

    public Teacher(boolean deg, String name, String teachId) {
        this.deg = deg;
        this.name = name;
        this.teachId = teachId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "ID='" + teachId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

class School {
    public String nameM;
    public String nameSc;
    public Teacher[] teachers;

    public School(String nameM, String nameSc, Teacher[] teachers) {
        this.nameM = nameM;
        this.nameSc = nameSc;
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "School{" +
                "nameM='" + nameM + '\'' +
                ", nameSc='" + nameSc + '\'' +
                ", teachers=" + Arrays.toString(teachers) +
                '}';
    }
}

class AllSchools {

    public School[] schools;


    public AllSchools(School[] schools) {
        this.schools = schools;
    }

    public void q14_c(String teachId) {

        for (int i = 0; i < schools.length; i++) {
            School school = schools[i];
            Teacher[] teachers = school.teachers;
            for (int j = 0; j < teachers.length; j++) {
                Teacher teacher = teachers[j];
                if (teachId.equals(teacher.teachId)) {
                    System.out.println(school.nameSc);
                    break;
                }

            }
        }


    }

    public void q14_d() {
        int maxDeg=0;
        int degIndex=0;

        for (int i = 0; i < schools.length; i++) {
            School school = schools[i];
            Teacher[] teachers = school.teachers;
            int countDeg=0;
            for (int j = 0; j < teachers.length; j++) {
                Teacher teacher = teachers[j];
                if (teacher.deg)
                    countDeg++;
            }
            if(countDeg>maxDeg) {
                degIndex = i;
                maxDeg=countDeg;
            }
        }

        System.out.println(schools[degIndex].nameSc);
    }

    @Override
    public String toString() {
        return "AllSchools{" +
                "schools=" + Arrays.toString(schools) +
                '}';
    }
}

