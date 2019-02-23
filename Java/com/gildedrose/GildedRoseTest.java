package com.gildedrose;

import static org.junit.Assert.*;
import static com.gildedrose.ItemNames.*;
import org.junit.Test;

public class GildedRoseTest {
	private static final String MY_ITEM = "MyItem";
	@Test
	public void updateQualityShouldDecrementQualityAndSellIn() {
		Item[] items = new Item[] {new Item(MY_ITEM, 1, 1)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(0, items[0].quality);
		assertEquals(0, items[0].sellIn);
	}
	
	@Test
	public void sellDateHasPassedQualityDegradesTwiceAsFast() {
		Item[] items = new Item[] {new Item(MY_ITEM, 0, 2)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(0, items[0].quality);
		assertEquals(-1, items[0].sellIn);
	}
	
	@Test
	public void qualityOfItemIsNeverNegative() {
		Item[] items = new Item[] {new Item(MY_ITEM, 1, 0)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(0, items[0].quality);
	}
	
	@Test
	public void agedBrieIncreasesInQualityWithAge() {
		Item[] items = new Item[] {new Item(AGED_BRIE, 1, 0)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(1, items[0].quality);
	}
	
	@Test
	public void qualityOfItemIsNeverMoreThanFifty() {
		Item[] items = new Item[] {new Item(AGED_BRIE, 1, 50)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(50, items[0].quality);
	}
	
	@Test
	public void sulfurasNeverHasToBeSoldOrDecreasesInQuality() {
		Item[] items = new Item[] {new Item(SULFURAS, 1, 80)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(80, items[0].quality);
	}
	
	@Test
	public void backstagePassIncreasesInQualityAsSellInApproaches() {
		Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, 11, 1)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(2, items[0].quality);
	}
	
	@Test
	public void backstagePassQualityIncreasesByTwoWithLessThanTenDays() {
		Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, 9, 1)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(3, items[0].quality);
	}
	
	@Test
	public void backstagePassQualityIncreasesByThreeWithLessThanFiveDays() {
		Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, 4, 1)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(4, items[0].quality);
	}
	
	@Test
	public void backstagePassQualityDropsToZeroAfterConcert() {
		Item[] items = new Item[] {new Item(BACKSTAGE_PASSES, 0, 1)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(0, items[0].quality);
	}
	
	@Test public void conjuredItemsDegradeTwiceAsFastAsNormalItems() {
		Item[] items = new Item[] {new Item(CONJURED_MANA, 2, 4)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(2, items[0].quality);
	}
}
