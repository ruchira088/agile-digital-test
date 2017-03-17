package com.ruchira

import org.scalatest.FunSpec
import Instruction._

class InstructionTest extends FunSpec
{
  describe("convertToInstruction(String)")
  {
    it("Successfully converted Strings to Instructions")
    {
      assertResult(Move)(convertToInstruction("M"))
      assertResult(Right)(convertToInstruction("R"))
      assertResult(Left)(convertToInstruction("L"))
    }
  }

  describe("move(Coordinates)")
  {
    it("Successfully moved")
    {
      assertResult(Coordinates(1, 2, North))(move(Coordinates(1, 1, North)))
      assertResult(Coordinates(3, 5, East))(move(Coordinates(2, 5, East)))
      assertResult(Coordinates(6, 2, South))(move(Coordinates(6, 3, South)))
      assertResult(Coordinates(3, 7, West))(move(Coordinates(4, 7, West)))
    }
  }

  describe("perform(Coordinates, Instruction)")
  {
    it("Performed instruction successfully")
    {
      assertResult(Coordinates(1, 2, North))(perform(Coordinates(1, 1, North), Move))
      assertResult(Coordinates(1, 1, East))(perform(Coordinates(1, 1, North), Right))
      assertResult(Coordinates(1, 1, West))(perform(Coordinates(1, 1, North), Left))
    }
  }
}
