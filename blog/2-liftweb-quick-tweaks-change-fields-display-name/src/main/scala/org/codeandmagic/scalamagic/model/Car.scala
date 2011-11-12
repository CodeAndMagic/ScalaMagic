package org.codeandmagic.scalamagic.model

import net.liftweb.mapper._
import net.liftweb.http.S

object Car extends Car with LongKeyedMetaMapper[Car] with CRUDify[Long,Car]{
  override def dbTableName = "cars"
}

class Car extends LongKeyedMapper[Car] with IdPK {
  def getSingleton = Car
  object plateNumber extends MappedString(this, 10){
    override def displayName = S.??("Plate Number")
  }
}