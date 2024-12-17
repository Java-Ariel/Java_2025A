package Day03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Mahat_Aviv_2021A {

    public static String getCodeColor(String color) {

        switch (color) {

            case "Red":
                return "\u001B[31m";
            case "Yellow":
                return "\u001B[33m";
            case "Cyan":
                return "\u001B[36m";
            case "Blue":
                return "\u001B[34m";
            case "Black":
                return "\u001B[30m";
            case "Purple":
                return "\u001B[35m";
            case "Green":
                return "\u001B[32m";
            default:
                return "\u001B[0m";
        }


    }

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
                    break;
                case 2:
                    Box b = new Box("Red");
                    b.getColor();
                    String[] colors = {"Red", "Yellow", "Cyan", "Blue", "Black", "Purple", "Green"};

                    System.out.println(b);
                    Box[] boxes = new Box[5];
                    for (int i = 0; i < boxes.length; i++) {
                        boxes[i] = new Box(colors[rd.nextInt(colors.length)], rd.nextInt(5, 20), rd.nextInt(5, 20), rd.nextInt(5, 20));
                    }
                    System.out.println(Arrays.toString(boxes));

                    String color = Box.smallBox(boxes);
                    System.out.println(color);


                    break;
                case 3:
                    break;
                case 4:
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
}

class Box {

    private String color;
    private int length;
    private int width;
    private int height;


    public Box(String color, int length, int width, int height) {
        this.color = color;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Box(String color) {
        this.color = color;
        this.length = 10;
        this.width = 10;
        this.height = 10;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int getCapacity() {
        return width * length * height;
    }

    public static String smallBox(Box[] boxes) {
        int smallBox = Integer.MAX_VALUE;
        Box box = null;

        for (int i = 0; i < boxes.length; i++) {
            int cap = boxes[i].getCapacity();

            if (smallBox > cap) {
                box = boxes[i];
                smallBox = cap;
            }
        }
        return box.getColor();
    }

    @Override
    public String toString() {
        String box = "Box{" +
                "color='" + color + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                '}' + '\n' + Mahat_Aviv_2021A.getCodeColor(color);
        for (int i = 0; i < width; i++) {
            box += "--";
        }
        box += "\n";
        for (int i = 0; i < height; i++) {
            box += "|";
            for (int j = 0; j < width * 2 - 2; j++) {
                box += " ";
            }
            box += "|";
            box += "\n";
        }
        for (int i = 0; i < width; i++) {
            box += "--";
        }
        box += "\n" + "\u001B[0m";
        return box;

    }
}

class Battery {

    private String manufacturer;
    private char size;
    private double volt;
    private boolean isNormal;


    public Battery(String manufacturer, char size, double volt, boolean isNormal) {
        this.manufacturer = manufacturer;
        this.size = size;
        this.volt = volt;
        this.isNormal = isNormal;
    }

    public Battery(char size, double volt) {
        this.size = size;
        this.volt = volt;
        this.manufacturer = "Duracell";
        this.isNormal = true;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public double getVolt() {
        return volt;
    }

    public void setVolt(double volt) {
        this.volt = volt;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }
}

class BatteryPack {

    private double price;
    private Battery[] batteries = new Battery[12];

    public static void checkPrice(BatteryPack batteryPack, double sum) {
        if (batteryPack.getPrice() > sum)
            System.out.println("Not Ok -> " + (batteryPack.getPrice() - sum));
        else if (batteryPack.getPrice() < sum)
            System.out.println("Ok -> " + (sum - batteryPack.getPrice()));
        else
            System.out.println("Ok");
    }

    public boolean isEnough(double v) {

        double sumVolt = 0;
        for (int i = 0; i < batteries.length; i++) {
            if (batteries[i].isNormal())
                sumVolt += batteries[i].getVolt();
        }
        return sumVolt >= v;
    }

    public Battery[] getBatteries() {
        return batteries;
    }

    public void setBatteries(Battery[] batteries) {
        this.batteries = batteries;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Driver {

    private String name;
    private int year;
    private int tests;
    private String id;


    public static String[] lessTest(Driver[] drivers, int num) {

        String[] temp = new String[drivers.length];
        int count = 0;

        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i].tests < num)
                temp[count++] = drivers[i].name;
        }

        String[] names = new String[count];

        for (int i = 0; i < count; i++) {
            names[i] = temp[i];
        }

        return names;

    }

}

class Task {
    private String title;
    private int min;
    private int priority;
    private boolean isComplete;


    public Task(String title, int min, int priority, boolean isComplete) {
        this.title = title;
        this.min = min;
        this.priority = priority;
        this.isComplete = isComplete;
    }


    public int doIt(int num) {
        if (min < num) {
            min = 0;
            isComplete = true;
            return num - min;
        }

        isComplete = false;
        min = min - num;
        return 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}

class TaskManager {

    private Task[] tasks = new Task[100];
    private int numOfTasks;


    public TaskManager(int numOfTasks) {
        this.numOfTasks = numOfTasks;
    }


    public boolean assTask(Task t) {
        if (numOfTasks < tasks.length) {
            for (int i = 0; i < tasks.length; i++) {
                if (tasks[i] == null) {
                    tasks[i] = t;
                    numOfTasks++;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < tasks.length; i++) {
                if (!tasks[i].isComplete()) {
                    tasks[i] = t;
                    numOfTasks++;
                    return true;
                }
            }

        }

        return false;

    }


    public int importantTask() {

        int index = -1;
        int priorityLevel = 0;

        for (int i = 0; i < tasks.length; i++) {
            if (!tasks[i].isComplete()) {

                if (priorityLevel <= tasks[i].getPriority()) {
                    index = i;
                    priorityLevel = tasks[i].getPriority();
                }
            }
        }
        return index;

    }

    public void work(int num){

        int taskIndex;
        while (num>0 && (taskIndex=importantTask())!=-1){
            num=tasks[taskIndex].doIt(num);
        }
    }

    public Task[] getTasks() {
        return tasks;
    }

    public void setTasks(Task[] tasks) {
        this.tasks = tasks;
    }

    public int getNumOfTasks() {
        return numOfTasks;
    }

    public void setNumOfTasks(int numOfTasks) {
        this.numOfTasks = numOfTasks;
    }
}
