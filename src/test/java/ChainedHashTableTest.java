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
        assertEquals(16, chainedHashTable.countWord("transylvania"));
    }

    @Test
    public void count_of_harker_should_be_175() {
        assertEquals(113, chainedHashTable.countWord("harker"));
    }

    @Test
    public void count_of_renfield_should_be_39() {
        assertEquals(39, chainedHashTable.countWord("renfield"));
    }

    @Test
    public void count_of_vampire_should_be_24() {
        assertEquals(24, chainedHashTable.countWord("vampire"));
    }

    @Test
    public void count_of_expostulate_should_be_1() {
        assertEquals(1, chainedHashTable.countWord("expostulate"));
    }

    @Test
    public void count_of_fangoriously_should_be_1() {
        assertEquals(0, chainedHashTable.countWord("fangoriously"));
    }

    @Test
    public void count_of_abcxyz_should_be_0() {
        assertEquals(0, chainedHashTable.countWord("abcxyz"));
    }

    @Test
    public void longest_chain_length_should_be_8751() {
        assertEquals(111, chainedHashTable.findLongestChainLength());
    }

    @Test
    public void shortest_chain_length_should_be_59() {
        assertEquals(59, chainedHashTable.findShortestChainLength());
    }

    @Test
    public void distinct_words_should_be_10855() {
        assertEquals(10855, chainedHashTable.countDistinctWords());
    }

    @Test
    public void head_of_chain_0_is_revenue() {
        assertEquals("revenue", chainedHashTable.getHeadOfBucket(0));
    }

    @Test
    public void head_of_chain_27_is_transcription() {
        assertEquals("transcription", chainedHashTable.getHeadOfBucket(27));
    }

    @Test
    public void head_of_chain_43_is_3458zip() {
        assertEquals("3458zip", chainedHashTable.getHeadOfBucket(43));
    }

    @Test
    public void head_of_chain_126_is_5961887() {
        assertEquals("5961887", chainedHashTable.getHeadOfBucket(126));
    }

    @Test
    public void size_should_be_163721() {
        assertEquals(163721, chainedHashTable.size());
    }

    @Test
    public void most_frequent_word_should_be_() {
        assertEquals("the", chainedHashTable.findMostFrequent());
    }
}
