import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ChainedHashTableTest {

    static ChainedHashTable chainedHashTable;

    @BeforeClass
    public static void setUpBeforeClass() throws IOException {
        chainedHashTable = new Driver().getChained();
    }

    @Test
    public void count_of_transylvania_should_be_16() {
        assertEquals(16, chainedHashTable.count("transylvania"));
    }

    @Test
    public void count_of_harker_should_be_175() {
        assertEquals(175, chainedHashTable.count("harker"));
    }

    @Test
    public void count_of_renfield_should_be_48() {
        assertEquals(48, chainedHashTable.count("renfield"));
    }

    @Test
    public void count_of_vampire_should_be_28() {
        assertEquals(28, chainedHashTable.count("vampire"));
    }

    @Test
    public void count_of_expostulate_should_be_1() {
        assertEquals(1, chainedHashTable.count("expostulate"));
    }

    @Test
    public void count_of_fangoriously_should_be_1() {
        assertEquals(0, chainedHashTable.count("fangoriously"));
    }

    @Test
    public void count_of_abcxyz_should_be_0() {
        assertEquals(0, chainedHashTable.count("abcxyz"));
    }

    @Test
    public void longest_chain_length_should_be_8751() {
        assertEquals(8751, chainedHashTable.getLongestChainLength());
    }

    @Test
    public void shortest_chain_length_should_be_197() {
        assertEquals(197, chainedHashTable.getShortestChainLength());
    }

    @Test
    public void distinct_words_should_be_9517() {
        assertEquals(9516, chainedHashTable.countDistinctWords());
    }
}
