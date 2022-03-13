import com.typesafe.sbt.packager.docker.DockerChmodType
import com.typesafe.sbt.packager.docker.DockerPermissionStrategy

name := "play-ebean-example"

version := "release"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

val ebeanVersion = "12.15.1"

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(evolutions, guice, javaJdbc)

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.3.2",
  "io.ebean" % "ebean-ddl-generator" % ebeanVersion
)

dependencyOverrides ++= Seq(
  "io.ebean" % "ebean" % ebeanVersion,
  "io.ebean" % "ebean-agent" % ebeanVersion
)

Docker / maintainer := "promansew@gmail.com"
Docker / packageName := "play-ebean-example"
Docker / version := sys.env.getOrElse("BUILD_NUMBER", "0")
Docker / daemonUserUid  := None
Docker / daemonUser := "daemon"

dockerExposedPorts := Seq(80, 9000)
dockerBaseImage := "openjdk:11.0.14.1-jre-slim"
dockerRepository := sys.env.get("promansew")
dockerUpdateLatest := true
dockerChmodType := DockerChmodType.UserGroupWriteExecute
dockerPermissionStrategy := DockerPermissionStrategy.CopyChown
