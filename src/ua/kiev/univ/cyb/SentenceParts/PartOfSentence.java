package ua.kiev.univ.cyb.SentenceParts;

/**
 * The abstract base class for parts of the sentence{@link PunctuationMark}, {@link Word}.
 * Class provides a string representation for each element.
 *
 * @author Vladyslav Voitsekh
 * @since 25.11.2015
 */

public abstract class PartOfSentence {
    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    /**
     * Word or a punctuation mark
     */
    protected String sequence;

    public String toString() {
        return sequence;
    }

}
