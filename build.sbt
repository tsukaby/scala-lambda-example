javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

lazy val root = (project in file(".")).
  settings(
    name := "scala-lambda-example",
    version := "1.0",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "com.amazonaws" % "aws-lambda-java-core" % "1.0.0",
      "com.amazonaws" % "aws-lambda-java-events" % "1.0.0",
      "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.5.2",
      "org.atilika.kuromoji" % "kuromoji" % "0.7.7" // 形態素解析用
    )
  )

mergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
