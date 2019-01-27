package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (itemQualityIsGreaterThanZero(item)) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decrementItemQuality(item);
                    }
                }
            } else {
                if (itemQualityIsLessThanFifty(item)) {
                    incrementItemQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (itemQualityIsLessThanFifty(item)) {
                                incrementItemQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (itemQualityIsLessThanFifty(item)) {
                                incrementItemQuality(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (itemQualityIsGreaterThanZero(item)) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decrementItemQuality(item);
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (itemQualityIsLessThanFifty(item)) {
                        incrementItemQuality(item);
                    }
                }
            }
        }
    }

	private boolean itemQualityIsLessThanFifty(Item item) {
		return item.quality < 50;
	}

	private void incrementItemQuality(Item item) {
		item.quality = item.quality + 1;
	}

	private int decrementItemQuality(Item item) {
		return item.quality = item.quality - 1;
	}

	private boolean itemQualityIsGreaterThanZero(Item item) {
		return item.quality > 0;
	}
}
