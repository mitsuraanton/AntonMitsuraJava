package lesson11.homeWork;

import java.util.ArrayList;
import java.util.Scanner;

public class Enter10WordsFromKeyboard {
    public static void main(String[] args) {
        System.out.println("Введите 10 слов:");
        Scanner in = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            words.add(in.nextLine());
        }
        boolean isSorted = true;
        int elementIndexBreakingOrderlines = 0;

        for (int i = 0; i < words.size() -1 ; i++) {
            if (words.get(i+1).length() < words.get(i).length()){
                isSorted = false;
                elementIndexBreakingOrderlines = i+1;
                break;
            }
        }
        if (isSorted){
            System.out.println("10 слов отсортированы по длине слова");
        } else{
            System.out.println("Слова не отсортированы. Первый элемент, нарушающий упорядоченность имеет индекс: " + elementIndexBreakingOrderlines);
        }


    }
}
