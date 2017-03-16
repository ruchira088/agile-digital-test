package com.ruchira

object Main
{
  def main(args: Array[String]): Unit =
  {

    val coordinates = "3 3 3"
    val instructions = "MMRMMRMRRM"

    println(performInstructions(Coordinates.convertToCoordinates(coordinates), convertToInstructions(instructions)))
  }

  def convertToInstructions(instructions: String): Array[Instruction] =
  {
    instructions.split("").map(Instruction.convertToInstruction)
  }

  def performInstructions(initialPosition: Coordinates, instructions: Array[Instruction]): Coordinates = {
    instructions.foldLeft(initialPosition)(Instruction.perform)
  }
}
