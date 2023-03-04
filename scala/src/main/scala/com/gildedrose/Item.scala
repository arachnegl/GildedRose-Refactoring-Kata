package com.gildedrose


abstract class AbstractItem(name: String, sellIn: Int, quality: Int) {

    def update()

    override def equals(that: Any): Boolean =
      that match {
        case that: AbstractItem => this.stringHash == that.stringHash
        case _ => false
     }

    private def stringHash:String = {
      return s"$name$sellIn$quality"
    }

    override def toString:String = {
      return s"$name-$sellIn-$quality"
    }

}


class Item(val name: String, var sellIn: Int, var quality: Int) extends AbstractItem(name, sellIn, quality) {
    val quality_delta = -1

    private def update_quality() {
      if (sellIn >= 0) {
        quality += quality_delta
      } else {
        quality += quality_delta * 2
      }
    }

    def update() {

      sellIn -= 1

      update_quality()

      if (quality < 0) quality = 0
      if (quality > 50) quality = 50
        
      assert(quality >= 0, s"quality can't be negative. $quality")
      assert(quality <= 50, s"quality is never over 50. $quality")
    }

}


class AgedBrie(sellIn: Int, quality: Int) extends Item ("AgedBrie", sellIn, quality) {
    override val quality_delta = 1
}


class Sulfuras(val sellIn: Int) extends AbstractItem ("Sulfuras", sellIn, 80) {
	// - "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    def update() {}
}
