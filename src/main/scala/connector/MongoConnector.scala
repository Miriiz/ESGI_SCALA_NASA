package connector

import org.mongodb.scala._
import _root_.model.Asteroid
import _root_.model.Exoplanet_list
import _root_.model.Satellite_list
import org.mongodb.scala.bson.{BsonArray, BsonDocument}

class MongoConnector(var db: String) {

  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017/")
  val database: MongoDatabase = mongoClient.getDatabase(db)

  val asteroid_collection : MongoCollection[Document] = database.getCollection("asteroids")
  val exoplanet_collection : MongoCollection[Document] = database.getCollection("exoplanets")
  val satellite_collection : MongoCollection[Document] = database.getCollection("satellites")

  def addAsteroid(asteroids: Asteroid): Boolean = {
    asteroids.near_earth_objects.foreach(ast => {

      val orbital_data_doc : Document = Document("orbit_id" -> ast.orbital_data.orbit_id, "orbit_determination_date" -> ast.orbital_data.orbit_determination_date,
                                                 "first_observation_date" -> ast.orbital_data.first_observation_date,"last_observation_date" -> ast.orbital_data.last_observation_date,
                                                 "observations_used" -> ast.orbital_data.observations_used)
      var close_approach_data_doc = BsonArray()
      ast.close_approach_data.foreach(data => {
        val data_doc : BsonDocument = BsonDocument("orbiting_body" -> data.orbiting_body, "close_approach_date" -> data.close_approach_date,
                                                   "relative_velocity" -> data.relative_velocity.kilometers_per_second, "miss_distance" -> data.miss_distance.kilometers)
        close_approach_data_doc.add(data_doc)
      })

      val asteroid_doc : Document = Document("id" -> ast.id, "name" -> ast.name,"name_limited" -> ast.name_limited,
                                             "designation" -> ast.designation, "orbital_data" -> orbital_data_doc,
                                              "absolute_magnitude_h" -> ast.absolute_magnitude_h.toString, "close_approach_data" -> close_approach_data_doc,
                                              "estimated_diameter" -> ast.estimated_diameter.kilometers.estimated_diameter_max.toString)
      asteroid_collection.insertOne(asteroid_doc)
    })
    true
  }

  def addExoplanete(exoplanets: Exoplanet_list): Boolean = {
    exoplanets.member.foreach(exo => {
      val exo_doc : Document = Document("pl_name" -> exo.pl_name, "st_massn" -> exo.st_massn, "pl_letter" -> exo.pl_letter,
                                        "pl_hostname" -> exo.pl_hostname, "pl_discmethod" -> exo.pl_discmethod)
      exoplanet_collection.insertOne(exo_doc)
    })
    true
  }

  def addSatellite(satellites: Satellite_list): Boolean = {
    satellites.member.foreach(sat => {
      val sat_doc : Document = Document("name" -> sat.name, "id" -> sat.satelliteId, "date" -> sat.date,
                                        "line1" -> sat.line1, "line2" -> sat.line2)
      satellite_collection.insertOne(sat_doc)
    })
    true
  }

}

