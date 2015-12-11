name := "typeclass-example"

scalaVersion := "2.11.7"

libraryDependencies += "com.amazonaws" % "aws-java-sdk" % "1.10.27"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)

libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.5.0"
