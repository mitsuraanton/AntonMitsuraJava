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
        Farm farm = new Farm();
        while (true){
            if (farm.dayPassed()) break;
        }
    }
}
