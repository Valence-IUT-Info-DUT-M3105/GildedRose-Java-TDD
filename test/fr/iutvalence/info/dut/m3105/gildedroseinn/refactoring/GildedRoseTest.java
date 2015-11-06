package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * {@link GildedRose} test class.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class GildedRoseTest {
    /** Number of steps used to validate the update. */
    private static final int NUMBER_OF_VALIDATION_STEPS = 5;

    @Test
    public void endOfDayWithoutItemTest() {
        final Collection<Item> items = new ArrayList<>(0);
        GildedRose.updateItems(items);
        assertEquals(0, items.size());
    }

    @Test
    public void endOfDayForSeveralItemsTest() {
        final Collection<Item> items = new ArrayList<>(3);
        items.add(new Item("a", 1, 2));
        items.add(new Item("b", 1, 2));
        items.add(new Item("c", 1, 2));

        for (int day = 1; day <= NUMBER_OF_VALIDATION_STEPS; day++) {
            GildedRose.updateItems(items);
            for (final Item item : items) {
                assertEquals(1 - day, item.getSellIn());
                assertEquals(2 - day, item.getQuality());
            }
        }
    }
}
