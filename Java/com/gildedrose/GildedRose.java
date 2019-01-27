package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
        	if(itemIsSulfuras(item)) {
        		continue;
        	}
        	
        	if(itemIsBackstagePasses(item)) {
        		if (itemQualityIsLessThanFifty(item)) {
        			incrementItemQuality(item);
                    if (item.sellIn < 11) {
                    	incrementItemQuality(item);
                    	
                        if (item.sellIn < 6) {
                            incrementItemQuality(item);
                        }
                    }
        		}
                decrementSellIn(item);
                if (item.sellIn < 0) {
                	item.quality = item.quality - item.quality;
                }
        	} else {
                if (!itemIsAgedBrie(item)) {
                    if (itemQualityIsGreaterThanZero(item)) {
                    	decrementItemQuality(item);
                    }
                } else {
                    if (itemQualityIsLessThanFifty(item)) {
                        incrementItemQuality(item);
                    }
                }
                
                decrementSellIn(item);
                
            	if (item.sellIn < 0) {
            		if (!itemIsAgedBrie(item)) {
            			if (itemQualityIsGreaterThanZero(item)) {
            				decrementItemQuality(item);
            			}
            		} else {
            			if (itemQualityIsLessThanFifty(item)) {
            				incrementItemQuality(item);
            			}
            		}
            	}
        	}
        }
    }

	private int decrementSellIn(Item item) {
		return item.sellIn = item.sellIn - 1;
	}

	private boolean itemIsAgedBrie(Item item) {
		return item.name.equals("Aged Brie");
	}

	private boolean itemIsBackstagePasses(Item item) {
		return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
	}

	private boolean itemIsSulfuras(Item item) {
		return item.name.equals("Sulfuras, Hand of Ragnaros");
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
