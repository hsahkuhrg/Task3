package com.company;

import java.util.Scanner;

public class Main {
    public static Human human1;
    public static Human human2;

    public static void main(String[] args) {
        human1 = values(human1);
        human2 = values(human2);
        Human human3 = human1.beInaRelationship(human2);
        if (human3 != null) {
            System.out.println(human3.toString());
        }

    }
    private static Human values(Human human) {
        Male male;
        Female female;
        System.out.println("Enter sex (M/W): ");
        String gender = new Scanner(System.in).nextLine();
        if (gender.isEmpty()) {
            System.out.println("You do not enter sex!");
            values(human);
        }
        System.out.println("Enter name: ");
        String name = (new Scanner(System.in).nextLine());
        System.out.println("Enter secondname: ");
        String lastname = (new Scanner(System.in).nextLine());
        System.out.println("Enter age: ");
        float height = (new Scanner(System.in).nextFloat());
        System.out.println("Enter weight: ");
        float weight = (new Scanner(System.in).nextFloat());

        if (gender.equalsIgnoreCase("m")) {
            male = new Male(true, name, lastname, height, weight);
            return male;
        } else if (gender.equalsIgnoreCase("w")) {

            female = new Female(false, name, lastname, height, weight);
            return female;
        } else
            values(human);
        return human;
    }
}
