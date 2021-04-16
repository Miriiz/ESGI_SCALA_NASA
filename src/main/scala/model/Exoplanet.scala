package model

case class Exoplanet(
                      pl_hostname: String,
                      pl_letter: String,
                      pl_name: String,
                      pl_discmethod: String,
                      pl_controvflag: Option[Int],
                      pl_pnum: Option[Int],
                      pl_orbper: Option[Float],
                      pl_orbperlim: Option[Int],
                      pl_orbpern: Option[Int],
                      pl_orbsmax:Option[Int],
                      pl_orbsmaxn:Option[Int],
                      pl_orbsmaxlim:Option[Int],
                      pl_orbeccen:Option[Int],
                      pl_orbeccenlim:Option[Int],
                      pl_orbeccenn:Option[Int],
                      pl_orbincl:Option[Int],
                      pl_orbincllim:Option[Int],
                      pl_orbincln:Option[Int],
                      pl_bmassj:Option[Float],
                      pl_bmassjlim:Option[Int],
                      pl_bmassjn:Option[Int],
                      pl_bmassprov: String,
                      pl_radj:Option[Float],
                      pl_radjlim:Option[Int],
                      pl_radjn:Option[Int],
                      pl_dens:Option[Float],
                      pl_denslim:Option[Int],
                      pl_densn:Option[Int],
                      pl_ttvflag:Option[Int],
                      pl_kepflag:Option[Int],
                      pl_k2flag:Option[Int],
                      st_mass:Option[Float],
                      st_masslim:Option[Int],
                      st_massn:Option[Int],
                      st_rad:Option[Float],
                      st_radlim:Option[Int],
                      st_radn:Option[Int]
                    )