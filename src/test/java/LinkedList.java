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
        LinkedList copy = copy();

        int mostFrequentCount = 0;
        String mostFrequent = null;

        while (!copy.isEmpty()) {
            String candidate = copy.getFirst();
            int count = copy.removeAll(candidate);
            if (count > mostFrequentCount) {
                mostFrequentCount = count;
                mostFrequent = candidate;
            }
        }
        return mostFrequent;
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

    private int removeAll(String word) {
        int count = 0;
        Node node = dummy;
        while (node.next != null) {
            if (node.next.word.equals(word)) {
                node.next = node.next.next;
                size--;
                count++;
            } else {
                node = node.next;
            }
        }
        return count;
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
