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

    // helper method to simply append points
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
        double total = 0;

        // set to the first point
        Point prev = start.next.p;

        // set to the second node
        Node node = start.next.next;
        while (node != null) {
            // add to total the distance from prev to current
            total += prev.distanceTo(node.p);

            // update prev to current, for the next cycle
            prev = node.p;
            node = node.next;
        }
        // add to total the distance from last to first
        total += prev.distanceTo(start.next.p);

        return total;
    }

    /*
    Nearest neighbor heuristic:
    Read in the next point, and add it to the current tour after the point to which it is closest.
    (If there is more than one point to which it is closest, insert it after the first such point you discover.)
     */
    public void insertNearest(Point p) {
        Node nearest = findNearest(p);
        insertAfter(nearest, p);
    }

    // helper method to find the Node nearest to p
    private Node findNearest(Point p) {
        // set minimum distance to "infinity"
        double minDistance = Double.MAX_VALUE;

        Node nearest = start;
        Node node = start;
        while (node.next != null) {
            double distance = p.distanceTo(node.next.p);
            if (distance < minDistance) {
                // this node is the nearest so far
                minDistance = distance;
                nearest = node.next;
            }
            node = node.next;
        }
        return nearest;
    }

    // helper method to insert a Point after a Node, and udate the Tour size
    private void insertAfter(Node node, Point point) {
        node.next = new Node(point, node.next);
        ++size;
    }

    /*
    Smallest increase heuristic:
    Read in the next point, and add it to the current tour after the point where
    it results in the least possible increase in the tour length.
    (If there is more than one point, insert it after the first such point you discover.)
     */
    public void insertSmallest(Point p) {
        Node smallestIncrease = findSmallestIncrease(p);
        insertAfter(smallestIncrease, p);
    }

    // helper method to find the Node after which the increase will be smallest
    private Node findSmallestIncrease(Point p) {
        if (start.next == null) {
            // the tour is empty, so should insert after the start marker
            return start;
        }

        // set minimum increase to "infinity"
        double minIncrease = Double.MAX_VALUE;

        Node smallestIncrease = start;
        // set to first node
        Node node = start.next;

        while (node.next != null) {
            double distCurrentToNext = node.p.distanceTo(node.next.p);
            double distCurrentToNew = node.p.distanceTo(p);
            double distNextToNew = node.next.p.distanceTo(p);

            // the increase = replace the link from A->B, with A->X->B
            double increase = -distCurrentToNext + distCurrentToNew + distNextToNew;

            if (increase < minIncrease) {
                minIncrease = increase;
                smallestIncrease = node;
            }
            node = node.next;
        }

        // special treatment for last Node: replace LAST->FIRST with LAST->X->FIRST
        double distCurrentToNext = node.p.distanceTo(start.next.p);
        double distCurrentToNew = node.p.distanceTo(p);
        double distNextToNew = start.next.p.distanceTo(p);

        double increase = -distCurrentToNext + distCurrentToNew + distNextToNew;
        if (increase < minIncrease) {
            smallestIncrease = node;
        }

        return smallestIncrease;
    }
}
