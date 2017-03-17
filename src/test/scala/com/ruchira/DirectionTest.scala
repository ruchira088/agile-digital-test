package com.ruchira

import org.scalatest.FunSpec

class DirectionTest extends FunSpec
{
  describe("convertToDirection(String)")
  {
    it("Strings converted to Directions Successfully")
    {
      assert(Direction.convertToDirection("N").equals(North))
      assert(Direction.convertToDirection("E").equals(East))
      assert(Direction.convertToDirection("S").equals(South))
      assert(Direction.convertToDirection("W").equals(West))
    }
  }

  describe("rotateLeft(Direction)")
  {
    it("Rotated left successfully")
    {
      assert(Direction.rotateLeft(North).equals(West))
      assert(Direction.rotateLeft(West).equals(South))
      assert(Direction.rotateLeft(South).equals(East))
      assert(Direction.rotateLeft(East).equals(North))
    }
  }

  describe("rotateRight(Direction)")
  {
    it("Rotated right successfully")
    {
      assert(Direction.rotateRight(North).equals(East))
      assert(Direction.rotateRight(East).equals(South))
      assert(Direction.rotateRight(South).equals(West))
      assert(Direction.rotateRight(West).equals(North))
    }
  }

}
