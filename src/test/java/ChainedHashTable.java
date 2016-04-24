import java.util.ArrayList;
import java.util.List;

public class ChainedHashTable {
    static final int TABLE_SIZE = 127;
    private DataRecord[] table = new DataRecord[TABLE_SIZE];

    private int getIndex(String word) {
        return calculateHashCode(word) % TABLE_SIZE;
    }

    private int calculateHashCode(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            result = result + word.charAt(i);
        }
        return result;
    }

    public void add(String name) {
        int bucket = getIndex(name);
        DataRecord newNode = new DataRecord();
        newNode.setName(name);
        newNode.setNext(table[bucket]);
        table[bucket] = newNode;
    }

    public String toString() {
        String rtn = "";

        for (int i = 0; i < TABLE_SIZE; i++) {
            rtn += "bucket[" + i + "] = ";
            if (table[i] == null) {
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
        int index = getIndex(word);
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

    public String getHeadOfChain(int index) {
        return table[index].getName();
    }
}
