package model

case class Asteroid(
                    page : Page ,
                    near_earth_objects: List[Object]

                    )
class Page(
            size :  Option[Int],
            total_elements :  Option[Int],
            total_pages :  Option[Int],
            number :  Option[Int]

          )
class  Near_earth_objects(
                           id : String,
                           name: String,
                           name_limited: String,
                           designation : String,
                           absolute_magnitude_h:  Option[Float],
                           estimated_diameter : Estimated_diameter,
                           close_approach_data : List[Close_approach_data],
                           orbital_data : Orbital_data

                         )

class Estimated_diameter (
                           kilometers : Diameter_values

                         )
class  Diameter_values(
                        estimated_diameter_min :  Option[Float],
                        estimated_diameter_max :  Option[Float]
                      )
class Close_approach_data (
                            close_approach_height : String,
                            relative_velocity : relative_velocity,
                            miss_distance : Miss_distance,
                            orbiting_body : String
                          )
class relative_velocity (
                          kilometers_per_seconds : String
                        )
class  Miss_distance(
                      astronomical : String,
                      lunar : String,
                      kilometers : String
                    )
class Orbital_data (
                     orbit_id : String,
                     orbit_determination_date : String,
                     first_observation_date : String,
                     last_observation_date : String,
                     observations_used :  Option[Int]
                   )
