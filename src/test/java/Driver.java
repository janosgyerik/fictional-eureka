import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {
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
