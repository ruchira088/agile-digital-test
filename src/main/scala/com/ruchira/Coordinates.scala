package com.ruchira

case class Coordinates(x: Int, y: Int, direction: Direction) {
  override def toString: String = s"${x.toString} ${y.toString} ${direction.toString}"
}

object Coordinates
{
  def convertToCoordinates(coordinates: String): Coordinates =
  {
    try {
      val Array(x, y, directionString) = coordinates.split(" ")

      Coordinates(x.toInt, y.toInt, Direction.convertToDirection(directionString))
    } catch {
      case _: MatchError => throw new Exception("Cats")
    }
  }
}