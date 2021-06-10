package model
import upickle.default.{ReadWriter => RW, macroRW}

case class Exoplanet_list(member : List[Exoplanet])

case class Exoplanet(
                      pl_hostname: String,
                      pl_letter: String,
                      pl_name: String,
                      pl_discmethod: String,
                      st_massn:Int
                    )

object Exoplanet_list{
  implicit val rw: RW[Exoplanet_list] = macroRW
}

object Exoplanet{
  implicit val rw: RW[Exoplanet] = macroRW
}