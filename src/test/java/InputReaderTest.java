import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class InputReaderTest {
    @Test
    public void test_() throws FileNotFoundException {
        List<Point> points = InputReader.fromFile("tsp1000.txt");
        assertEquals(1000, points.size());

        assertEquals(new Point(185.0411, 457.8824).toString(), points.get(0).toString());
    }
}
