import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Helper class to read points from an input file
 */
public class InputReader {
    public static List<Point> fromFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        // skip first line (containing w width and h height), we don't need it
        scanner.nextLine();

        List<Point> points = new ArrayList<>();
        while (scanner.hasNext()) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points.add(new Point(x, y));
        }
        return points;
    }
}
