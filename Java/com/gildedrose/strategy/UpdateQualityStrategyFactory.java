package com.gildedrose.strategy;

import com.gildedrose.Item;
import static com.gildedrose.ItemNames.*;

public enum UpdateQualityStrategyFactory {
	INSTANCE;
	
	public QualityUpdateStrategy getUpdateQualityStrategy(Item item) {
		QualityUpdateStrategy strategy = null;
		switch (item.name) {
		case AGED_BRIE:
			strategy = new AgedBrieQualityUpdateStrategy();
			break;
		case BACKSTAGE_PASSES:
			strategy = new BackstagePassQualityUpdateStrategy();
			break;
		case SULFURAS:
			strategy = new SulfurasQualityUpdateStrategy();
			break;
		case CONJURED_MANA:
			strategy = new ConjuredQualityUpdateStrategy();
			break;
		default:
			strategy = new DefaultQualityUpdateStrategy();
		}
		return strategy;
	}
}
