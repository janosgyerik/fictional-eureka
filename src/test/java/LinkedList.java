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

    private void sort(String[] words) {
        // TODO: implement your own (for example bubble sort)
        Arrays.sort(words);
    }

    public String[] toSortedArray() {
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
}
