package com.domain.lesson6.units;

public class King extends Unit {

    private King(String name, int speed, int health) {
        super(name, speed);
        this.health = health;
    }

    @Override
    public String toString() {
        return "King{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", speed=" + speed +
                '}';
    }

    @Override
    public void rest() {
        System.out.println("Король опочивает");
    }

    public static King createNewKing(){
        return new King("Ричард", 3, 16);
    }
}
