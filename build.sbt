name := "practice_project"

version := "1.0"

lazy val `practice_project` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

val runtimeDependencies = Seq(
  jdbc,
  cache,
  ws,
  "org.reactivemongo" %% "reactivemongo" % "0.12.1"
)

val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
  "org.scalatest" %% "scalatest" % "3.0.1" % Test,
  specs2 % Test
)

libraryDependencies ++= runtimeDependencies ++ testDependencies

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  