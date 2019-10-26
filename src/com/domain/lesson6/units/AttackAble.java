package com.domain.lesson6.units;

// на основе интерфейса нельзя создать экземпляр. Все методы по-умолчанию публичные. Все методы - без реализации.
public interface AttackAble {
    void attack(Unit target);

    // метод с реализацией
    default void escapeBattleField(){
        System.out.println("Юнит сбежал с поля боя");
    }
}
