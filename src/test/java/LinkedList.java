public class LinkedList {

    private LinkedList next;
    private final String name;

    public LinkedList(String name) {
        this.name = name;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

}
