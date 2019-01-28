package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieQualityUpdateStrategy extends DefaultQualityUpdateStrategy implements QualityUpdateStrategy {

	@Override
	public Item updateQuality(Item item) {
		if (itemQualityIsLessThanFifty(item)) {
			incrementItemQuality(item);
		}
		decrementSellIn(item);

		if (item.sellIn < 0 && itemQualityIsLessThanFifty(item)) {
			incrementItemQuality(item);
		}
		return item;
	}

}
