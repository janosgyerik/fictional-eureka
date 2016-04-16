package com.janosgyerik.examples.codementor.starberks;

import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {
    @Test
    public void calculateBestReplenishmentQuantity_should_return_129_for_45_6_3() {
        assertEquals(129, new Store().calculateBestReplenishmentQuantity(45, 6, 3));
    }

    @Test
    public void calculateBestReplenishmentQuantity_should_return_84_for_45_6_2() {
        assertEquals(84, new Store().calculateBestReplenishmentQuantity(45, 6, 2));
    }
}
