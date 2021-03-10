import Dependencies._

ThisBuild / scalaVersion     := "2.13.4"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "scalapb-repro",
    libraryDependencies ++= Seq(
        scalaTest % Test,
        "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"
        )
    ,
    Compile / PB.targets := Seq(
      scalapb.gen(
        grpc = false,
        flatPackage = true,
      ) -> (Compile / sourceManaged).value / "scalapb"
    ),
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
