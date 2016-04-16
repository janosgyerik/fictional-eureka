package com.janosgyerik.examples.codementor.starberks;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StarberksTest {

    private final StarberksInterface starberks = new StarberksInterface();

    @Test
    public void isValidName_should_return_true_for_length_3() {
        assertTrue(starberks.isValidProductName("abc"));
    }

    @Test
    public void isValidName_should_return_true_for_length_10() {
        assertTrue(starberks.isValidProductName("0123456789"));
    }

    @Test
    public void isValidName_should_return_false_for_length_below_3() {
        assertFalse(starberks.isValidProductName("12"));
    }

    @Test
    public void isValidName_should_return_false_for_length_above_10() {
        assertFalse(starberks.isValidProductName("0123456789a"));
    }

    @Test
    public void readValidName_sanity_test() {
        String name = "coffee";
        assertEquals(name, starberks.readValidProductName(new Scanner("12\n0123456789a\n" + name)));
    }
}
