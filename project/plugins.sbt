logLevel := Level.Warn

resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.9")

addSbtPlugin("me.lessis" % "bintray-sbt" % "0.3.0")