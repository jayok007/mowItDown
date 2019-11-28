package mowItNow

import java.io.FileNotFoundException

import scala.io.Source

object Loader {
  val directionMap = Map[Char,Direction.Value]('N' -> Direction.N, 'W' -> Direction.W, 'S' -> Direction.S, 'E' -> Direction.E)

  /**
   * Convert a character to a direction
   * @param char
   * @return
   */
  private def toDirection(char: Char): Direction.Value = {
    return directionMap.get(char.toUpper).get
  }

  /**
   * Read the file and return a garden
   * @param filename
   * @return
   */
  def readFile(filename: String): Garden = {

    try{
      val lines = Source.fromFile(filename).getLines.toArray
      val firstLine = lines(0).split(" ")

      val gridX = firstLine(0).toInt
      val gridY = firstLine(1).toInt

      val garden = new Garden(gridX, gridY)

      for (i <- 1 until lines.length by 2) {
        val line_1 = lines(i).split(" ")
        val mower = new Mower(line_1(0).toInt, line_1(1).toInt, directionMap.get(line_1(2)(0)).get)
        for(c <- lines(i+1)) mower.addCommand(c)
        garden.addMower(mower)
      }
      return garden
    } catch {
      case _ : FileNotFoundException => println("The file you tried to load doesn't exists");
      case _ => println("Your input file is not well formatted");
    }
    // If an error append return null
    return null

  }
}
