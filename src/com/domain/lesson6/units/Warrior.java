package com.domain.lesson6.units;

public class Warrior extends BattleUnit {
    public Warrior(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    // Дома сделать реализацию атаки для каждого типа юнитов и сделать все необходимые проверки в сеттерах
    // Юниты с нулевым здоровьем не могут перемещаться и атаковать!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // Скорость не может быть ноль, проверки добавлять.
    // Прописываем проверки и методы атаки!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //
    @Override
    public void attack(Unit enemy) {
        if (this.health > 0) {
            if (enemy.health - this.attackScore >= 0)
                enemy.health -= this.attackScore;
            else
                enemy.health = 0;
            System.out.println("Воин атаковал " + enemy.getName());
        } else
            System.out.println("Воин мертв");
    }

    @Override
    public void rest() {
        if (this.health > 0) {
            System.out.println("Воин отдыхает");
        } else
            System.out.println("Воин мертв");
    }
}
