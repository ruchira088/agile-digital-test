package com.ruchira

import org.scalatest.FunSpec
import Direction._

class DirectionTest extends FunSpec
{
  describe("convertToDirection(String)")
  {
    it("Strings converted to Directions Successfully")
    {
      assertResult(North)(convertToDirection("N"))
      assertResult(East)(convertToDirection("E"))
      assertResult(South)(convertToDirection("S"))
      assertResult(West)(convertToDirection("W"))
    }
  }

  describe("rotateLeft(Direction)")
  {
    it("Rotated left successfully")
    {
      assertResult(West)(rotateLeft(North))
      assertResult(South)(rotateLeft(West))
      assertResult(East)(rotateLeft(South))
      assertResult(North)(rotateLeft(East))
    }
  }

  describe("rotateRight(Direction)")
  {
    it("Rotated right successfully")
    {
      assertResult(East)(rotateRight(North))
      assertResult(South)(rotateRight(East))
      assertResult(West)(rotateRight(South))
      assertResult(North)(rotateRight(West))
    }
  }

}
