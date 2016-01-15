package ua.kiev.univ.cyb.SentenceParts;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to work with sentences from a text.
 * Class has different methods to parse string, work with each part separately.
 * @see Word, @see PunctuationMark
 *
 * @author Vladyslav Voitsekh
 * @since 25.11.2015
 */
public class Sentence {
    /**
     * List contains words and punctuation marks from the sentence
     */
    private List<PartOfSentence> components;

    /**
     * Constructor that creates a sentence from a given string
     * @param sentence string representation of a part of the text
     */
    public Sentence(String sentence) {
        components = new ArrayList<>();
        parse(sentence);
    }

    /**
     * Splits string into words and punctuation marks
     * @param sentence
     */
    private void parse(String sentence) {
        StringBuilder sequence = new StringBuilder();
        char[] chars = sentence.toCharArray();
        int index = 0;
        while(index < chars.length) {
            while(Character.isLetterOrDigit(chars[index])) {
                sequence.append(chars[index++]);
            }
            if(sequence.length() > 0) {
                components.add(new Word(sequence.toString()));
                sequence = new StringBuilder();
            }

            if(Character.toString(chars[index]).matches("\\s")) {
                while (Character.toString(chars[index]).matches("\\s")) {
                    index++;
                }
                components.add(new PunctuationMark(" "));
            }

            if(PunctuationMark.signs.contains(Character.toString(chars[index]))) {
                components.add(new PunctuationMark(Character.toString(chars[index++])));
            }
        }
    }

    /**
     * Select words with a given length
     * @param wordLength
     * @return list of words which have a given length
     */
    public List<PartOfSentence> getRightWords(int wordLength) {
        List<PartOfSentence> wordList = new ArrayList<>();
        for (PartOfSentence part : components) {
            if (part.getClass() == Word.class && part.sequence.length() == wordLength) {
                wordList.add(part);
            }
        }
        return wordList;
    }

    /**
     * Checks whether the sentence ends with a quotation mark, or not
     * @return <tt>true</tt> if sentence ends with a quotation mark
     */
    public boolean endsWithQuestionMark() {
        return components.get(components.size() - 1).toString().equals("?");
    }

    public String toString() {
        StringBuilder sentence = new StringBuilder();
        for(PartOfSentence partOfSentence: components) {
            sentence.append(partOfSentence);
        }
        return sentence.toString();
    }
}
