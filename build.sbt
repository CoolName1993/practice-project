import sbt._
name := "practice_project"

version := "1.0"

lazy val `practice_project` = (project in file("."))
  .enablePlugins(PlayScala)
  .configs(IntegrationTest)
  .settings(inConfig(IntegrationTest)(Defaults.itSettings): _*)

scalaVersion := "2.11.7"

val appDependencies = Seq(
  jdbc,
  cache,
  ws,
  "org.reactivemongo" %% "reactivemongo" % "0.12.1",
  "com.googlecode.htmlcompressor" % "htmlcompressor" % "1.4"
)

val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "2.0.0-M1" % s"$Test,$IntegrationTest",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.5.0" % s"$Test,$IntegrationTest",
  "org.jsoup" % "jsoup" % "1.8.3" % s"$Test,$IntegrationTest",
  specs2 % Test
)

libraryDependencies ++= appDependencies ++ testDependencies

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

unmanagedSourceDirectories in IntegrationTest <<= (baseDirectory in IntegrationTest)(base =>  Seq(base / "it"))

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"  