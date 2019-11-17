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
        System.out.println(separateWordsByLettersNumber(strings).get(15));
    }

    public HashMap<String, Integer> sortedByOccuranceWordsDesc(List<String> strings){
        Comparator<Word> wordOccuranceComparator = new WordOccuranceComparator();
        HashMap<String, Integer> outputMap = new HashMap<>();
// TODO    To be Done below
//        for (String string: strings){
//            String[] words = string.split(" |--|, |\\. |,|\\.|\"| \"|\'| \'|\\[|\\]| \\[| \\]|!| !|\\?| \\?|\\(|\\)| \\(| \\)|\\*| \\*|:| :|;| ;");
//
//            for (String word: words){
//                if (outputMap.contains(word)) outputMap..put(word, 1);
//                else outputMap.put(word, outputMap.get(word) + 1);
//            }
//        }
//
//        TreeSet<Student> studentTreeSet2 = new TreeSet<>(studentComparator);
//
//        outputMap
//
        return outputMap;
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
            String[] words = string.split(" |--|, |\\. |,|\\.|\"| \"|\'| \'|\\[|\\]| \\[| \\]|!| !|\\?| \\?|\\(|\\)| \\(| \\)|\\*| \\*|:| :|;| ;");
            for (String word: words){
                if (map.get(word.length()) == null){
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.add(word);
                    map.put(word.length(), hashSet);
                } else{
                    map.get(word.length()).add(word);
                }
            }
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
