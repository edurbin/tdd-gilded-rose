package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassQualityUpdateStrategy extends DefaultQualityUpdateStrategy implements QualityUpdateStrategy {

	@Override
	public Item updateQuality(Item item) {
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
		return item;
	}


}
