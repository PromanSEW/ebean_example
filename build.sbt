import com.typesafe.sbt.packager.docker.DockerChmodType
import com.typesafe.sbt.packager.docker.DockerPermissionStrategy

name := "play-ebean-example"

version := "release"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

val ebeanVersion = "13.6.0"

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(evolutions, guice, javaJdbc)

libraryDependencies ++= Seq(
//"org.postgresql" % "postgresql" % "42.3.4"
  "com.h2database" % "h2" % "2.1.212"
)

dependencyOverrides ++= Seq(
  "io.ebean" % "ebean" % ebeanVersion,
  "io.ebean" % "ebean-agent" % ebeanVersion,
  "io.ebean" % "ebean-ddl-generator" % ebeanVersion
)

Docker / maintainer := "promansew@gmail.com"
Docker / packageName := "play-ebean-example"
Docker / version := "latest"

dockerExposedPorts := Seq(80, 9000)
dockerBaseImage := "openjdk:11.0.15-jre-slim"
dockerRepository := Some("promansew")
dockerUpdateLatest := true
dockerChmodType := DockerChmodType.UserGroupWriteExecute
dockerPermissionStrategy := DockerPermissionStrategy.CopyChown
