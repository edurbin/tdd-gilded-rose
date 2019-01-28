package com.gildedrose;

import com.gildedrose.strategy.QualityUpdateStrategy;
import com.gildedrose.strategy.UpdateQualityStrategyFactory;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item: items) {
			QualityUpdateStrategy updateStrategy = UpdateQualityStrategyFactory.INSTANCE.getUpdateQualityStrategy(item);
			item = updateStrategy.updateQuality(item);
		}
	}
}
