package model
import upickle.default.{ReadWriter => RW, macroRW}

case class Satellite(
                     totalItems : Int,
                     member : List[Solo_satellite])


case class  Solo_satellite (
                satelliteId : Int,
                name : String,
                date : String,
                line1 : String,
                line2 : String
              )
object Satellite{
  implicit val rw: RW[Satellite] = macroRW
}
object Solo_satellite{
implicit val rw: RW[Solo_satellite] = macroRW
}