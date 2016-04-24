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
    }

    private static void printWordCount(ChainedHashTable ctable, String word) {
        System.out.printf("The word %s appears %d times in the text.\n", word, ctable.count(word));
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
