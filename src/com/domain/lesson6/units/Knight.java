package com.domain.lesson6.units;

public class Knight extends BattleUnit {
    public Knight(String name, int speed, int health, int attackScore) {
        super(name, speed, health, attackScore);
    }

    @Override
    public void attack(Unit enemy) {
        if (this.health > 0) {
            if (enemy.health - this.attackScore >= 0)
                enemy.health -= this.attackScore;
            else
                enemy.health = 0;
            System.out.println("Рыцарь атаковал " + enemy.getName());
        } else
            System.out.println("Рыцарь мертв");
    }

    @Override
    public void rest() {
        if (this.health > 0) {
            System.out.println("Рыцарь отдыхает");
        } else
            System.out.println("Рыцарь мертв");
    }
}
