package model
import upickle.default.{ReadWriter => RW, macroRW}


case class Asteroid(
                    near_earth_objects: List[Near_earth_objects]
                    )

case class  Near_earth_objects(
                           id : String,
                           name: String,
                           name_limited: String,
                           designation : String,
                           absolute_magnitude_h:  Float,
                           estimated_diameter : Estimated_diameter,
                           close_approach_data : List[Close_approach_data],
                           orbital_data : Orbital_data

                         )

case class Estimated_diameter (
                           kilometers : Diameter_values

                         )
case class  Diameter_values(
                        estimated_diameter_min :  Float,
                        estimated_diameter_max :  Float
                      )
case class Close_approach_data (
                            close_approach_date : String,
                            relative_velocity : relative_velocity,
                            miss_distance : Miss_distance,
                            orbiting_body : String
                          )
case class relative_velocity (
                          kilometers_per_second : String
                        )
case class  Miss_distance(
                      astronomical : String,
                      lunar : String,
                      kilometers : String
                    )
case class Orbital_data (
                     orbit_id : String,
                     orbit_determination_date : String,
                     first_observation_date : String,
                     last_observation_date : String,
                     observations_used :  Int
                   )

object Asteroid{
  implicit val rw: RW[Asteroid] = macroRW
}

object Near_earth_objects{
  implicit val rw: RW[Near_earth_objects] = macroRW
}

object Estimated_diameter{
  implicit val rw: RW[Estimated_diameter] = macroRW
}

object Diameter_values{
  implicit val rw: RW[Diameter_values] = macroRW
}

object Close_approach_data{
  implicit val rw: RW[Close_approach_data] = macroRW
}

object relative_velocity{
  implicit val rw: RW[relative_velocity] = macroRW
}

object Miss_distance{
  implicit val rw: RW[Miss_distance] = macroRW
}

object Orbital_data{
  implicit val rw: RW[Orbital_data] = macroRW
}
