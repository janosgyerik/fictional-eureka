public class Tour {
    private static class Node {
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

    // Marks the start of the circular list
    private Node start;

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
        for (Point p : points) {
            node = insertAfter(node, p);
            node = node.next;
        }
    }

    // print the tour to standard output
    public void show() {
        Node node = start.next;
        for (int i = 0; i < size; ++i) {
            System.out.println(node.p);
            node = node.next;
        }
    }

    // draw the tour to standard draw
    public void draw() {
        Node node = start.next;
        for (int i = 0; i < size; ++i) {
            node.p.drawTo(node.next.p);
            node = node.next;
        }
    }

    // number of points on tour
    public int size() {
        return size;
    }

    // return the total length of the tour
    public double length() {
        double total = 0;

        if (start == null) {
            // the tour is empty
            return total;
        }

        // set to the first point
        Point prev = start.next.p;

        // set to the second node
        Node node = start.next.next;
        for (int i = 0; i < size; ++i) {
            // add to total the distance from prev to current
            total += prev.distanceTo(node.p);

            // update prev to current, for the next cycle
            prev = node.p;
            node = node.next;
        }

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
        for (int i = 0; i < size; ++i) {
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
    private Node insertAfter(Node node, Point point) {
        if (start == null) {
            start = new Node(point);
            start.next = start;
            node = start;
        } else {
            node.next = new Node(point, node.next);
        }
        ++size;
        return node;
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
        if (start == null) {
            // the tour is empty, so should insert after the start marker
            return start;
        }

        // set minimum increase to "infinity"
        double minIncrease = Double.MAX_VALUE;

        Node smallestIncrease = start;
        // set to first node
        Node node = start.next;

        for (int i = 0; i <= size; ++i) {
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

        return smallestIncrease;
    }
}
