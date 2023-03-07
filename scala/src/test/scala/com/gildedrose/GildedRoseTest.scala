package com.gildedrose

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GildedRoseTest extends AnyFlatSpec with Matchers {

  it should "Default" in {
    val items = Array[Item](Default(1, 1))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0) should equal(Default(0, 0))
  }

  it should "Aged Brie" in {
    val items = Array[Item](AgedBrie(1, 0))
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0) should equal(AgedBrie(0, 1))
    app.updateQuality()
    app.items(0) should equal(AgedBrie(-1, 2))
  }

  it should "Sulfuras" in {
    val items = Array[Item](Sulfuras())
    val app = new GildedRose(items)
    app.updateQuality()
    app.items(0) should equal(Sulfuras())
    app.updateQuality()
    app.items(0) should equal(Sulfuras())
  }

}
