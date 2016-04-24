public class Tour {
    public static class Node {
        private Point p;
        private Node next;

        Node() {}

        Node(Point p) {
            this.p = p;
        }
    }

    private final Node start = new Node();

    private int size = 0;

    // create an empty tour
    public Tour() {

    }

    // create a 4 point tour a->b->c->d->a
    public Tour(Point a, Point b, Point c, Point d) {
        add(a, b, c, d);
    }

    private void add(Point... points) {
        Node runner = start;
        while (runner.next != null) {
            runner = runner.next;
        }
        for (Point p : points) {
            runner.next = new Node(p);
            runner = runner.next;
            ++size;
        }
    }

    // print the tour to standard output
    public void show() {
        Node node = start.next;
        while (node != null) {
            System.out.println(node.p);
            node = node.next;
        }
    }

    // draw the tour to standard draw
    public void draw() {

    }

    // number of points on tour
    public int size() {
        return size;
    }

    // return the total distance of the tour
    public double distance() {
        return 0;
    }

    // insert p using nearest neighbor heuristic
    public void insertNearest(Point p) {

    }

    // insert p using smallest increase heuristic
    public void insertSmallest(Point p) {

    }
}
