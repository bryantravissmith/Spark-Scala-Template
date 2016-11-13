

val globalSettings = Seq(
  version := "1.0",
  scalaVersion := "2.11.8"
)

resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "Repo at github.com/ankurdave/maven-repo" at "https://github.com/ankurdave/maven-repo/raw/master"

lazy val sparkScalaTemplate = (project in file("."))
  .settings(name := "SparkAppName-ToBeReplaced")
  .settings(globalSettings:_*)
  .settings(libraryDependencies ++= dependencies)

val sparkVersion = "2.0.1"

lazy val dependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark"    %% "spark-sql"             % sparkVersion,
  "org.apache.spark"    %% "spark-mllib"           % sparkVersion,
  "org.apache.spark"    %% "spark-graphx"          % sparkVersion
)


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
