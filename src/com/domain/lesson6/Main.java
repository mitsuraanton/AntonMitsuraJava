package com.domain.lesson6;

import com.domain.lesson6.units.BattleUnit;
import com.domain.lesson6.units.Doctor;
import com.domain.lesson6.units.Knight;
import com.domain.lesson6.units.Warrior;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите тип персонажа");
        String userChoice = in.nextLine();
        // warrior knight doctor
        BattleUnit battleUnit = null;
        if ("warrior".equals(userChoice)){
            battleUnit = new Warrior("Воин", 3, 20, 15);
        } else if ("knight".equals(userChoice)){
            battleUnit = new Knight("Рыцарь", 4, 22, 18);
        } else if ("doctor".equals(userChoice)){
            battleUnit = new Doctor("Доктор", 2, 40, 5);
        }

        battleUnit.run();
        battleUnit.attack(new Knight("5",5,5, 5));
        // Инкапсуляция -- скрытие деталий реализации, реализована через модификаторы доступа
        // Наследование -- расширение функционала родителя
        // Абстракция -- интерфейсы и абстрактные классы
        // Полиморфизм наследования -- работа через общий тип данных, использование методов с одинаковым названием, но разной реализацией у разных классов
        // Полиморфизм перегруза методов -- одинаковое имя метода, но разное количество параметров
    }
}
