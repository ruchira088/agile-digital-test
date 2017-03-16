package com.ruchira

import org.scalatest.FunSpec

class DirectionTest extends FunSpec
{
  describe("Convert String to Direction")
  {
    it("Strings converted to Directions Successfully")
    {
      assert(Direction.convertToDirection("N").equals(North))
      assert(Direction.convertToDirection("E").equals(East))
      assert(Direction.convertToDirection("S").equals(South))
      assert(Direction.convertToDirection("W").equals(West))
    }
  }

  describe("Rotate left")
  {
    it("")
    {
      assert(Direction.rotateLeft(North).equals(West))
      assert(Direction.rotateLeft(West).equals(South))
      assert(Direction.rotateLeft(South).equals(East))
      assert(Direction.rotateLeft(East).equals(North))
    }
  }

  describe("Rotate right")
  {
    it("")
    {
      assert(Direction.rotateRight(North).equals(East))
      assert(Direction.rotateRight(East).equals(South))
      assert(Direction.rotateRight(South).equals(West))
      assert(Direction.rotateRight(West).equals(North))
    }
  }

}
