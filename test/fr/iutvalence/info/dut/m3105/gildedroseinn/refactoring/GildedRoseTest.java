package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

/**
 * {@link GildedRose} test class.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class GildedRoseTest {
    /** List of items used in each test. */
    private Collection<Item> m_items;

    @Before
    public void setUp() throws Exception {
        m_items = new LinkedList<>();
    }

    @Test
    public void endOfDayWithoutItemTest() {
        GildedRose.updateItems(m_items);
        assertEquals(0, m_items.size());
    }

    @Test
    public void endOfDayForSeveralItemsTest() {
        m_items.add(new Item("a", 5, 15));
        m_items.add(new Item("b", 5, 15));
        m_items.add(new Item("c", 5, 15));

        for (int day = 1; day <= 10; day++) {
            GildedRose.updateItems(m_items);
            for (final Item item : m_items) {
                assertEquals(15 - day - ((day > 5) ? (day - 5) : 0), item.getQuality());
                assertEquals(5 - day, item.getSellIn());
            }
        }
    }

    @Test
    public void cantHaveNegativeQualityTest() {
        m_items.add(new Item("a", 5, 0));
        m_items.add(new Item("b", 5, 0));
        m_items.add(new Item("c", 5, 0));

        for (int day = 1; day <= 5; day++) {
            GildedRose.updateItems(m_items);
            for (final Item item : m_items) {
                assertEquals(0, item.getQuality());
                assertEquals(5 - day, item.getSellIn());
            }
        }
    }

    @Test
    public void agedBrieIsSpecialTest() {
        final Item item = new Item("Aged Brie", 10, 0);
        m_items.add(item);

        for (int day = 1; day <= 10; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(day, item.getQuality());

        }
    }
}
