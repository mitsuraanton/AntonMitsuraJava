package com.domain.lesson7.animals.wild;

import com.domain.lesson7.animals.Animal;

abstract public class WildAnimal extends Animal {
    // У диких животных есть имя, вес, скорость и сила.
    private int strength;
    private int wasKickedAway = 0;

    public int getKickedAwayNumber() {
        return wasKickedAway;
    }

    public void increaseKickedAwayNumberByOne(){
        this.wasKickedAway ++;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
