package com.domain.lesson6.units;

// protected -- можно обратиться к свойству внутри данного класса и у его наследников
// если идентификатор доступа не указан -- package private -- свойство доступно внутри пакета
abstract public class Unit implements RestAble{
    protected String name;
    protected int health;
    protected int speed;

    public Unit(String name, int speed) {
        if (speed > 0) {
            this.name = name;
            this.speed = speed;
        }
        else{
            System.out.println("Скорость не может быть нулевой или отрицательной. Приложение завершено!");
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !"".equals(name)){
            this.name = name;
        } else {
            System.out.println("Недопустимое имя!");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health >= 0){
            this.health = health;
        } else {
            System.out.println("Устанавливаемый уровень здоровья должен быть больше нуля");
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0){
            this.speed = speed;
        } else {
            System.out.println("Устанавливаемый уровень скорости должен быть больше нуля");
        }
    }

    public boolean isAlive(){
        return health > 0;
    }

    public void run(){
        if (this.health > 0)
            System.out.println("Юнит перемещается со скоростью " + speed);
        else
            System.out.println("Юнит мертв");
    }
}
