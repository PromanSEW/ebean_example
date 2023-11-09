//val ebeanVersion = "13.17.3"
val ebeanVersion = "13.25.0" // sync with build.sbt
val ebeanJakarta = ebeanVersion + "-jakarta"

//addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.20")
addSbtPlugin("org.playframework" % "sbt-plugin" % "3.0.0")

//addSbtPlugin("com.typesafe.play" % "sbt-play-ebean" % "6.2.0")
addSbtPlugin("org.playframework" % "sbt-play-ebean" % "8.0.0")

dependencyOverrides ++= Seq(
  "io.ebean" % "ebean" % ebeanJakarta,
  "io.ebean" % "ebean-agent" % ebeanVersion,
  "io.ebean" % "ebean-ddl-generator" % ebeanJakarta
)
