public class DataRecord {

    private DataRecord next;
    private final String name;

    public DataRecord(String name) {
        this.name = name;
    }

    public DataRecord getNext() {
        return next;
    }

    public void setNext(DataRecord next) {
        this.next = next;
    }

    public String getName() {
        return name;
    }

}
