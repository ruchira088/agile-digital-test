package com.ruchira

import org.scalatest.FunSpec

class CoordinatesTest extends FunSpec
{
  describe("convertToCoordinates(String)")
  {
    it("Strings converted to Coordinates successfully")
    {
      assertResult(Coordinates(1, 1, West))(Coordinates.convertToCoordinates("1 1 W"))
      assertResult(Coordinates(0, 2, East))(Coordinates.convertToCoordinates("0 2 E"))
      assertResult(Coordinates(0, 21, South))(Coordinates.convertToCoordinates("0 21 S"))
      assertResult(Coordinates(10, 2, North))(Coordinates.convertToCoordinates("10 2 N"))
    }
  }
}
