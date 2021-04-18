package application

import model.{Satellite, Solo_satellite}
import upickle.default._
import utils.JsonUtils

object ApplicationService {
  def process(): Unit = {
    //lire les données - HTTP
    //parser Json
    //Creer les objets
    //Renvoyer en BDD
    val sl = new Solo_satellite(1, "test", "15-05-05", "1-1-1-1", "2-2-2-2")
    val sat = new Satellite(1500, List(sl))
    val jsonSatellite = JsonUtils.getJsonContent(ApplicationConfiguration.base_satellite)
    //  val s = write[Satellite](sat)
    //    println(s)
    val e = read[Satellite](jsonSatellite)
    println(e)

  }

}
