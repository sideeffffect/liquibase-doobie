package com.github.sideeffffect.liquibase.doobie

import _root_.pureconfig._
import _root_.pureconfig.generic.semiauto._
import com.github.sideeffffect.doobie.pureconfig._

package object pureconfig {
  implicit lazy val configConvert: ConfigConvert[Config] = deriveConvert
}
