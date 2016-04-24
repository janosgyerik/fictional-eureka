import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ChainedTest {

    static Chained chained;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        chained = new Driver().getChained();
    }

    @Test
    public void count_of_transylvania_should_be_16() {
        assertEquals(16, chained.count("transylvania"));
    }

    @Test
    public void count_of_harker_should_be_175() {
        assertEquals(175, chained.count("harker"));
    }

    @Test
    public void count_of_renfield_should_be_48() {
        assertEquals(48, chained.count("renfield"));
    }

    @Test
    public void count_of_vampire_should_be_28() {
        assertEquals(28, chained.count("vampire"));
    }

    @Test
    public void count_of_expostulate_should_be_1() {
        assertEquals(1, chained.count("expostulate"));
    }

    @Test
    public void count_of_fangoriously_should_be_1() {
        assertEquals(0, chained.count("fangoriously"));
    }

    @Test
    public void count_of_abcxyz_should_be_0() {
        assertEquals(0, chained.count("abcxyz"));
    }

    @Test
    public void longest_chain_length_should_be_8751() {
        assertEquals(8751, chained.getLongestChainLength());
    }

    @Test
    public void shortest_chain_length_should_be_197() {
        assertEquals(197, chained.getShortestChainLength());
    }
}
