package mowItNow

import scala.collection.mutable

class Mower(var x: Int,var y: Int, var direction: Direction.Value){
  /**
   * Contains all the commands of the mower
   */
  private val programmedCommands = mutable.Queue[Char]()

  /**
   * Forward action, check if it's still in the garden space or not
   * @param maxX
   * @param maxY
   */
  def A(maxX : Int, maxY : Int): Unit  = {
    direction match {
        case Direction.N => if(y < maxY) y+=1
        case Direction.S => if(y > 0) y-=1
        case Direction.E => if(x < maxX) x+=1
        case Direction.W => if(x > 0) x-=1
    }
  }

  /**
   * Left action, just rotate the direction
   */
  def G: Unit = {
    direction match {
      case Direction.N => direction = Direction.W
      case Direction.S => direction = Direction.E
      case Direction.E => direction = Direction.N
      case Direction.W => direction = Direction.S
    }
  }

  /**
   * Right action, just rotate the direction
   */
  def D: Unit = {
    direction match {
      case Direction.N => direction = Direction.E
      case Direction.S => direction = Direction.W
      case Direction.E => direction = Direction.S
      case Direction.W => direction = Direction.N
    }
  }

  /**
   * Add a command to the Mower
   * @param command
   */
  def addCommand(command: Char): Unit ={
    programmedCommands.addOne(command)
  }

  /**
   * Execute all commands related
   * @param gridSizeX
   * @param gridSizeY
   */
  def executeCommands(gridSizeX:Int, gridSizeY:Int): Unit ={
    while (programmedCommands.length > 0){
      val command = programmedCommands.dequeue()
      command match {
        case 'A' => this.A(gridSizeX, gridSizeY)
        case 'G' => this.G
        case 'D' => this.D
        case _ => throw new IllegalArgumentException(s"This opperation is not supported $x")
      }
    }
    println(this)
  }

  override def toString: String = {
  return s"Moyer ${x} ${y} ${direction}"
  }
}
