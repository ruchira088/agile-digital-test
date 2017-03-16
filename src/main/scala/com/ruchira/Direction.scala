package com.ruchira

sealed trait Direction {}

case object North extends Direction {
  override def toString: String = "N"
}

case object East extends Direction {
  override def toString: String = "E"
}

case object South extends Direction {
  override def toString: String = "S"
}

case object West extends Direction {
  override def toString: String = "W"
}

object Direction {
  val VALUES: List[Direction] = List(North, East, South, West)

  def rotateRight(direction: Direction): Direction =
  {
    rotate(direction, index => if (index + 1 == VALUES.length) 0 else (index + 1))
  }

  def rotateLeft(direction: Direction): Direction =
  {
    rotate(direction, index => if(index - 1 < 0) VALUES.length - 1 else (index - 1))
  }

  def convertToDirection(directionString: String): Direction = {
    val direction = VALUES.find(value => value.toString == directionString)

    if(direction.isEmpty) {
      throw new Exception(s"Invalid direction: ${directionString}")
    } else {
      direction.get
    }
  }

  private def rotate(direction: Direction, nextIndex: Int => Int): Direction =
  {
    val index = VALUES.indexOf(direction)

    VALUES(nextIndex(index))
  }
}

