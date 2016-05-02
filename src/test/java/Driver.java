import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {
        ChainedHashTable ctable = new Driver().getChained();

        printWordCount(ctable, "transylvania");
        printWordCount(ctable, "harker");
        printWordCount(ctable, "renfield");
        printWordCount(ctable, "vampire");
        printWordCount(ctable, "expostulate");
        printWordCount(ctable, "fangoriously");

        printLine("Longest Chain is", ctable.findLongestChainLength());
        printLine("Shortest Chain is", ctable.findShortestChainLength());
        printLine("Total Distinct words", ctable.countDistinctWords());

        printFirstWordInBucket(ctable, 0);
        printFirstWordInBucket(ctable, 27);
        printFirstWordInBucket(ctable, 43);
        printFirstWordInBucket(ctable, 126);

        printLine("Text contains", ctable.size() + " Total words.");
        String mostFrequent = ctable.findMostFrequent();
        printLine("Most frequent words is",
            String.format("\"%s\", occuring %d times.", mostFrequent, ctable.countWord(mostFrequent)));
    }

    private static void printLine(String label, int value) {
        printLine(label, String.valueOf(value));
    }

    private static void printLine(String label, String value) {
        System.out.printf("%-27s: %s\n", label, value);
    }

    private static void printWordCount(ChainedHashTable ctable, String word) {
        printLine(word + " occurs", ctable.countWord(word) + " times");
    }

    private static void printFirstWordInBucket(ChainedHashTable ctable, int index) {
        printLine("Word at head of bucket " + index, ctable.getHeadOfBucket(index));
    }

    ChainedHashTable getChained() throws IOException {
        ChainedHashTable ctable = new ChainedHashTable();
        BufferedReader rd = new BufferedReader(new FileReader("pg345.txt"));
        String line;
        while ((line = rd.readLine()) != null) {
            line = line.trim().replaceAll("[^a-zA-Z0-9 ]", "")
                .toLowerCase()
                .trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] words = line.split("\\s+");
            for (String word : words) {
                ctable.add(word);
            }
        }
        return ctable;
    }

}
