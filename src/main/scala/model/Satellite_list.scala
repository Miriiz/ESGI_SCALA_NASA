package model
import upickle.default.{ReadWriter => RW, macroRW}

case class Satellite_list(
                     totalItems : Int,
                     member : List[Satellite])


case class  Satellite(
                satelliteId : Int,
                name : String,
                date : String,
                line1 : String,
                line2 : String
              )
object Satellite_list{
  implicit val rw: RW[Satellite_list] = macroRW
}
object Satellite{
implicit val rw: RW[Satellite] = macroRW
}