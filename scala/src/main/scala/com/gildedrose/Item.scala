package com.gildedrose

trait Item {
  val name: String
  val sellIn: Int
  val quality: Int
}

// how to rm the repetition?
case class Default(sellIn: Int, quality: Int) extends Item {
  val name = "Default"
}
case class AgedBrie(sellIn: Int, quality: Int) extends Item {
  val name = "Aged Brie"
}
case class Sulfuras() extends Item {
  val name = "Sulfuras"
  val quality = 80
  val sellIn = 0
}
