package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

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
    public static void updateItems(final Iterable<Item> items) {
        items.forEach(GildedRose::updateItem);
    }

    /**
     * Day's end update of an item.
     *
     * @param item item to update
     *
     * @see Item
     */
    public static void updateItem(final Item item) {
        updateSellInForItem(item);
        updateQualityForItem(item);
    }

    private static void updateQualityForItem(final Item item) {
        final int qualityCoeff;
        if ("Aged Brie".equals(item.getName())) { // NON-NLS
            qualityCoeff = -1;
        }
        else {
            qualityCoeff = item.isPerished() ? 2 : 1;
        }
        item.updateQuality(-1 * qualityCoeff);
    }

    private static void updateSellInForItem(final Item item) { item.updateSellIn(-1); }
}
