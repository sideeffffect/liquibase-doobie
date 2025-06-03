package com.github.sideeffffect.liquibase.doobie.zio

import _root_.zio.config.magnolia.*

import scala.concurrent.duration.Duration
import scala.jdk.DurationConverters.*

package object config {
  implicit lazy val configDescriptor: DeriveConfig[com.github.sideeffffect.liquibase.doobie.Config] = {
    implicit val durationDeriveConfig: DeriveConfig[Duration] =
      DeriveConfig[java.time.Duration].map(_.toScala)
    implicit val hikariDescriptor: DeriveConfig[_root_.doobie.hikari.Config] =
      DeriveConfig.derived
    DeriveConfig.derived
  }
}
