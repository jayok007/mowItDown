package mowItNow
//kaarouimourad@gmail.com
// Projet Scala - IMSD 2019/2020


object Main extends App {
  val garden = Loader.readFile("/home/jayok/Documents/test")
  // If the loading didn't work it returns null as value
  if (garden != null){
    garden.executeMoyers()

  }
}
