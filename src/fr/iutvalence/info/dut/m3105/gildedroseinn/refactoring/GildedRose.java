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

        updateSellInForItem(item);
        updateQualityForItem(item);
    }

    private static void updateQualityForItem(final Item item) {
        final int qualityCoeff = getQualityCoeff(item);
        item.updateQuality(-1 * qualityCoeff);
    }

    private static int getQualityCoeff(final Item item) {

        switch (item.getName()) {
            case "Aged Brie":
                return -1;
            case "Backstage passes": {
                final int sellIn = item.getSellIn();

                if (sellIn <= 0) {
                    return item.getQuality();
                }

                if (sellIn <= 5) {
                    return -3;
                }

                return (sellIn <= 10) ? -2 : -1;
            }
            default:
                return item.isPerished() ? 2 : 1;
        }
    }

    private static void updateSellInForItem(final Item item) { item.updateSellIn(-1); }
}
