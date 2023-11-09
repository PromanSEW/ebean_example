name := "play-ebean-example"

version := "release"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

//val ebeanVersion = "13.22.0"
val ebeanVersion = "13.25.0" // sync with project/plugins.sbt
val ebeanJakarta = ebeanVersion + "-jakarta"

//scalaVersion := "2.13.8"
scalaVersion := "3.3.1"

libraryDependencies ++= Seq(evolutions, guice, javaJdbc)

libraryDependencies ++= Seq(
//"org.postgresql" % "postgresql" % "42.6.0"
  "com.h2database" % "h2" % "2.1.214"
)

dependencyOverrides ++= Seq(
  "io.ebean" % "ebean" % ebeanJakarta,
  "io.ebean" % "ebean-agent" % ebeanVersion,
  "io.ebean" % "ebean-ddl-generator" % ebeanJakarta
)
