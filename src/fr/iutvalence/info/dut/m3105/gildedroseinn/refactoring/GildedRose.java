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
        if (item.isLegendary()) {
            return;
        }

        item.updateSellIn();
        updateQualityForItem(item);
    }

    private static void updateQualityForItem(final Item item) {
        item.updateQuality(getQualityDeltaForItem(item));
    }

    private static int getQualityDeltaForItem(final Item item) {
        switch (item.getName()) {
            case "Aged Brie":
                return 1;
            case "Backstage passes": {
                final int sellIn = item.getSellIn();

                if (sellIn <= 0) {
                    return -item.getQuality();
                }

                if (sellIn <= 5) {
                    return 3;
                }

                if (sellIn <= 10) {
                    return 2;
                }

                return 1;
            }
            case "Conjured":
                return -2;
            default:
                return item.isPerished() ? -2 : -1;
        }
    }
}
