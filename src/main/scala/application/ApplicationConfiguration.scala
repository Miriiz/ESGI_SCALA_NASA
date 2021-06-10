package application

object ApplicationConfiguration {
  val base_asteroid = "https://api.nasa.gov/neo/rest/v1/neo/browse/?api_key=P6S0Cu4as6dBezgPPce636DyzFnmefqbHFZtCfIr"
  val base_exoplanete = "https://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?table=exoplanets&format=json"
  val base_satellite = "https://tle.ivanstanojevic.me/api/tle/?page="
  val satellite_max_page = 5
  val endpoint_fact = "/fact"
  //val cassandra_host = ???
}
