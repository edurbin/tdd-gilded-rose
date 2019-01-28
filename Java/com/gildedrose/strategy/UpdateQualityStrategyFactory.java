package com.gildedrose.strategy;

import com.gildedrose.Item;

public enum UpdateQualityStrategyFactory {
	INSTANCE;
	
	public QualityUpdateStrategy getUpdateQualityStrategy(Item item) {
		QualityUpdateStrategy strategy = null;
		switch (item.name) {
		case "Aged Brie":
			strategy = new AgedBrieQualityUpdateStrategy();
			break;
		case "Backstage passes to a TAFKAL80ETC concert":
			strategy = new BackstagePassQualityUpdateStrategy();
			break;
		case "Sulfuras, Hand of Ragnaros":
			strategy = new SulfurasQualityUpdateStrategy();
			break;
		case "Conjured Mana Cake":
			strategy = new ConjuredQualityUpdateStrategy();
			break;
		default:
			strategy = new DefaultQualityUpdateStrategy();
		}
		return strategy;
	}
}
