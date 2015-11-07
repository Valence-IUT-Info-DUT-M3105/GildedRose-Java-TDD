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

    /**
     * New item with the given information.
     *
     * @param name    Product's name
     * @param sellIn  Product's sell in
     * @param quality Product's quality <b>(ALWAYS > 0)</b>
     */
    public Item(final String name, final int sellIn, final int quality) {
        assert quality >= 0 : "You try to create an item with a negative quality";
        assert quality <= 50 : "You try to create an item with a quality > 50";

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

    public void updateSellIn(final int delta) {
        m_sellIn += delta;
    }

    public int getQuality() {
        return m_quality;
    }

    public void updateQuality(final int delta) {
        m_quality += delta;
        if (m_quality < 0) { m_quality = 0; }
        if (m_quality > 50) { m_quality = 50; }
    }

    public boolean isPerished() {
        return m_sellIn < 0;
    }

    public boolean isLegendary() {
        return "Sulfuras".equals(m_name);
    }
}
