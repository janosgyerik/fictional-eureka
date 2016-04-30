import java.util.Arrays;

public class ChainedHashTable {
    private static final int BUCKETS_COUNT = 127;
    private DataRecord[] buckets = new DataRecord[BUCKETS_COUNT];

    private int getIndex(String word) {
        return calculateHashCode(word) % BUCKETS_COUNT;
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
        DataRecord newNode = new DataRecord(name);
        newNode.setNext(buckets[bucket]);
        buckets[bucket] = newNode;
    }

    public int countWord(String word) {
        int index = getIndex(word);
        DataRecord node = buckets[index];
        int count = 0;
        while (node != null) {
            if (node.getName()
                .equalsIgnoreCase(word)) {
                ++count;
            }
            node = node.getNext();
        }
        return count;
    }

    public int findLongestChainLength() {
        int longest = 0;
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            longest = Math.max(longest, getChainLength(buckets[i]));
        }
        return longest;
    }

    public int findShortestChainLength() {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            shortest = Math.min(shortest, getChainLength(buckets[i]));
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
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            count += countDistinct(buckets[i]);
        }
        return count;
    }


    private long countDistinct(DataRecord node) {
        String[] words = toSortedArray(node);

        String prev = "";
        int count = 0;
        for (String word : words) {
            if (!word.equals(prev)) {
                ++count;
            }
            prev = word;
        }
        return count;
    }

    public String getHeadOfBucket(int index) {
        return buckets[index].getName();
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            DataRecord node = buckets[i];
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

        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            String localMostFrequent = findMostFrequent(buckets[i]);
            int count = countWord(localMostFrequent);
            if (count > mostFrequentCount) {
                mostFrequentCount = count;
                mostFrequent = localMostFrequent;
            }
        }
        return mostFrequent;
    }

    private String findMostFrequent(DataRecord node) {
        String[] words = toSortedArray(node);

        int mostFrequentCount = 0;
        String mostFrequent = null;

        String prev = null;
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

    private void sort(String[] words) {
        // TODO: implement your own (for example bubble sort)
        Arrays.sort(words);
    }

    private String[] toSortedArray(DataRecord node) {
        String[] words = new String[getChainLength(node)];
        int i = 0;
        while (node != null) {
            words[i++] = node.getName();
            node = node.getNext();
        }
        sort(words);
        return words;
    }
}
