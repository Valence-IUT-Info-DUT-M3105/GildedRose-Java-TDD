package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

/**
 * Item sold by {@link GildedRose}: name, sell in and quality.
 *
 * @author Sebastien JEAN
 * @version 1.0.0
 */
public class Item {
    /** Product name. */
    private String name;
    /** Number of days before the product is perished. */
    private int    sellIn;
    /** Product price. */
    private int    quality;

    public Item(String name, int sellIn, int quality) {
        this.setName(name);
        this.setSellIn(sellIn);
        this.setQuality(quality);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSellIn() {
        return this.sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
