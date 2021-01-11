package com.gildedrose;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseTest {

    @Test
    public void testSellInIsDecreased() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void testQualityIsDecreased() {
        Item[] items = new Item[]{new Item("foo", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testQualityDecreaseTwiceAsFastWhenSellDateIsOver() {
        Item[] items = new Item[]{new Item("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test
    public void testQualityShouldNeverBeNegative() {
        Item[] items = new Item[]{new Item("foo", 1, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void testAgedBrieQualityIncreaseWithTime()  {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testAgedBrieQualityIncreaseWithTimeAfterSellInIsPassed()  {
        Item[] items = new Item[]{new Item("Aged Brie", 0, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void testQualityIsNeverMoreThanFifty()  {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void testSulfurasQualityIsNeverDecreased() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1,app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreaseWithTime()  {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 11, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreaseTwiceFasterWithTimeWhenSellInIsTenOrLess()  {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 6, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIncreaseThreeTimesFasterWithTimeWhenSellInIsFiveOrLess()  {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void testBackstagePassesQualityIsZeroWhenSellInIsZero()  {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    @Disabled
    public void testConjuredProducts()  {
        Item[] items = new Item[]{new Item("Conjured Mana Cake", 1, 2)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0,app.items[0].quality);
    }
}
