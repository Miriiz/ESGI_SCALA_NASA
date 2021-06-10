package application

import model.{Asteroid, Exoplanet, Exoplanet_list, Satellite, Satellite_list}
import upickle.default._
import utils.JsonUtils

import scala.collection.mutable.ListBuffer

object ApplicationService {
  def process(): Unit = {
    //lire les données - HTTP
    //parser Json
    //Creer les objets
    //Renvoyer en BDD
    val sl = new Satellite(1, "test", "15-05-05", "1-1-1-1", "2-2-2-2")
    val sat = new Satellite_list(1500, List(sl))

    /* Recuperation des satellites
    var sat_list = List()
    for (a <- 1 to ApplicationConfiguration.satellite_max_page){
      val jsonSatellite = JsonUtils.getJsonContent(ApplicationConfiguration.base_satellite + a.toString)
      val parsedSatellite = read[Satellite_list](jsonSatellite)
      parsedSatellite.member.map(s => sat_list :+ s )
    }
    println(sat_list.size + " satellites Found.")
    */

    /*
    val jsonExoplanet = JsonUtils.nameExoplaneteArray(JsonUtils.removeUselessHeaderFromExoplanetes(JsonUtils.getJsonContent(ApplicationConfiguration.base_exoplanete)))
    val parsedExoplanet = read[Exoplanet_list](jsonExoplanet)
    println(parsedExoplanet.member.size + " exoplanetes found.")
    */

    val jsonAsteroid = JsonUtils.getJsonContent(ApplicationConfiguration.base_asteroid)
    val parsedAsteroid = read[Asteroid](jsonAsteroid)

    println(parsedAsteroid.near_earth_objects.size + " asteroids found.")

  }

}
