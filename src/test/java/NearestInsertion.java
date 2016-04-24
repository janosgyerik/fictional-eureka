import java.io.FileNotFoundException;
import java.util.List;

public class NearestInsertion {

    public static final String INPUT_FILE = "tsp1000.txt";

    public static void main(String[] args) throws FileNotFoundException {
        List<Point> points = InputReader.fromFile(INPUT_FILE);
        Tour tour = createTourUsingInsertNearest(points);
        printStats(tour);
    }

    private static Tour createTourUsingInsertNearest(List<Point> points) {
        Tour tour = new Tour();
        for (Point point : points) {
            tour.insertNearest(point);
        }
        return tour;
    }

    private static void printStats(Tour tour) {
        tour.show();
        System.out.printf("Tour distance = %s\n", tour.distance());
        System.out.printf("Number of points = %s\n", tour.size());
    }
}
