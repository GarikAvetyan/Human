package CodeSchool;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        //1
        System.out.print("Array Length: ");
        int arrayLength = sc.nextInt();

        Human[] humans = new Human[arrayLength];

        //2
        for (int i = 0; i < humans.length; i++) {
            humans[i] = new Human();

            humans[i].setName("Name_" + i);
            humans[i].setSurname("Surname_" + i);

            int age = rn.nextInt(0, 101);
            humans[i].setAge(age);

            boolean gender = rn.nextBoolean();
            humans[i].setGender(gender);

            //3
            System.out.println(humans[i].toString());
        }

        //Sort humans by age
        bubbleSort(humans);

        //4
        System.out.println("\nFrom small to large by age:");
        for (int i = 0; i < humans.length; i++) {
            System.out.println(humans[i].toString());
        }

        //5
        System.out.println("\nFrom large to small by age:");
        for (int i = humans.length - 1; i >= 0; i--) {
            System.out.println(humans[i].toString());
        }

        //6.Middle age
        System.out.println("\nMiddle age:");
        System.out.println(humans[humans.length / 2].toString());

        //7.Youngest age
        System.out.println("\nAt the youngest age");
        System.out.println(humans[0].getSurname() + ", age=" + humans[0].getAge());

        //8.Oldest age
        System.out.println("\nThe oldest age");
        System.out.println(humans[humans.length - 1].getSurname() + ", age=" + humans[humans.length - 1].getAge());

        //9.Longest Name
        int maxLengthName = humans[0].getName().length();
        int index = 0;
        for (int i = 1; i < humans.length; i++) {
            if (humans[i].getName().length() >= maxLengthName) {
                maxLengthName = humans[i].getName().length();
                index = i;
            }
        }

        System.out.println("\nWith the Longest name:");
        for (int i = 0; i < humans.length; i++) {
            if (humans[index].getName().length() == humans[i].getName().length()) {
                System.out.println(humans[i]);
            }
        }


        //10.Smallest Surname
        int minLengthSurname = humans[0].getSurname().length();
        int index1 = 0;
        for (int i = 1; i < humans.length; i++) {
            if (humans[i].getSurname().length() <= maxLengthName) {
                minLengthSurname = humans[i].getSurname().length();
                index1 = i;
            }
        }

        System.out.println("\nWith the Smallest surname:");
        for (int i = 0; i < humans.length; i++) {
            if (humans[index1].getSurname().length() == humans[i].getSurname().length()) {
                System.out.println(humans[i]);
            }
        }

        //11.Count mens and womens
        int countMen = 0;
        int countWomen = 0;

        for (int i = 0; i < humans.length; i++) {
            switch (humans[i].getGender()) {
                case "Male":
                    countMen++;
                    break;
                case "Female":
                    countWomen++;
                    break;
            }
        }

        System.out.println("\nCountMen: " + countMen + "\n" + "CountWomen: " + countWomen + "\n");


        //12.Recurring Age and Most Repetitive
        System.out.println("Recurring Age:");

        int mostRepetitive = 1;
        int indexmMostRepetitive = -1;

        //Recurring age
        for (int i = 0; i < humans.length; i++) {
            int countRecurringAge = 0;
            for (int j = i; j < humans.length; j++) {
                if (humans[i].getAge() == humans[j].getAge()) {
                    countRecurringAge++;
                    System.out.println(humans[j].toString());
                }
            }

            if (countRecurringAge > mostRepetitive) {
                mostRepetitive = countRecurringAge;
                indexmMostRepetitive = i;
            }

            System.out.println("Count Recurring Age: " + countRecurringAge + "\n");
        }

        //13.Most repetitive age
        if (indexmMostRepetitive != -1) {
            System.out.println("\nMost repetitive age: " + humans[indexmMostRepetitive].getAge() + ", Count=" + mostRepetitive);
        } else {
            System.out.println("\nAll repeated once...");
        }


        //14.Count of retirees
        int countOfRetirees = 0;
        System.out.println("\nRetirees:");
        for (int i = 0; i < humans.length; i++) {
            if (humans[i].getAge() >= 65) {
                System.out.println(humans[i].toString());
                countOfRetirees++;
            }
        }
        System.out.println("Count of retirees:" + countOfRetirees);

        //15.Nursing Home
        NursingHome nursingHome = new NursingHome(humans);
        nursingHome.toStringReturees();

    }


    public static void bubbleSort(Human[] humans) {

        for (int i = 0; i < humans.length - 1; i++) {
            for (int j = 0; j < humans.length - i - 1; j++) {
                if (humans[j].getAge() > humans[j + 1].getAge()) {
                    Human temp = humans[j];
                    humans[j] = humans[j + 1];
                    humans[j + 1] = temp;
                }
            }
        }

    }

}
