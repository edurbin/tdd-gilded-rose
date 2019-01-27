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
	
	@Test
	public void agedBrieIncreasesInQualityWithAge() {
		Item[] items = new Item[] {new Item("Aged Brie", 1, 0)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(1, items[0].quality);
	}
	
	@Test
	public void qualityOfItemIsNeverMoreThanFifty() {
		Item[] items = new Item[] {new Item("Aged Brie", 1, 50)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(50, items[0].quality);
	}
	
	@Test
	public void sulfurasNeverHasToBeSoldOrDecreasesInQuality() {
		Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 1, 80)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(80, items[0].quality);
	}
	
	@Test
	public void backstagePassIncreasesInQualityAsSellInApproaches() {
		Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1)};
		GildedRose gildedRose = new GildedRose(items);
		gildedRose.updateQuality();
		assertEquals(2, items[0].quality);
	}
}
