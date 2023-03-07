package com.gildedrose

class GildedRose(var items: Array[Item]) {

  private def clampQuality(quality: Int): Int = quality match {
    case q if q > 50 => 50
    case q if q < 0  => 0
    case _           => quality
  }

  def updateQuality() {
    items = for (item <- items) yield item match {
      case Default(_, _) => {
        val sellIn = item.sellIn - 1

        val quality_delta_amount = if (sellIn < 0) -2 else -1
        val quality = clampQuality(item.quality + quality_delta_amount)

        Default(sellIn, quality)
      }
      case AgedBrie(_, _) => {
        val sellIn = item.sellIn - 1

        val quality_delta_amount = 1
        val quality = clampQuality(item.quality + quality_delta_amount)

        AgedBrie(sellIn, quality)
      }
      case Sulfuras() => {
        item
      }
    }
  }
}
