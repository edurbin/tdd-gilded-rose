package com.gildedrose.strategy;

import com.gildedrose.Item;

public class DefaultQualityUpdateStrategy implements QualityUpdateStrategy {
	@Override
	public Item updateQuality(Item item) {
		if (itemQualityIsGreaterThanZero(item)) {
			decrementItemQuality(item);
		}

		decrementSellIn(item);

		if (item.sellIn < 0) {
			if (itemQualityIsGreaterThanZero(item)) {
				decrementItemQuality(item);
			}
		}
		return item;
	}

	protected boolean itemQualityIsLessThanFifty(Item item) {
		return item.quality < 50;
	}

	protected void incrementItemQuality(Item item) {
		item.quality = item.quality + 1;
	}
	
	protected int decrementItemQuality(Item item) {
		return item.quality = item.quality - 1;
	}

	protected boolean itemQualityIsGreaterThanZero(Item item) {
		return item.quality > 0;
	}
	
	protected int decrementSellIn(Item item) {
		return item.sellIn = item.sellIn - 1;
	}
}
