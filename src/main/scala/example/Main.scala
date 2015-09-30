package example

import java.io.{InputStream, OutputStream}

case class AnalyzeRequest(text: String)

case class AnalyzeResponse(tags: Seq[String])

class Main {
  val scalaMapper = {
    import com.fasterxml.jackson.databind.ObjectMapper
    import com.fasterxml.jackson.module.scala.DefaultScalaModule
    new ObjectMapper().registerModule(new DefaultScalaModule)
  }

  def analyze(input: InputStream, output: OutputStream): Unit = {
    val textInfo = scalaMapper.readValue(input, classOf[AnalyzeRequest])
    val result = AnalyzeResponse(MorphologicalService.getTags(textInfo.text).map(_._1))
    scalaMapper.writeValue(output, result)
  }
}
