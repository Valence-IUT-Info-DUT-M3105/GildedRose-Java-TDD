package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * {@link Item} test class.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class ItemTest {

    private Item m_item;

    @Before
    public void setUp() {
        m_item = new Item("dummy", 1, 2);
    }

    @Test
    public void testGetName() {
        assertEquals("dummy", m_item.getName());
    }

    @Test
    public void testSetName() {
        m_item.setName("dummy2");
        assertEquals("dummy2", m_item.getName());
    }

    @Test
    public void testGetSellIn() {
        assertEquals(1, m_item.getSellIn());
    }

    @Test
    public void testSetSellIn() {
        m_item.updateSellIn(1);
        assertEquals(2, m_item.getSellIn());
        m_item.updateSellIn(-1);
        assertEquals(1, m_item.getSellIn());
    }

    @Test
    public void testGetQuality() {
        assertEquals(2, m_item.getQuality());
    }

    @Test
    public void testSetQuality() {
        m_item.updateQuality(1);
        assertEquals(3, m_item.getQuality());
        m_item.updateQuality(-1);
        assertEquals(2, m_item.getQuality());
    }
}
