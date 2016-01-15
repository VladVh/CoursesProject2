package ua.kiev.univ.cyb.SentenceParts;

/**
 * This class provides access to work with each word separately,
 * extends PartOfSentence class and may contain different methods to change the word.
 *
 * @author Vladyslav Voitsekh
 * @since 25.11.2015
 */
public class Word extends PartOfSentence {

    /**
     * Standard constructor for a word
     * @param word String which corresponds to a word from sentece
     */
    public Word(String word) {
        this.sequence = word;
    }

    public int length() {
        return sequence.length();
    }
}
