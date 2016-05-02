public class ChainedHashTable {
    private static final int BUCKETS_COUNT = 127;
    private final LinkedList[] buckets;

    public ChainedHashTable() {
        buckets = new LinkedList[BUCKETS_COUNT];
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
        for (LinkedList bucket : buckets) {
            longest = Math.max(longest, bucket.size());
        }
        return longest;
    }

    public int findShortestChainLength() {
        int shortest = Integer.MAX_VALUE;
        for (LinkedList bucket : buckets) {
            shortest = Math.min(shortest, bucket.size());
        }
        return shortest;
    }

    public int countDistinctWords() {
        int count = 0;
        for (LinkedList bucket : buckets) {
            count += bucket.getDistinctCount();
        }
        return count;
    }

    public String getHeadOfBucket(int index) {
        return buckets[index].getFirst();
    }

    public int size() {
        int count = 0;
        for (LinkedList bucket : buckets) {
            count += bucket.getWordCount();
        }
        return count;
    }

    public String findMostFrequent() {
        int mostFrequentCount = 0;
        String mostFrequent = null;

        for (LinkedList bucket : buckets) {
            String localMostFrequent = bucket.findMostFrequent();
            int count = bucket.count(localMostFrequent);
            if (count > mostFrequentCount) {
                mostFrequentCount = count;
                mostFrequent = localMostFrequent;
            }
        }
        return mostFrequent;
    }
}
