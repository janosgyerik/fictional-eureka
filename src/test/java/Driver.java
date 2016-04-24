import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) throws IOException {
        Driver me = new Driver();
        me.doIt();
    }

    public void doIt() throws IOException {
        Chained ctable = getChained();
        System.out.println(ctable);
    }

    Chained getChained() throws IOException {
        Chained ctable = new Chained();
        BufferedReader rd = new BufferedReader(new FileReader("pg345.txt"));
        String line;
        while ((line = rd.readLine()) != null) {
            String[] words = line.replaceAll("[^a-zA-Z ]", " ")
                .toLowerCase()
                .split("\\s+");
            for (String word : words) {
                ctable.add(word);
            }
        }
        return ctable;
    }

}
