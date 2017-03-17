package com.ruchira

import org.scalatest.FunSpec

class MainTest extends FunSpec
{
  describe("Main()")
  {
    it("Expected output returned")
    {
      assertResult(Coordinates(1, 3, North))(Main.explore("1 2 N", "LMLMLMLMM"))
      assertResult(Coordinates(5, 1, East))(Main.explore("3 3 E", "MMRMMRMRRM"))
    }
  }
}
