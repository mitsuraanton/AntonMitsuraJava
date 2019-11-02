package com.domain.lesson7.animals.farm;

import com.domain.lesson7.animals.Animal;

abstract public class FarmAnimal extends Animal {
    // У домашних животных есть имя, вес, скорость, здоровье и ресурсы.
    private int health;
    private int resources;
    protected int initialHealth;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getResources() {
        return resources;
    }

    public void setResources(int resources) {
        this.resources = resources;
    }

    public void setInitialHealth() {
        this.initialHealth = this.health;
    }

    public int getInitialHealth() {
        return initialHealth;
    }
}
