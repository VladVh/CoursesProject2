package ua.kiev.univ.cyb;

import ua.kiev.univ.cyb.SentenceParts.PartOfSentence;
import ua.kiev.univ.cyb.SentenceParts.Sentence;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Class holds the text and has methods to manipulate the sentences
 * or find something in the whole text like words with the given length.
 *
 * @author Vladyslav Voitsekh
 * @since 25.11.2015
 */
public class Text {
    /**
     * List of sentences of the text
     */
    private List<Sentence> sentences;

    /**
     * Length of the words to find
     */
    private int wordLength;

    /**
     * Constructor which takes a list of sentences
     * @param wordLength required length of the words
     */
    public Text(int wordLength) {
        this.wordLength = wordLength;
    }

    /**
     * Method splits text into sentences and creates a parsed text
     * @param fileName path to the file with text
     */
    public void parse(String fileName) {
        List<Sentence> text = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(new File(fileName)), Charset.forName("Unicode")));
            char ch;
            StringBuilder sentence = new StringBuilder("");
            while((ch = (char) reader.read()) != -1 && ch != 65535) {
                sentence.append(ch);
                if(ch == '.' || ch == '?' || ch == '!') {
                    text.add(new Sentence(sentence.toString()));
                    sentence = new StringBuilder();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sentences = text;
    }

    /**
     * Prints words with a given length from the text
     */
    public void getRightWords() {
        for(Sentence sentence: sentences) {
            if(sentence.endsWithQuestionMark()) {
                List<PartOfSentence> list = sentence.getRightWords(wordLength);
                for (PartOfSentence word : list) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }

    public String toString() {
        StringBuilder text = new StringBuilder();
        for(Sentence sentence: sentences) {
            text.append(sentence);
        }
        return text.toString();
    }

}
