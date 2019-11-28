package mowItNow

import scala.collection.mutable

class Garden(x : Int, y : Int) {
  val mowers: mutable.Queue[Mower] = new mutable.Queue[Mower]()

  /**
   * Add a mower to the garden
   * @param mower Mower
   * @return
   */
  def addMower(mower : Mower): Garden = {
    mowers.addOne(mower)
    this
  }

  /**
   * Execute commands and print position for all mowers
   */
  def executeMowers(): Unit ={
    for(mower <- mowers) {
      // Execute commands
      mower.executeCommands(this.x, this.y)
      // Print position
      mower.toString
    }
  }

}
