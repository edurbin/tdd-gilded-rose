package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

	@Test
	public void updateQualityShouldDecrementQualityAndSellIn() {
		Item[] items = new Item[] {new Item("MyItem", 1, 1)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(0, items[0].quality);
		assertEquals(0, items[0].sellIn);
	}
	
}
