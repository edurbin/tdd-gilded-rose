package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredQualityUpdateStrategy extends DefaultQualityUpdateStrategy implements QualityUpdateStrategy {

	@Override
	public Item updateQuality(Item item) {
		return super.updateQuality(item);
	}
	
	protected int decrementItemQuality(Item item) {
		return item.quality = item.quality - 2;
	}
}
