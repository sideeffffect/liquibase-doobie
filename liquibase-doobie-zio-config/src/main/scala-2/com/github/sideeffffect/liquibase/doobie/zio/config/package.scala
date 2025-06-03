package com.github.sideeffffect.liquibase.doobie.zio

import _root_.zio.config.magnolia._

import scala.concurrent.duration.Duration
import scala.jdk.DurationConverters._

package object config {
  implicit lazy val configDeriveConfig: DeriveConfig[com.github.sideeffffect.liquibase.doobie.Config] = {
    implicit val durationDeriveConfig: DeriveConfig[Duration] =
      DeriveConfig[java.time.Duration].map(_.toScala)
    implicit val hikariDeriveConfig: DeriveConfig[_root_.doobie.hikari.Config] =
      DeriveConfig.getDeriveConfig
    DeriveConfig.getDeriveConfig
  }
}
