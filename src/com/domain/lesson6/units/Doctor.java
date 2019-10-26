package com.domain.lesson6.units;

public class Doctor extends BattleUnit {
    public Doctor(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public void attack(Unit friend) {
        if (this.health > 0) {
            friend.health += this.attackScore;
            System.out.println("Доктор подлечил " + friend.getName());
        } else
            System.out.println("Доктор мертв");
    }

    @Override
    public void rest() {
        if (this.health > 0) {
            System.out.println("Доктор отдыхает");
        } else
            System.out.println("Доктор мертв");
    }
}