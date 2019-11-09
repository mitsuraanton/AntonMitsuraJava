package lesson11.homeWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Enter20NumbersFromKeyboard {
    ArrayList<Integer> twentyNumbers = new ArrayList<>();
    ArrayList<Integer> numbersCanBeDividedBy2 = new ArrayList<>();
    ArrayList<Integer> numbersCanBeDividedBy3 = new ArrayList<>();
    public static void main(String[] args) {
        Enter20NumbersFromKeyboard curClass = new Enter20NumbersFromKeyboard();
        System.out.println("Введите 20 чисел:");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {
            curClass.twentyNumbers.add(in.nextInt());
        }

        for (int number: curClass.twentyNumbers){
            if (number%2 == 0) curClass.numbersCanBeDividedBy2.add(number);
            if (number%3 == 0) curClass.numbersCanBeDividedBy3.add(number);
        }
        curClass.printList();
        curClass.printList("original");
        curClass.printList("dividedByTwo");
        curClass.printList("dividedByThree");
    }

    public void printList(){
        System.out.println(twentyNumbers);
        System.out.println(numbersCanBeDividedBy2);
        System.out.println(numbersCanBeDividedBy3);
    }

    public void printList(String listName){
        switch (listName){
            case "original":
                System.out.println(twentyNumbers);
                break;
            case "dividedByTwo":
                System.out.println(numbersCanBeDividedBy2);
                break;
            case "dividedByThree":
                System.out.println(numbersCanBeDividedBy3);
                break;
        }
    }
}
