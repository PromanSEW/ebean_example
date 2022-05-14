val ebeanVersion = "13.6.0"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.15")

addSbtPlugin("com.typesafe.play" % "sbt-play-ebean" % "6.2.0-RC6")

dependencyOverrides ++= Seq(
  "io.ebean" % "ebean" % ebeanVersion,
  "io.ebean" % "ebean-agent" % ebeanVersion,
  "io.ebean" % "ebean-ddl-generator" % ebeanVersion
)
