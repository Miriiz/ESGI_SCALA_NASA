package application
import  utils.JsonUtils
object ApplicationService {
  def process(): Unit = {
    //lire les données - HTTP
    //parser Json
    //Creer les objets
    //Renvoyer en BDD
  val jsonSatellite = JsonUtils.getJsonContent(ApplicationConfiguration.base_satellite)
  println(jsonSatellite)


  }

}
