package com.ruchira

import org.scalatest.FunSpec

class InstructionTest extends FunSpec
{
  describe("convertToInstruction(String)")
  {
    it("Successfully converted Strings to Instructions")
    {
      assert(Instruction.convertToInstruction("M").equals(Move))
      assert(Instruction.convertToInstruction("R").equals(Right))
      assert(Instruction.convertToInstruction("L").equals(Left))
    }
  }

  describe("move(Coordinates)")
  {
    it("Successfully moved")
    {
      assert(Instruction.move(Coordinates(1, 1, North)).equals(Coordinates(1, 2, North)))
      assert(Instruction.move(Coordinates(2, 5, East)).equals(Coordinates(3, 5, East)))
      assert(Instruction.move(Coordinates(6, 3, South)).equals(Coordinates(6, 2, South)))
      assert(Instruction.move(Coordinates(4, 7, West)).equals(Coordinates(3, 7, West)))
    }
  }

  describe("perform(Coordinates, Instruction)")
  {
    it("Performed instruction successfully")
    {
      assert(Instruction.perform(Coordinates(1, 1, North), Move).equals(Coordinates(1, 2, North)))
      assert(Instruction.perform(Coordinates(1, 1, North), Right).equals(Coordinates(1, 1, East)))
      assert(Instruction.perform(Coordinates(1, 1, North), Left).equals(Coordinates(1, 1, West)))
    }
  }
}
