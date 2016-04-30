import java.util.Arrays;

public class ChainedHashTable {
    private static final int BUCKETS_COUNT = 127;
    private final LinkedList[] buckets = new LinkedList[BUCKETS_COUNT];

    public ChainedHashTable() {
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new LinkedList();
        }
    }

    private int getIndex(String word) {
        return calculateHashCode(word) % buckets.length;
    }

    private int calculateHashCode(String word) {
        int result = 0;
        for (int i = 0; i < word.length(); i++) {
            result += word.charAt(i);
        }
        return result;
    }

    public void add(String word) {
        buckets[getIndex(word)].addFirst(word);
    }

    public int countWord(String word) {
        return buckets[getIndex(word)].count(word);
    }

    public int findLongestChainLength() {
        int longest = 0;
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            longest = Math.max(longest, buckets[i].size());
        }
        return longest;
    }

    public int findShortestChainLength() {
        int shortest = Integer.MAX_VALUE;
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            shortest = Math.min(shortest, buckets[i].size());
        }
        return shortest;
    }

    public int countDistinctWords() {
        int count = 0;
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            count += countDistinct(buckets[i]);
        }
        return count;
    }


    private long countDistinct(LinkedList node) {
        String[] words = node.toSortedArray();

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
        return buckets[index].getFirst();
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < BUCKETS_COUNT; ++i) {
            count += buckets[i].size();
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

    private String findMostFrequent(LinkedList node) {
        String[] words = node.toSortedArray();

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
}
