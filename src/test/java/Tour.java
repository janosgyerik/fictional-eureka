public class Tour {
    public static class Node {
        private Point p;
        private Node next;

        Node() {}

        Node(Point p) {
            this.p = p;
        }

        Node(Point p, Node next) {
            this(p);
            this.next = next;
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
        double distance = 0;

        Point prev = start.next.p;
        Node runner = start.next.next;
        while (runner != null) {
            distance += prev.distanceTo(runner.p);
            prev = runner.p;
            runner = runner.next;
        }
        distance += prev.distanceTo(start.next.p);
        return distance;
    }

    /*
    Insert p using nearest neighbor heuristic

    Read in the next point, and add it to the current tour after the point to which it is closest.
    (If there is more than one point to which it is closest, insert it after the first such point you discover.)
     */
    public void insertNearest(Point p) {
        Node nearest = findNearest(p);
        insertAfter(nearest, p);
    }

    private Node findNearest(Point p) {
        double min = Double.MAX_VALUE;

        Node nearest = start;
        Node runner = start;
        while (runner.next != null) {
            double distance = p.distanceTo(runner.next.p);
            if (distance < min) {
                min = distance;
                nearest = runner.next;
            }
            runner = runner.next;
        }
        return nearest;
    }

    private void insertAfter(Node current, Point point) {
        current.next = new Node(point, current.next);
        ++size;
    }

    // insert p using smallest increase heuristic
    public void insertSmallest(Point p) {

    }
}
