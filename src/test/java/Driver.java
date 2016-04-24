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

        System.out.println("Length of the longest chain: " + ctable.getLongestChainLength());
        System.out.println("Length of the shortest chain: " + ctable.getShortestChainLength());
        System.out.println("Distinct words: " + ctable.countDistinctWords());

        printFirstWordInChain(ctable, 0);
        printFirstWordInChain(ctable, 27);
        printFirstWordInChain(ctable, 43);
        printFirstWordInChain(ctable, 126);

        System.out.println("Total word count: " + ctable.size());
        System.out.println("Most frequent word: " + ctable.findMostFrequent());
    }

    private static void printWordCount(ChainedHashTable ctable, String word) {
        System.out.printf("The word %s appears %d times in the text.\n", word, ctable.count(word));
    }

    private static void printFirstWordInChain(ChainedHashTable ctable, int index) {
        System.out.printf("First word of bucket %d is '%s'.\n", index, ctable.getHeadOfChain(index));
    }

    ChainedHashTable getChained() throws IOException {
        ChainedHashTable ctable = new ChainedHashTable();
        BufferedReader rd = new BufferedReader(new FileReader("pg345.txt"));
        String line;
        while ((line = rd.readLine()) != null) {
            line = line.trim().replaceAll("[^a-zA-Z ]", " ")
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
