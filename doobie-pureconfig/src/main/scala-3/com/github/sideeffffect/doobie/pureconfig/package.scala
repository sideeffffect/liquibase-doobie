package com.github.sideeffffect.doobie

import _root_.pureconfig._
import _root_.pureconfig.generic.semiauto._
import doobie.enumerated.TransactionIsolation

package object pureconfig {
  implicit lazy val configConvertHikari: ConfigConvert[_root_.doobie.hikari.Config] = {
    implicit val configConvertTransactionIsolation: ConfigConvert[TransactionIsolation] =
      deriveEnumerationConvert(ConfigFieldMapping(ScreamingSnakeCase, ScreamingSnakeCase))
    deriveConvert
  }
}
