name := "spark-hadoop-lp"
version := "0.1"
scalaVersion := "2.11.2"
mainClass := Some("com.griddynamics.spark.streaming.Main")

libraryDependencies ++= Seq(
    "org.apache.spark" % "spark-streaming_2.11" % "1.5.2",
    "org.apache.spark" %% "spark-streaming-twitter" % "1.6.3",
    "org.apache.spark" % "spark-core_2.11" % "1.5.2",
//    "org.apache.spark" % "spark-sql_2.11" % "2.2.1",
//    "mysql" % "mysql-connector-java" % "6.0.6",
    "org.twitter4j" % "twitter4j-core" % "4.0.6",
    "org.twitter4j" % "twitter4j-stream" % "4.0.6"
)

assemblyMergeStrategy in assembly := {
    case PathList("META-INF", xs@_*) => MergeStrategy.discard
    case x => MergeStrategy.first
}
