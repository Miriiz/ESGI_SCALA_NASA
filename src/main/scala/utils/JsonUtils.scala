package utils
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import java.io.{ByteArrayOutputStream, IOException}
import com.google.gson.Gson

object JsonUtils {

  def nameExoplaneteArray(json: String): String ={
    val return_json = "{\"member\": " + json + "}"
    return return_json
  }

  def removeUselessHeaderFromExoplanetes(json:String): String ={
    val return_json = json.substring(json.indexOf("["))
    return return_json
  }

  def getJsonContent(url:String): String ={

    val client = HttpClientBuilder.create.build
    val request = new HttpGet(url)
    val response = client.execute(request)

    val statusLine = response.getStatusLine
    if (statusLine.getStatusCode == HttpStatus.SC_OK) {
      val out = new ByteArrayOutputStream
      response.getEntity.writeTo(out)
      val responseString = out.toString
      out.close()
      //..more logic
      return  responseString
    }
    else { //Closes the connection.
      response.getEntity.getContent.close
      throw new IOException(statusLine.getReasonPhrase)
    }


  }

}
