import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class TourTest {

    public static final double DELTA = .00005;

    @Test
    public void test_ctor_and_show() {
        Tour tour = new Tour(new Point(1., 2.), new Point(3., 4.), new Point(5., 6.), new Point(7., 8.));
        tour.show();
    }

    @Test
    public void test_empty_tour_length() {
        assertEquals(0, new Tour().length(), DELTA);
    }

    @Test
    public void test_empty_tour_size() {
        assertEquals(0, new Tour().size());
    }

    @Test
    public void test_nearestInsertion() throws FileNotFoundException {
        assertEquals(27868.7106, NearestInsertion.createTour()
            .length(), DELTA);
    }

    @Test
    public void test_smallestInsertion() throws FileNotFoundException {
        assertEquals(17265.6282, SmallestInsertion.createTour()
            .length(), DELTA);
    }
}
