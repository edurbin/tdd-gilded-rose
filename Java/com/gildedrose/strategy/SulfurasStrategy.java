package com.gildedrose.strategy;

import com.gildedrose.Item;

public class SulfurasStrategy implements QualityUpdateStrategy {

	@Override
	public Item updateQuality(Item item) {
		return item;
	}

}
