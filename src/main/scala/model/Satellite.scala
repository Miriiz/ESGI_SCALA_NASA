package model

case class Satellite(
                     totalItems : Option[Int],
                     member : List[solo_satellite]
                    )

class  solo_satellite (
                satelliteId : Int,
                name : String,
                date : String,
                line1 : String,
                line2 : String
              )
