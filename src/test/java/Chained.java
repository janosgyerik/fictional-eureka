import java.util.ArrayList;
import java.util.List;

public class Chained {
    static final int TABLE_SIZE = 127;
    static final DataRecord NEVER_USED = null;
    private DataRecord[] table = new DataRecord[TABLE_SIZE];

    public Chained() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = NEVER_USED;
        }
    }

    //stores where the variable goes
    private int hashFunction(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            //converts to ASCII gets the total vaule in each for ASCII for each letter
            result = result + (int) word.charAt(i);
        }

        return result % TABLE_SIZE;
    }

    public int getLongestChain(String name) {
        return 0;
    }

    public void getTotalWordCount() {

    }

    public void getWordFrequency() {

    }

    public int size() {
        return TABLE_SIZE;
    }

    public DataRecord search(String name) {
        int bucket = hashFunction(name);
        DataRecord node = table[bucket];

        while (node != null) {
            if (node.getName().equalsIgnoreCase(name)) {
                return node;
            }
            node = node.getNext();
        }

        return null;
    }

    public void add(String name) {
        int bucket = hashFunction(name);
        DataRecord newNode = new DataRecord();
        newNode.setName(name);
        newNode.setNext(table[bucket]);
        table[bucket] = newNode;
    }

    public String toString() {
        String rtn = "";

        for (int i = 0; i < TABLE_SIZE; i++) {
            rtn += "bucket[" + i + "] = ";
            if (table[i] == NEVER_USED) {
                rtn += "NEVER_USED\n";
            } else {
                DataRecord n = table[i];
                rtn += "[ ";
                while (n != null) {
                    rtn += n + " ";
                    n = n.getNext();
                }
                rtn += "]\n";
            }
        }

        return rtn;
    }

    public int count(String word) {
        int index = hashFunction(word);
        DataRecord node = table[index];
        int count = 0;
        while (node != null) {
            if (node.getName().equalsIgnoreCase(word)) {
                ++count;
            }
            node = node.getNext();
        }
        return count;
    }

    public int getLongestChainLength() {
        int longest = 0;
        for (int i = 0; i < TABLE_SIZE; ++i) {
            longest = Math.max(longest, getChainLength(table[i]));
        }
        return longest;
    }

    public int getShortestChainLength() {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < TABLE_SIZE; ++i) {
            shortest = Math.min(shortest, getChainLength(table[i]));
        }
        return shortest;
    }

    private int getChainLength(DataRecord node) {
        int length = 0;
        while (node != null) {
            ++length;
            node = node.getNext();
        }
        return length;
    }

    public int countDistinctWords() {
        int count = 0;
        for (int i = 0; i < TABLE_SIZE; ++i) {
            count += countDistinct(table[i]);
        }
        return count;
    }

    private long countDistinct(DataRecord node) {
        List<String> words = new ArrayList<>();
        while (node != null) {
            words.add(node.getName());
            node = node.getNext();
        }
        return words.stream().distinct().count();
    }
}
