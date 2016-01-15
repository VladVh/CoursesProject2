package ua.kiev.univ.cyb.SentenceParts;

import java.util.ArrayList;
import java.util.List;

/**
 * Class extends the PartOfSentence class and
 * may contain different methods to work with punctuation marks.
 * There is a list of signs which is used in text parsing.
 *
 * @author Vladyslav Voitsekh
 * @since 25.11.2015
 */
public class PunctuationMark extends PartOfSentence {
    public static List<String> getSigns() {
        return signs;
    }

    /**
     * List of most common signs in a sentence
     */
    public static final List<String> signs;
    static
    {
        signs = new ArrayList<>();
        signs.add(".");
        signs.add("?");
        signs.add("!");
        signs.add(",");
        signs.add("(");
        signs.add(")");
    }

    /**
     * Constructor for a new punctuation mark in a sentece
     * @param sign punctuation mark
     */
    public PunctuationMark(String sign) {
        this.sequence = sign;
    }
}
