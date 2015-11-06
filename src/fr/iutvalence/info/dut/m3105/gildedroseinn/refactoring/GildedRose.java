package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.List;

/**
 * GildedRose store.
 *
 * @author Anthony GELIBERT
 * @version 1.0.0
 */
public class GildedRose {
    /** Forbidden constructor. */
    private GildedRose() {}

    /**
     * Day's end update of all the items.
     *
     * @param items list of items to update
     *
     * @see Item
     */
    public static void updateItems(List<Item> items) {
        for (int indexInItemList = 0; indexInItemList < items.size(); indexInItemList++) {
            updateItem(items.get(indexInItemList));
        }
    }

    /**
     * Day's end update of an item.
     *
     * @param item item to update
     *
     * @see Item
     */
    public static void updateItem(Item item) {
        item.setQuality(item.getQuality() - 1);
        item.setSellIn(item.getSellIn() - 1);
    }
}
