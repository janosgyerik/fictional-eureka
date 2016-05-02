public class LinkedList {

    private static class Node {

        private final String word;
        private int count;
        private Node next;

        public Node(String word, Node next) {
            this.word = word;
            this.next = next;
            this.count = 1;
        }
    }

    // dummy node to mark the head of the list
    private final Node dummy = new Node(null, null);

    private int distinctCount = 0;
    private int wordCount = 0;

    public void addFirst(String word) {
        Node removed = remove(word);
        if (removed != null) {
            removed.count++;
            removed.next = dummy.next;
            dummy.next = removed;
        } else {
            dummy.next = new Node(word, dummy.next);
            distinctCount++;
        }
        wordCount++;
    }

    public String getFirst() {
        return dummy.next.word;
    }

    public int count(String word) {
        Node node = dummy.next;
        while (node != null) {
            if (node.word.equals(word)) {
                return node.count;
            }
            node = node.next;
        }
        return 0;
    }

    public int getWordCount() {
        return wordCount;
    }

    public long getDistinctCount() {
        return distinctCount;
    }

    public int size() {
        return distinctCount;
    }

    public String findMostFrequent() {
        int mostFrequentCount = 0;
        String mostFrequent = null;

        Node node = dummy.next;
        while (node != null) {
            int count = node.count;
            if (count > mostFrequentCount) {
                mostFrequentCount = count;
                mostFrequent = node.word;
            }
            node = node.next;
        }
        return mostFrequent;
    }

    private Node remove(String word) {
        Node node = dummy;
        while (node.next != null) {
            if (node.next.word.equals(word)) {
                Node removed = node.next;
                node.next = node.next.next;
                return removed;
            }
            node = node.next;
        }
        return null;
    }
}
