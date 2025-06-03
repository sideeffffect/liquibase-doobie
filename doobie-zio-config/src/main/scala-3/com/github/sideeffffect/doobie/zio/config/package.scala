package com.github.sideeffffect.doobie.zio

import _root_.zio.config.magnolia.*

import scala.concurrent.duration.Duration
import scala.jdk.DurationConverters.*

package object config {
  implicit lazy val hikariDescriptor: DeriveConfig[_root_.doobie.hikari.Config] = {
    implicit val durationDeriveConfig: DeriveConfig[Duration] =
      DeriveConfig[java.time.Duration].map(_.toScala)
    DeriveConfig.derived
  }
}
