package lesson12.homeWork;

import java.util.Comparator;

public class WordOccuranceComparator implements Comparator<Word> {

    @Override
    public int compare(Word word1, Word word2) {
        return Integer.compare(word1.getOccurance(), word2.getOccurance());
    }
}