package com.domain.lesson7.animals.farm;

public class Cow extends FarmAnimal {
    public Cow(String name) {
        this.setName(name);
        this.setWeight(100);
        this.setSpeed(4);
        this.setHealth(50);
        this.setResources(8);
        setInitialHealth();
    }
}
