package com.company;

import java.util.Random;

public abstract class Human {
    private boolean sex = false;
    private String name;
    private String lastname;
    private float height;
    private float weight;

    public Human(boolean sex, String name, String lastname, float height, float weight) {
        this.sex = sex;
        this.name = name;
        this.lastname = lastname;
        this.height = height;
        this.weight = weight;
    }

    public boolean isSex() {
        return sex;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        if (this.sex)
            return "Male{" +
                    "Name='" + name + '\'' +
                    ", Surname='" + lastname + '\'' +
                    ", Height=" + height +
                    ", Weight=" + weight +
                    '}';
        else
            return "Female{" +
                    "Name='" + name + '\'' +
                    ", Surname='" + lastname + '\'' +
                    ", Height=" + height +
                    ", Weight=" + weight +
                    '}';
    }

    boolean speak(Human secondHuman) {
        if (this instanceof Female && secondHuman instanceof Female) {
            System.out.println(this.getName() + " talk with " + secondHuman.getName());
            return true;
        }
        if (this instanceof Female && secondHuman instanceof Male) {
            System.out.println(this.getName() + " talk with " + secondHuman.getName());
            return true;
        }
        if (this instanceof Male && secondHuman instanceof Female) {
            System.out.println(this.getName() + " talk with " + secondHuman.getName());
            return true;
        }
        if (this instanceof Male && secondHuman instanceof Male) {
            Random randomChance = new Random();
            if (randomChance.nextInt(10) < 5) {
                {
                    System.out.println(this.getName() + " talk with " + secondHuman.getName());
                    return true;
                }
            }
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    boolean beInSociety(Human secondHuman) {
        Random randomChance = new Random();
        if (this instanceof Female && secondHuman instanceof Female) {
            if (randomChance.nextInt(100) < 5) {
                System.out.println(this.getName() + " can be with " + secondHuman.getName() + " at room.");
                return true;
            }
        } else if (this instanceof Female && secondHuman instanceof Male) {
            if (randomChance.nextInt(100) > 30) {
                System.out.println(this.getName() + " can be with " + secondHuman.getName() + " at room.");
                return true;
            }
        } else if (this instanceof Male && secondHuman instanceof Female) {
            if (randomChance.nextInt(100) > 30) {
                {
                    System.out.println(this.getName() + " can be with " + secondHuman.getName() + " at room.");
                    return true;
                }
            }
        } else if (this instanceof Male && secondHuman instanceof Male) {
            if (randomChance.nextInt(100) < 5.6) {
                {
                    System.out.println(this.getName() + " can be with " + secondHuman.getName() + " at room.");
                    return true;
                }
            }
        }
        System.out.println("Врядли " + this.getName() + " would like to be at room with " + secondHuman.getName());
        return false;
    }

    boolean spendTimeTogether(Human secondHuman) {
        float differenceHeight;
        Random randomChance = new Random();
        differenceHeight = this.height - this.height * 10 / 100;
        if (differenceHeight > secondHuman.height) {
            if (randomChance.nextInt(100) > 15) {
                System.out.println(this.getName() + " do not mind to meet with " + secondHuman.getName());
                return true;
            }
        }
        if (differenceHeight < secondHuman.height) {
            if (randomChance.nextInt(100) > 5) {
                System.out.println(this.getName() + " do not mind to meet with " + secondHuman.getName());
                return true;
            }
        }
        System.out.println(this.getName() + " do not fit for " + secondHuman.getName() + " by horoscope.");
        return false;
    }

    Human beInaRelationship(Human secondHuman) {
        if (beInSociety(secondHuman) && speak(secondHuman) && spendTimeTogether(secondHuman)) {
            if (this.isSex() == secondHuman.isSex()) {
                System.out.println("They have same sex.....");
                return null;
            } else {
                System.out.println("Relations between " + this.getName() + " и " + secondHuman.getName() + " led to the: ");
                if (this.isSex()) {
                    return ((Female) secondHuman).giveBirth((Male) this);
                } else {
                    return ((Female) this).giveBirth((Male) secondHuman);
                }
            }
        }
        System.out.println("Sorry....");
        return null;
    }
}
