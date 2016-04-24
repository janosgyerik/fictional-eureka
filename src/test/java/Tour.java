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

    // A dummy node to mark the start. This simplifies some of the looping logic.
    private final Node start = new Node();

    private int size = 0;

    // create an empty tour
    public Tour() {}

    // create a 4 point tour a->b->c->d->a
    public Tour(Point a, Point b, Point c, Point d) {
        add(a, b, c, d);
    }

    private void add(Point... points) {
        Node node = start;
        while (node.next != null) {
            node = node.next;
        }
        for (Point p : points) {
            node.next = new Node(p);
            node = node.next;
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
        Node node = start.next.next;
        while (node != null) {
            distance += prev.distanceTo(node.p);
            prev = node.p;
            node = node.next;
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
        Node node = start;
        while (node.next != null) {
            double distance = p.distanceTo(node.next.p);
            if (distance < min) {
                min = distance;
                nearest = node.next;
            }
            node = node.next;
        }
        return nearest;
    }

    private void insertAfter(Node current, Point point) {
        current.next = new Node(point, current.next);
        ++size;
    }

    /*
    Smallest increase heuristic:  Read in the next point, and add it to the current tour
    after the point where it results in the least possible increase in the tour length.
    (If there is more than one point, insert it after the first such point you discover.)
     */
    public void insertSmallest(Point p) {
        Node smallestIncrease = findSmallestIncrease(p);
        insertAfter(smallestIncrease, p);
    }

    private Node findSmallestIncrease(Point p) {
        if (start.next == null) {
            return start;
        }

        double min = Double.MAX_VALUE;

        Node smallestIncrease = start;
        Node node = start.next;
        while (node.next != null) {
            double existing = node.p.distanceTo(node.next.p);
            double distCurrentToNew = node.p.distanceTo(p);
            double distNextToNew = node.next.p.distanceTo(p);

            double increase = -existing + distCurrentToNew + distNextToNew;
            if (increase < min) {
                min = increase;
                smallestIncrease = node;
            }
            node = node.next;
        }

        double existing = node.p.distanceTo(start.next.p);
        double distCurrentToNew = node.p.distanceTo(p);
        double distNextToNew = start.next.p.distanceTo(p);

        double increase = -existing + distCurrentToNew + distNextToNew;
        if (increase < min) {
            smallestIncrease = node;
        }

        return smallestIncrease;
    }
}
