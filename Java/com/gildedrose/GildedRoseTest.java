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
	
	@Test
	public void sellDateHasPassedQualityDegradesTwiceAsFast() {
		Item[] items = new Item[] {new Item("MyItem", 0, 2)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(0, items[0].quality);
		assertEquals(-1, items[0].sellIn);
	}
	
	@Test
	public void qualityOfItemIsNeverNegative() {
		Item[] items = new Item[] {new Item("MyItem", 1, 0)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(0, items[0].quality);
	}
}
