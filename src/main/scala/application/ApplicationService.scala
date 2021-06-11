package application

import connector.MongoConnector
import model.{Asteroid, Exoplanet, Exoplanet_list, Satellite, Satellite_list}
import upickle.default._
import utils.JsonUtils

import scala.collection.mutable.ListBuffer

//lire les données - HTTP
//parser Json
//Creer les objets
//Renvoyer en BDD

object ApplicationService {
  def process(): Unit = {

    val mongo = new MongoConnector("ESGI_NASA")

    // Recuperation des satellites
    var sat_list = ListBuffer[Satellite_list]()
    for (a <- 1 to ApplicationConfiguration.satellite_max_page){
      val jsonSatellite = JsonUtils.getJsonContent(ApplicationConfiguration.base_satellite + a.toString)
      val parsedSatellite = read[Satellite_list](jsonSatellite)
      sat_list += parsedSatellite
    }
    var sats_found : Int = 0
    sat_list.map(satellite_list => sats_found = sats_found + satellite_list.member.size)
    println(sats_found + " satellites found.")

    // sauvegarde des satellites
    sat_list.map(satellite_list => mongo.addSatellite(satellite_list))
    var sats_saved : Int = 0
    sat_list.map(satellite_list => sats_saved = sats_saved + satellite_list.member.size)
    println(sats_saved + " satellites saved.")


    // Recuperation des exoplanetes
    val jsonExoplanet = JsonUtils.nameExoplaneteArray(JsonUtils.removeUselessHeaderFromExoplanetes(JsonUtils.getJsonContent(ApplicationConfiguration.base_exoplanete)))
    val parsedExoplanet = read[Exoplanet_list](jsonExoplanet)
    println(parsedExoplanet.member.size + " exoplanetes found.")

    // sauvegarde des exoplanetes
    mongo.addExoplanete(parsedExoplanet)
    println(parsedExoplanet.member.size + " exoplanetes saved.")

    // Recuperation des asteroids
    val jsonAsteroid = JsonUtils.getJsonContent(ApplicationConfiguration.base_asteroid)
    val parsedAsteroid = read[Asteroid](jsonAsteroid)
    println(parsedAsteroid.near_earth_objects.size + " asteroids found.")

    // sauvegarde des asteroids
    mongo.addAsteroid(parsedAsteroid)
    println(parsedAsteroid.near_earth_objects.size + " asteroids saved.")
  }

}
