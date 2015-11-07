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
        final Item item = new Item("a", 5, 0);

        m_items.add(item);

        for (int day = 1; day <= 5; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(0, item.getQuality());
            assertEquals(5 - day, item.getSellIn());
        }
    }

    @Test
    public void cantHaveCostlyItemTest() {
        final Item item = new Item("Aged Brie", 10, 50);

        m_items.add(item);

        for (int day = 1; day <= 10; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(50, item.getQuality());
            assertEquals(10 - day, item.getSellIn());
        }
    }

    @Test
    public void agedBrieIsSpecialTest() {
        final Item item = new Item("Aged Brie", 10, 0);

        m_items.add(item);

        for (int day = 1; day <= 10; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(day, item.getQuality());
            assertEquals(10 - day, item.getSellIn());
        }
    }

    @Test
    public void legendaryItemsAreLegendariesTest() {
        final Item item = new Item("Sulfuras", 10, 20);

        m_items.add(item);

        for (int day = 1; day <= 10; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(20, item.getQuality());
            assertEquals(10, item.getSellIn());
        }
    }

    @Test
    public void backstageTest() {
        final Item item = new Item("Backstage passes", 20, 10);

        m_items.add(item);

        for (int day = 1; day <= 10; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(10 + day, item.getQuality());
        }

        for (int day = 1; day <= 5; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(20 + 2 * day, item.getQuality());
        }

        for (int day = 1; day <= 5; day++) {
            GildedRose.updateItems(m_items);
            assertEquals(30 + 3 * day, item.getQuality());
        }

        GildedRose.updateItems(m_items);
        assertEquals(0, item.getQuality());
    }
}
