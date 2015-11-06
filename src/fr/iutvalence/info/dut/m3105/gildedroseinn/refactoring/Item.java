package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

/**
 * Item sold by {@link GildedRose}: name, sell in and quality.
 *
 * @author Sebastien JEAN
 * @version 1.0.0
 */
public final class Item {
    /** Product name. */
    private String m_name;
    /** Number of days before the product is perished. */
    private int    m_sellIn;
    /** Product price. */
    private int    m_quality;

    public Item(final String name, final int sellIn, final int quality) {
        m_name = name;
        m_sellIn = sellIn;
        m_quality = quality;
    }

    @Override
    public String toString() {
        return String.format("%s (%d/%d)", m_name, m_sellIn, m_quality);
    }

    public String getName() {
        return m_name;
    }

    public void setName(final String name) {
        m_name = name;
    }

    public int getSellIn() {
        return m_sellIn;
    }

    public void setSellIn(final int sellIn) {
        m_sellIn = sellIn;
    }

    public int getQuality() {
        return m_quality;
    }

    public void setQuality(final int quality) {
        m_quality = quality;
    }
}
