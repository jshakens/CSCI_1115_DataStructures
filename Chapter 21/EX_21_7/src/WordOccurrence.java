public class WordOccurrence implements Comparable<WordOccurrence> {
    String word;
    Integer count;

    /**
     * Construct an instance WordOccurrence
     * with specified word and count
     */
    public WordOccurrence(String word, int count) {
        this.word = word;
        this.count = count;
    }
    @Override
    public int compareTo(WordOccurrence o) {
        if (o.count > count)
            return -1;
        else if (o.count < count)
            return 1;
        else
            return 0;
    }

}