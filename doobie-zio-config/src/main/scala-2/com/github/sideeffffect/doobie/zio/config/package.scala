package com.github.sideeffffect.doobie.zio

import _root_.zio.config.magnolia._

import scala.concurrent.duration.Duration
import scala.jdk.DurationConverters._

package object config {
  implicit lazy val hikariDeriveConfig: DeriveConfig[_root_.doobie.hikari.Config] = {
    implicit val durationDeriveConfig: DeriveConfig[Duration] =
      DeriveConfig[java.time.Duration].map(_.toScala)
    DeriveConfig.getDeriveConfig
  }
}
