import org.junit.Test;

import static org.junit.Assert.*;

public class TourTest {
    @Test
    public void test_ctor_and_show() {
        Tour tour = new Tour(new Point(1., 2.), new Point(3., 4.), new Point(5., 6.), new Point(7., 8.));
        tour.show();
    }
}
