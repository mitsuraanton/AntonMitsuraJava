package com.domain.lesson6.units;

import java.util.Random;

// В абстрактном классе допустимо наличие метов с реализацией и без реализацией
abstract public class BattleUnit extends Unit implements AttackAble{

    protected int attackScore;

    public int getAttackScore() {
        return attackScore;
    }

    public void setAttackScore(int attackScore) {
        if (attackScore >= 0){
            this.attackScore = attackScore;
        } else {
            System.out.println("Устанавливаемый уровень атаки должен быть больше нуля");
        }
    }

    public BattleUnit(String name, int speed, int health, int attackScore) {
        super(name, speed); // вызов конструктора родителя
        setHealth(health);
        setAttackScore(attackScore);
    }

    @Override
    public void escapeBattleField() {
        System.out.println("Юнит" + this.name  + "сбежал с поля боя");
    }

    public static BattleUnit createUnit(String type){
        Random random = new Random();
        switch (type){
            case "Warrior":
                return new Warrior("Warrior" + random.nextInt(100000), random.nextInt(11), random.nextInt(11), random.nextInt(11));
            case "Knight":
                return new Knight("Warrior" + random.nextInt(100000), random.nextInt(11), random.nextInt(11), random.nextInt(11));
            case "Doctor":
                return new Doctor("Warrior" + random.nextInt(100000), random.nextInt(11), random.nextInt(11), random.nextInt(11));
            default:
                return null;
        }
    }
}
