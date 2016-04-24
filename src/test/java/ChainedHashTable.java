import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChainedHashTable {
    private static final int TABLE_SIZE = 127;
    private DataRecord[] table = new DataRecord[TABLE_SIZE];

    private int getIndex(String word) {
        return calculateHashCode(word) % TABLE_SIZE;
    }

    private int calculateHashCode(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            result += word.charAt(i);
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

    public int countWord(String word) {
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

    public int findLongestChainLength() {
        int longest = 0;
        for (int i = 0; i < TABLE_SIZE; ++i) {
            longest = Math.max(longest, getChainLength(table[i]));
        }
        return longest;
    }

    public int findShortestChainLength() {
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

    public String getHeadOfBucket(int index) {
        return table[index].getName();
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < TABLE_SIZE; ++i) {
            DataRecord node = table[i];
            while (node != null) {
                ++count;
                node = node.getNext();
            }
        }
        return count;
    }

    public String findMostFrequent() {
        int mostFrequentCount = 0;
        String mostFrequent = null;

        for (int i = 0; i < TABLE_SIZE; ++i) {
            String localMostFrequent = findMostFrequent(table[i]);
            int count = countWord(localMostFrequent);
            if (count > mostFrequentCount) {
                mostFrequentCount = count;
                mostFrequent = localMostFrequent;
            }
        }
        return mostFrequent;
    }

    private String findMostFrequent(DataRecord node) {
        List<String> words = new ArrayList<>();
        while (node != null) {
            words.add(node.getName());
            node = node.getNext();
        }

        Collections.sort(words);

        int mostFrequentCount = 0;
        String mostFrequent = "";

        String prev = "";
        int count = 0;
        for (String word : words) {
            if (word.equals(prev)) {
                ++count;
                if (count > mostFrequentCount) {
                    mostFrequentCount = count;
                    mostFrequent = word;
                }
            } else {
                count = 0;
            }
            prev = word;
        }
        return mostFrequent;
    }
}
