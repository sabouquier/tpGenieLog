package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }
  
  @Test
  @DisplayName("Test that the quality is unchanged")
  void testQuality() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test that the sellIn is changed when name !equals Sulfuras..")
  void testSellIn() {
    Item element = new Item("foo", 10, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(9));
  }

  @Test
  @DisplayName("Test that the sellIn is changed when name equals Sulfuras..")
  void testSellInSulfuras() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 10, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(10));
  }

  @Test
  @DisplayName("Test that quality change if name aged brie and <50 ")
  void testQualitAgedBackstageSellIn12() {
    Item element1 = new Item("Aged Brie", 10, 0);
    Item element2 = new Item("Aged Brie", 0, 50);


    GildedRose app = new GildedRose(new Item[] {element1,element2});
    app.updateQuality();
    assertThat(element1.quality, is(1));
    assertThat(element2.quality, is(50));

  }

  @Test
  @DisplayName("Test that quality change if name aged brie sellin <0  ")
  void testQualitAgedSellinNeg() {
    Item element1 = new Item("Aged Brie", -5, 0);
    Item element2 = new Item("Aged Brie", -5, 50);


    GildedRose app = new GildedRose(new Item[] {element1,element2});
    app.updateQuality();
    assertThat(element1.quality, is(2));
    assertThat(element2.quality, is(50));



  }


  @Test
  @DisplayName("Test that backstage quality ++ ")
  void testQualitBackstage() {
    Item element0 = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 0);
    Item element1 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);
    Item element2 = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    Item element3 = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 0);
    Item element4 = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
    Item element5 = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 51);

    

    GildedRose app = new GildedRose(new Item[] {element0, element1, element2, element3, element4, element5});
    app.updateQuality();
    assertThat(element0.quality, is(1));
    assertThat(element1.quality, is(2));
    assertThat(element2.quality, is(50));
    assertThat(element3.quality, is(3));
    assertThat(element4.quality, is(50));
    assertThat(element5.quality, is(0));



  }

  @Test
  @DisplayName("Test that quality update if name sulfuras ")
  void testQualitNotSulfuras() {
    Item element0 = new Item("Sulfuras, Hand of Ragnaros", 4, 1);
    Item element1 = new Item("Foo", 4, 1);
    Item element2 = new Item("Sulfuras, Hand of Ragnaros", -1, 10);
    Item element3 = new Item("foo", -1, 10);

    GildedRose app = new GildedRose(new Item[] {element0, element1, element2, element3});
    app.updateQuality();
    assertThat(element0.quality, is(1));
    assertThat(element1.quality, is(0));
    assertThat(element2.quality, is(10));
    assertThat(element3.quality, is(8));


  }



}
