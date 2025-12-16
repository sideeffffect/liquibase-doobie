import sbt._

object Dependencies {

  object Versions {
    val doobie = "1.0.0-RC11"
    val liquibase = "4.33.0"
    val pureconfig = "0.17.9"
    val zioCats = "23.1.0.12"
    val zioConfig = "4.0.5"
  }

  val doobie = "org.tpolecat" %% "doobie-hikari" % Versions.doobie
  val liquibase = "org.liquibase" % "liquibase-core" % Versions.liquibase
  val pureconfigGeneric = "com.github.pureconfig" %% "pureconfig-generic" % Versions.pureconfig
  val pureconfigGenericScala3 = "com.github.pureconfig" %% "pureconfig-generic-scala3" % Versions.pureconfig
  val zioCats = "dev.zio" %% "zio-interop-cats" % Versions.zioCats
  val zioConfigMagnolia = "dev.zio" %% "zio-config-magnolia" % Versions.zioConfig

}
