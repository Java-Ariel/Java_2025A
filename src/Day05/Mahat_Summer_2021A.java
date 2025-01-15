package Day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mahat_Summer_2021A {

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
                    int[] numbers = new int[35];
                    int sum = 0;
                    for (int i = 0; i < 35; i++) {
                        numbers[i] = in.nextInt();
                        sum += numbers[i];
                    }
                    double avg = (double) sum / 35;
                    System.out.println("Avg -> " + avg);

                    for (int i = 0; i < 35; i++) {
                        if (numbers[i] >= avg)
                            System.out.println(numbers[i]);
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:

                    int[] arr = new int[]{1, 3, 6, 11, 10, 9, 4, 2, 0};
                    int index = Q4(arr);
                    System.out.println(index);

                    arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
                    index = Q4(arr);
                    System.out.println(index);

                    arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
                    index = Q4(arr);
                    System.out.println(index);

                    arr = new int[]{1, 3, 2, 4, 6, 5, 9, 7};
                    index = Q4(arr);
                    System.out.println(index);

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
                    int number = 163458;
                    boolean bool = Q9_a(number);
                    int[] numberArray = new int[]{163458, 1, 11, 1634589, 2, 163789, 12, 22, 569, 4785, 1234, 6431};
                    index = Q9_b(numberArray);
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

    static boolean isCopyK(String s1, String s2) {

        if (s2.length() > s1.length() || s1.length() % s2.length() != 0)
            return false;

        for (int i = 0; i < s1.length(); i += s2.length()) {
            // "ABCDABCDABCD"
            // iter i=0 s1.substring = ABCD.equals(s2) -> ABCD.equals(ABCD)
            // iter i=4 s1.substring = ABCD.equals(s2) -> ABCD.equals(ABCD)
            // iter i=8 s1.substring = ABCD.equals(s2) -> ABCD.equals(ABCD)
            if (!s1.substring(i, i + s2.length()).equals(s2))
                return false;
        }

        return true;
    }

    private static int sumDigit(int number) {
        int sumDigit = 0;

        while (number != 0) {
            sumDigit += number % 10;
            number /= 10;
        }
        return sumDigit;
    }

    private static int Q9_b_v2(int[] numberArray) {

        int minSumDigit = 0;
        int index = -1;

        for (int i = 0; i < numberArray.length; i++) {
            if (Q9_a(numberArray[i])) {
                index = i;
                minSumDigit = sumDigit(numberArray[i]);
                break;
            }
        }
        if (index == -1)
            return -1;

        for (int i = 0; i < numberArray.length; i++) {
            if (Q9_a(numberArray[i])) {
                int sumDigit = sumDigit(numberArray[i]);
                if (sumDigit < minSumDigit) {
                    minSumDigit = sumDigit;
                    index = i;
                }
            }
        }
        return index;

    }


    private static int Q9_b(int[] numberArray) {

        int minSumDigit = -1;
        int index = -1;
        for (int i = 0; i < numberArray.length; i++) {
            if (Q9_a(numberArray[i])) {
                int sumDigit = sumDigit(numberArray[i]);

                if (minSumDigit == -1) {
                    minSumDigit = sumDigit;
                    index = i;
                }

                if (sumDigit < minSumDigit) {
                    minSumDigit = sumDigit;
                    index = i;
                }

            }


        }
        return index;

    }

    private static boolean Q9_a(int number) {
        if (number < 10)
            return true;
        if (number < 100) {
            int digit1 = number % 10;
            int digit2 = number / 10;
            return (digit1 % 2 != digit2 % 2);

//            return ((number % 10) % 2 != (number / 10) % 2);
        }

        int prevDigit = number % 10;
        number /= 10;
        while (number > 0) {
            int nextDigit = number % 10;
            if (prevDigit % 2 == nextDigit % 2)
                return false;
            prevDigit = nextDigit;
            number /= 10;
        }

        return true;
    }

    private static int Q4(int[] arr) {
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                break;

        }
        int mid = i;

        for (; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1])
                return -1;
        }

        return mid;
    }
}

class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public boolean before(Time other) {
        return hour * 60 + minute < other.hour * 60 + other.minute;
//        return (hour < other.hour) ? true : (hour > other.hour) ? false : minute < other.minute ? true : false;
    }

    public Time addFiveMinutes() {
        int minute = this.minute;
        int hour = this.hour;
        if (minute + 5 >= 60) {
            if (hour + 1 >= 24)
                hour = 0;
            else
                hour++;
            minute = (minute + 5) % 60;
        } else
            minute += 5;

        return new Time(hour, minute);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}

class Message {


    private String sender;
    private int subject;
    private String content;
    private Time receivingTime;
    private boolean hasAttachment;

    public Message(String sender, int subject, String content, Time receivingTime, boolean hasAttachment) {
        this.sender = sender;
        this.subject = subject;
        this.content = content;
        this.receivingTime = receivingTime;
        this.hasAttachment = hasAttachment;
    }

    public Message reply(String text) {
        return new Message("support@uni.ac.il", -subject, content + " " + text, receivingTime.addFiveMinutes(), false);
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getSubject() {
        return subject;
    }

    public void setSubject(int subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Time getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Time receivingTime) {
        this.receivingTime = receivingTime;
    }

    public boolean isHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }
}

class Mailbox {

    private Message[] inbox;
    private int noOfMes;


    public Mailbox(int num) {
        inbox = new Message[num];
        noOfMes = 0;
    }

    //  14:10       19:05
    public int HowManyBetweenTimes(Time first, Time second) {
        int counterMes = 0;
        for (int i = 0; i < inbox.length; i++) {
            if (!inbox[i].getReceivingTime().before(first) && inbox[i].getReceivingTime().before(second)) {
                counterMes++;
            }
        }
        return counterMes;
    }

    public int mostPopularSubject() {

        int[] countSubject = new int[12];

        for (int i = 0; i < inbox.length; i++) {
            countSubject[Math.abs(inbox[i].getSubject()) - 1]++;
        }
        int maxValueIndex = 0;
        for (int i = 0; i < countSubject.length; i++) {
            if (countSubject[i] > countSubject[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        return maxValueIndex + 1;
    }
}