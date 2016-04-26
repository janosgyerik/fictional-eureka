import java.io.FileNotFoundException;
import java.util.List;

public class NearestInsertion {

    public static final String INPUT_FILE = "tsp1000.txt";

    public static void main(String[] args) throws FileNotFoundException {
        Tour tour = createTour();
        printStats(tour);
    }

    static Tour createTour() throws FileNotFoundException {
        List<Point> points = InputReader.fromFile(INPUT_FILE);
        return createTourUsingInsertNearest(points);
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
        System.out.printf("Tour distance = %.4f\n", tour.length());
        System.out.printf("Number of points = %s\n", tour.size());
    }
}
