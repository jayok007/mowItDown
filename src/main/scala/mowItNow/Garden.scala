package mowItNow

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer


class Garden(x : Int, y : Int) {
  val mowers = new mutable.Queue[Mower]();

  /**
   * Add a mowert to the garder
   * @param mower
   * @return
   */
  def addMower(mower : Mower) = {
    mowers.addOne(mower)
    this
  }

  /**
   * Execute commands and print position for all mowers
   */
  def executeMoyers(): Unit ={
    for(mower <- mowers) {
      // Execute commands
      mower.executeCommands(this.x, this.y)
      // Print position
      mower.toString
    }
  }

}
