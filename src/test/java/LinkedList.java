import java.util.Arrays;

public class LinkedList {

    private static class Node {

        private final String word;
        private Node next;

        public Node(String word, Node next) {
            this.word = word;
            this.next = next;
        }
    }

    // dummy node to mark the head of the list
    private final Node dummy = new Node(null, null);

    private int size = 0;

    public void addFirst(String word) {
        dummy.next = new Node(word, dummy.next);
        size++;
    }

    public String getFirst() {
        return dummy.next.word;
    }

    public int count(String word) {
        int count = 0;
        Node node = dummy.next;
        while (node != null) {
            if (node.word.equalsIgnoreCase(word)) {
                count++;
            }
            node = node.next;
        }
        return count;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String findMostFrequent() {
        String[] words = toSortedArray();

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
        Arrays.sort(words);
        // BubbleSort.sort(words);
    }

    private String[] toSortedArray() {
        String[] words = new String[size];
        Node node = dummy.next;
        int i = 0;
        while (node != null) {
            words[i++] = node.word;
            node = node.next;
        }
        sort(words);
        return words;
    }

    public long countDistinct() {
        LinkedList copy = copy();

        int count = 0;
        while (!copy.isEmpty()) {
            copy.removeAll(copy.getFirst());
            count++;
        }
        return count;
    }

    private void removeAll(String word) {
        Node node = dummy;
        while (node.next != null) {
            if (node.next.word.equals(word)) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    private LinkedList copy() {
        LinkedList copy = new LinkedList();
        Node node = dummy.next;
        Node last = copy.dummy;
        while (node != null) {
            last.next = new Node(node.word, null);
            last = last.next;
            node = node.next;
        }
        copy.size = size;
        return copy;
    }
}
