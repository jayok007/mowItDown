package mowItNow

import java.io.FileNotFoundException

import scala.io.Source

object Loader {
  val directionMap: Map[Char, Direction.Value] = Map[Char,Direction.Value]('N' -> Direction.N, 'W' -> Direction.W, 'S' -> Direction.S, 'E' -> Direction.E)

  /**
   * Convert a character to a direction
   * @param char direction as a char
   * @return direction as type Direction.Value
   */
  private def toDirection(char: Char): Direction.Value = {
    directionMap(char.toUpper)
  }

  /**
   * Read the file and return a garden
   * @param filename filepath of the file to read
   * @return A garden or null if something wrong happened
   */
  def readFile(filename: String): Garden = {

    try{
      // Read all line
      val source = Source.fromFile(filename)
      val lines: Array[String] = source.getLines.toArray
      source.close()

      // Get garden size
      val firstLine = lines(0).split(" ")
      val gridX = firstLine(0).toInt
      val gridY = firstLine(1).toInt

      val garden = new Garden(gridX, gridY)

      // For each 2 line add new mower
      for (i <- 1 until lines.length by 2) {
        val line_1 = lines(i).split(" ")
        val mower = new Mower(line_1(0).toInt, line_1(1).toInt, directionMap(line_1(2)(0)))
        for(c <- lines(i+1)) mower.addCommand(c)
        garden.addMower(mower)
      }
      return garden
    } catch {
      // Handle exceptions
      case _ : FileNotFoundException => println("The file you tried to load doesn't exists");
      case _ : Throwable => println("Your input file is not well formatted");
    }
    // If an error append return null
    null
  }
}
