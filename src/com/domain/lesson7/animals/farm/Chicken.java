package com.domain.lesson7.animals.farm;

public class Chicken extends FarmAnimal {
    public Chicken(String name) {
        this.setName(name);
        this.setWeight(6);
        this.setSpeed(5);
        this.setHealth(7);
        this.setResources(2);
        setInitialHealth();
    }
}
