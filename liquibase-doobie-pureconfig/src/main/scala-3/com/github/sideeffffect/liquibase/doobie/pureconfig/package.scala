package com.github.sideeffffect.liquibase.doobie

import _root_.pureconfig.*
import _root_.pureconfig.generic.semiauto.*
import com.github.sideeffffect.doobie.pureconfig.*

package object pureconfig {
  implicit lazy val configConvert: ConfigConvert[Config] = deriveConvert
}
