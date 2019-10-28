package com.domain.lesson7;

import com.domain.lesson7.animals.farm.*;
import com.domain.lesson7.animals.wild.Bear;
import com.domain.lesson7.animals.wild.Fox;
import com.domain.lesson7.animals.wild.WildAnimal;
import com.domain.lesson7.animals.wild.Wolf;

import java.util.ArrayList;
import java.util.Random;

public class FarmAdventure {
    public static void main(String[] args) {
        Farmer farmer = new Farmer("Реднек");
        ArrayList<FarmAnimal> farmAnimals = new ArrayList();
        farmAnimals.add(new Cat("Барсик"));
        farmAnimals.add(new Chicken("Ряба"));
        farmAnimals.add(new Cow("Буренка"));
        farmAnimals.add(new Rabbit("Бакс Банни"));
        farmAnimals.add(new Cat("Бесстыжий"));
        farmAnimals.add(new Chicken("Подбитое крыло"));
        farmAnimals.add(new Cow("Безрогая"));
        farmAnimals.add(new Rabbit("Шустрый"));

        ArrayList<WildAnimal> wildAnimals = new ArrayList();
        wildAnimals.add(new Bear("Потапыч"));
        wildAnimals.add(new Fox("Патрикеевна"));
        wildAnimals.add(new Wolf("Матерый"));
        wildAnimals.add(new Bear("Михалыч"));
        wildAnimals.add(new Fox("Рыжая бестия"));
        wildAnimals.add(new Wolf("Лютый"));

        while (true){
            if (farmerBreakfast(farmer)) break;
            if (wildAnimalAttack(farmAnimals, wildAnimals)) break;
        }
    }

    private static boolean wildAnimalAttack(ArrayList<FarmAnimal> farmAnimals, ArrayList<WildAnimal> wildAnimals) {
        Random random = new Random();
        WildAnimal curPredator = wildAnimals.get(random.nextInt(wildAnimals.size()));
        FarmAnimal curVictim = farmAnimals.get(random.nextInt(farmAnimals.size()));
        boolean farmerKickedAwayWildAnimal = random.nextBoolean();
        System.out.println("Дикий зверь " + curPredator.getClass().getSimpleName() + " по имени " + curPredator.getName() + " пришел на ферму и хочет догнать домашнее животное "
                + curVictim.getClass().getSimpleName() + " по имени " + curVictim.getName());

        if (farmerKickedAwayWildAnimal){
            System.out.println("Фермер прогнал " + curPredator.getName());
            curPredator.increaseKickedAwayNumberByOne();
            if (curPredator.getKickedAwayNumber() == 3){
                wildAnimals.remove(curPredator);
                if (wildAnimals.size() == 0){
                    System.out.println("Фермер прогнал всех диких животных и победил в игре. Конец!");
                    return true;
                }
            }

        } else{
            if (curPredator.getSpeed() > curVictim.getSpeed()){
                curVictim.setHealth(curVictim.getHealth() - curPredator.getStrength());
                System.out.println(curPredator.getName() + " делает кусь " + curVictim.getName());
                if (curVictim.getHealth() <= 0) {
                    System.out.println(curVictim.getName() + " стал добычей " + curPredator.getName() + " и пал смертью храбрых");
                    farmAnimals.remove(curVictim);
                    if (farmAnimals.size() == 0){
                        System.out.println("Дикие животные съели всех домашних животных и победили в игре. Конец!");
                        return true;
                    }
                } else{
                    System.out.println(curVictim.getName() + " отделался легкими царапинами");
                }
            } else{
                System.out.println(curPredator.getName() + " не смог догнать " + curVictim.getName() + ". Надо подкачаться, он так долго не протянет");
            }
        }
        return false;
    }

    private static boolean farmerBreakfast(Farmer farmer) {
        System.out.println("==========================================================================================");
        System.out.println("Началось в деревне утро!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Перед завтраком у фермера было " + farmer.getResources() + " единиц ресурсов");
        System.out.println("Он был голодный и хотел съесть 3 единицы ресурсов");
        farmer.setResources(farmer.getResources() - 3);
        if (farmer.getResources() > 0) System.out.println("Фермер сытно позавтракал и готов созидать. У него осталось " + farmer.getResources() + " единиц ресурсов");
        else{
            System.out.println("Фермер был недостаточно расторопен и помер с голода");
            return true;
        }
        return false;
    }
}
