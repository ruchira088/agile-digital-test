package com.ruchira

import org.scalatest.FunSpec

class CoordinatesTest extends FunSpec
{
  describe("Convert a String into Coordinates")
  {
    it("Strings converted to Coordinates successfully")
    {
      assert(Coordinates.convertToCoordinates("1 1 W").equals(Coordinates(1, 1, West)))
      assert(Coordinates.convertToCoordinates("0 2 E").equals(Coordinates(0, 2, East)))
      assert(Coordinates.convertToCoordinates("0 21 S").equals(Coordinates(0, 21, South)))
      assert(Coordinates.convertToCoordinates("10 2 N").equals(Coordinates(10, 2, North)))
    }
  }
}
