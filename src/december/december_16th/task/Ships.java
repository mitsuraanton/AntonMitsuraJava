package december.december_16th.task;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Ships {
    /*Корабли - потоки:
    Корабли заходят в порт для разгрузки/загрузки .
    Работает несколько причалов (4).
    У одного причала может стоять один корабль.*/
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4);
       Dock[] docks = new Dock[4];
       Ship[] ships = new Ship[10];
        for (int i = 0; i < docks.length; i++) {
            docks[i] = new Dock("Причал " + (i+1));
        }
        for (int i = 0; i < ships.length; i++) {
            ships[i] = new Ship(docks, semaphore, "Корабль " + (i+1));
        }
        for (int i = 0; i < ships.length; i++) {
            new Thread(ships[i]).start();
        }
    }
}

class Ship implements Runnable{
    private Dock[] docks;
    private String name;
    private Semaphore semaphore;
    public Ship(Dock[] docks, Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
        this.docks = docks;
    }
    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Корабль с именем " + this.name + " начал движение в сторону пирсов.");
        try {
            while (true){
                for (int i = 0; i < docks.length; i++) {
                    if (!docks[i].isBeasy()){
                        semaphore.acquire();
                        docks[i].setBeasy(true);
                        System.out.println("Корабль с именем " + this.name + " занял пирс с именем " + docks[i].getName());
                        Thread.sleep(random.nextInt(15) * 1000);
                        docks[i].setBeasy(false);
                        System.out.println("Корабль с именем " + this.name + " отошел от пирса с именем " + docks[i].getName());
                        semaphore.release();
                        Thread.sleep(1000);
                        break;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Dock{
    private String name;
    private boolean isBeasy;

    public boolean isBeasy() {
        return isBeasy;
    }
    public void setBeasy(boolean beasy) {
        isBeasy = beasy;
    }
    public Dock(String name) {
        this.name = name;
        this.isBeasy = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}