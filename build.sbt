import Dependencies._

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "Gaming",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.apache.hive" % "hive-exec" % "1.2.1" excludeAll
                           ExclusionRule(organization = "org.pentaho"),
    libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.3",
    libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.3.4",
    libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.6.0",
    libraryDependencies += "org.apache.hive" % "hive-service" % "1.2.1",
    libraryDependencies += "org.apache.hive" % "hive-cli" % "1.2.1",
    libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.2",


    // App requires logging classes, last 2 seemed to fix it, keeping all just in case
    libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.25" % Test,
    libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25",
    libraryDependencies += "org.slf4j" % "slf4j-simple" % "1.7.25" % Test,
    libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.12.1",
    libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.12.1" % Test
  )

// Uncomment the following for publishing to Sonatype.
// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for more detail.

// ThisBuild / description := "Some descripiton about your project."
// ThisBuild / licenses    := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
// ThisBuild / homepage    := Some(url("https://github.com/example/project"))
// ThisBuild / scmInfo := Some(
//   ScmInfo(
//     url("https://github.com/your-account/your-project"),
//     "scm:git@github.com:your-account/your-project.git"
//   )
// )
// ThisBuild / developers := List(
//   Developer(
//     id    = "Your identifier",
//     name  = "Your Name",
//     email = "your@email",
//     url   = url("http://your.url")
//   )
// )
// ThisBuild / pomIncludeRepository := { _ => false }
// ThisBuild / publishTo := {
//   val nexus = "https://oss.sonatype.org/"
//   if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
//   else Some("releases" at nexus + "service/local/staging/deploy/maven2")
// }
// ThisBuild / publishMavenStyle := true
