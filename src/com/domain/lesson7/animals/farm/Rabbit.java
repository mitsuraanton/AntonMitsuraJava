package com.domain.lesson7.animals.farm;

public class Rabbit extends FarmAnimal {
    public Rabbit(String name) {
        this.setName(name);
        this.setWeight(4);
        this.setSpeed(35);
        this.setHealth(9);
        this.setResources(0);
        setInitialHealth();
    }
}
