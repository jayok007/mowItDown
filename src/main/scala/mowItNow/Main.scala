package mowItNow


object Main {
  def main(args: Array[String]): Unit = {
    // Check arguments
    if(args.length != 1) {
      println("Usage: Main filePath")
      return
    }
    // Read garden with filepath passed as parameter
    val garden = Loader.readFile(args(0))
    // If the loading didn't work it returns null as value
    if (garden != null){
      garden.executeMowers()
    }
  }
}
