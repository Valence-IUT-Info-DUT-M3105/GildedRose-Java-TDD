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
        final int sellIn = item.getSellIn();
        final int qualityCoeff;

        switch (item.getName()) {
            case "Aged Brie": {
                qualityCoeff = -1;
                break;
            }
            case "Backstage passes": {
                if (sellIn <= 0) {
                    qualityCoeff = item.getQuality();
                }
                else {
                    if (sellIn <= 5) {
                        qualityCoeff = -3;
                    }
                    else {
                        qualityCoeff = (sellIn <= 10) ? -2 : -1;
                    }
                }
                break;
            }
            default:
                qualityCoeff = item.isPerished() ? 2 : 1;
                break;
        }
        item.updateQuality(-1 * qualityCoeff);
    }

    private static void updateSellInForItem(final Item item) { item.updateSellIn(-1); }
}
