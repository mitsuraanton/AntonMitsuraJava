package com.domain.lesson7.animals.farm;

public class Cat extends FarmAnimal {
    public Cat(String name) {
        this.setName(name);
        this.setWeight(5);
        this.setSpeed(30);
        this.setHealth(10);
        this.setResources(0);
        setInitialHealth();
    }
}
