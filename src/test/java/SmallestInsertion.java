import java.io.FileNotFoundException;
import java.util.List;

public class SmallestInsertion {

    public static final String INPUT_FILE = "tsp1000.txt";

    public static void main(String[] args) throws FileNotFoundException {
        List<Point> points = InputReader.fromFile(INPUT_FILE);
        Tour tour = createTourUsingInsertSmallest(points);
        printStats(tour);
    }

    private static Tour createTourUsingInsertSmallest(List<Point> points) {
        Tour tour = new Tour();
        for (Point point : points) {
            tour.insertSmallest(point);
        }
        return tour;
    }

    private static void printStats(Tour tour) {
        tour.show();
        System.out.printf("Tour distance = %.4f\n", tour.distance());
        System.out.printf("Number of points = %s\n", tour.size());
    }
}
