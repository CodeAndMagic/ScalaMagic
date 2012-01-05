package org.codeandmagic.scalamagic.model

import net.liftweb.mapper._
import java.util.Date

object Car extends Car with LongKeyedMetaMapper[Car] with CRUDify[Long,Car]{
  override def dbTableName = "cars"
  override def fieldsForDisplay = List(plateNumber, numberOfDoors, color, carType, price, creationDate, updateDate)
  override def fieldsForList = List(plateNumber, color, carType, price, dealerEmail)
  override def fieldsForEditing = fieldsForList
}

class Car extends LongKeyedMapper[Car] with IdPK {
  def getSingleton = Car
  object plateNumber extends MappedString(this, 10)
  object numberOfSeats extends MappedInt(this)
  object numberOfDoors extends MappedInt(this)
  object color extends MappedString(this,6)
  object carType extends MappedEnum(this,CarType)
  object price extends MappedDouble(this)
  object dealerEmail extends MappedEmail(this,64)
  object dayIWillBuyThis extends MappedDate(this){
    override def dbDisplay_? = false
  }

  object creationDate extends MappedDateTime(this){
    override def defaultValue = new Date
  }

  object updateDate extends MappedDateTime(this) with LifecycleCallbacks{
    override def beforeUpdate = {
      super.beforeUpdate
      apply(new Date)
    }
  }
}

object CarType extends Enumeration {
  val Sport, Tractor = Value
}