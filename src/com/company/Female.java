package com.company;

import java.util.Random;
import java.util.Scanner;

public class Female extends Human {
    public Female(boolean sex, String name, String lastname, float height, float weight) {
        super(false, name, lastname, height, weight);
    }

    public Human giveBirth(Male male) {
        Human child;
        Random randomChance = new Random();
        Scanner scanner = new Scanner(System.in);
        float childweight, childheight;
        String childLastName;
        int chance = randomChance.nextInt(2);
        if (chance == 1) {
            System.out.println("Sex-men,Enter name");
            String name = scanner.next();
            childLastName = male.getLastname();
            childweight = ((float) (male.getWeight() + 0.1 * (male.getWeight() - this.getHeight())));
            childheight = ((float) (male.getHeight() + 0.1 * (male.getHeight() - this.getHeight())));
            child = new Male(true, name, childLastName, childheight, childweight);
        } else {
            System.out.println("Sex-women,Enter name");
            String name = scanner.next();
            childLastName = male.getLastname();
            childweight = ((float) (this.getWeight() + 0.1 * (this.getWeight() - male.getHeight())));
            childheight = ((float) (this.getHeight() + 0.1 * (this.getHeight() - male.getHeight())));
            child = new Female(false, name, childLastName, childheight, childweight);
        }
        return child;
    }
}
