package lesson12.homeWork;

import lesson12.MapLesson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class WorldAndPeace {
    public static void main(String[] args) throws IOException {
        ClassLoader loader = MapLesson.class.getClassLoader();
        File file = new File(loader.getResource("wp.txt").getFile());

        List<String> strings = Files.readAllLines(file.toPath());
        System.out.println("Number of occurance word he in text: " + numberOfWordOccuranceInText(strings, "he"));
    }

    public static long numberOfWordOccuranceInText(List<String> strings, String wordToSearch){
        long numberOfWordOccuranceinText = 0L;
        for (String string: strings){
            if (string.contains(wordToSearch)) numberOfWordOccuranceinText++;
        }
        return numberOfWordOccuranceinText;
    }

    public static HashMap<Integer, HashSet<String>> separateWordsByLettersNumber(List<String> strings){
        HashMap<Integer, HashSet<String>> map = new HashMap<>();
        for (String string: strings){
            String[] words = string.split(" ");
            String[]tokens = string.split(" |--");

        }

        return map;
    }

    public static List<String> getPeopleByCity(Map<String, String> map, String city){
        ArrayList<String> loginList = new ArrayList<>();
        for (Map.Entry<String, String> entry: map.entrySet()){
            if (city != null && city.equals(entry.getValue())){
                loginList.add(entry.getKey());
            }
        }
        return loginList;
    }
}
