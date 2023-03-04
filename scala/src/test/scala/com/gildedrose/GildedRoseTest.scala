package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest  extends AnyFlatSpec with Matchers {

  it should "Item object reflect name" in {
    val items = Array[Item](new Item("foo", 0, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0).name should equal ("foo")
  }
  
  it should "Default sellIn should decrement daily" in {
    val items = Array[Item](new Item("foo", 1, 0))
    val app = new GildedRose(items)
    app.updateQualityNew()
    app.items(0) should equal (new Item("foo", 0, 0))
  }

  it should "Default quality should decrement daily" in {

    val items = Array[Item](
      new Item("foo", 1, 51),
      new Item("foo", 1, -1)
    )

    val app = new GildedRose(items)
    app.updateQualityNew()

    val expect = Array[Item](
     new Item("foo", 0, 50), 
     new Item("foo", 0, 0)
    )

    app.items should equal (expect)
  }

  it should "Aged Brie should increment" in {
    val items = Array[Item](new Item("Aged Brie", 1, 0))
    val app = new GildedRose(items)
    app.updateQualityNew()
    app.items(0) should equal (new Item("Aged Brie", 0, 1))
    app.updateQualityNew()
    app.items(0) should equal (new Item("Aged Brie", -1, 3))
  }

}
