package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.List;

/**
 * GildedRose store.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public final class GildedRose {
    /** Forbidden constructor. */
    private GildedRose() {}

    /**
     * Day's end update of all the items.
     *
     * @param items list of items to update
     *
     * @see Item
     */
    public static void updateItems(final List<Item> items) {
        for (final Item item : items) {
            updateItem(item);
        }
    }

    /**
     * Day's end update of an item.
     *
     * @param item item to update
     *
     * @see Item
     */
    public static void updateItem(final Item item) {
        item.setQuality(item.getQuality() - 1);
        item.setSellIn(item.getSellIn() - 1);
    }
}
