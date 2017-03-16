package com.ruchira

sealed trait Instruction {}

case object Left extends Instruction
case object Right extends Instruction
case object Move extends Instruction

object Instruction
{
  def convertToInstruction(instruction: String): Instruction =
  {
    instruction match {
      case "M" => Move
      case "L" => Left
      case "R" => Right
      case _ => throw new Exception(s"Invalid instruction: ${instruction}")
    }
  }

  def move(position: Coordinates): Coordinates =
  {
    position match {
      case Coordinates(x, y, South) => Coordinates(x, y-1, South)
      case Coordinates(x, y, West) => Coordinates(x-1, y, West)
      case Coordinates(x, y, North) => Coordinates(x, y+1, North)
      case Coordinates(x, y, East) => Coordinates(x+1, y, East)
    }
  }

  def perform(position: Coordinates, instruction: Instruction): Coordinates =
  {
    val Coordinates(x, y, direction) = position

    instruction match {
      case Move => move(position)
      case Left => Coordinates(x, y, Direction.rotateLeft(direction))
      case Right => Coordinates(x, y, Direction.rotateRight(direction))
    }
  }
}