scalaVersion in ThisBuild := "2.11.7"

libraryDependencies in ThisBuild += "org.scala-lang.modules" % "scala-async_2.11" % "0.9.3"

val before = project in file("before")

val after = project in file("after")

