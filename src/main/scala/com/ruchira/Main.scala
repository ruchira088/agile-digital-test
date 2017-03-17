package com.ruchira

import java.io.{File, PrintWriter}

import scala.io.Source

object Main
{
  val INPUT_FILE = "input.txt"

  val OUTPUT_FILE = "output.txt"

  def main(args: Array[String]): Unit =
  {
    val getPath: (String => String) = fileName => {
      new File(fileName) getAbsolutePath
    }

    val writeToFile: ((String, String) => Unit) = (inputFilePath, contents) => {
      new PrintWriter(inputFilePath) {
        write(contents)
        close
      }
    }

    val inputFilePath = getPath(INPUT_FILE)
    val inputFileContents = Source.fromFile(inputFilePath).mkString.split("\n").tail
    val inputs = splitInput(inputFileContents)

    val output = inputs
        .map(input => explore(input._1, input._2).toString)
        .reduce((content, result) => content + "\n" + result)

    writeToFile(getPath(OUTPUT_FILE), output)
  }

  def splitInput(inputs: Array[String]): Array[(String, String)] =
  {
    if(inputs.isEmpty) {
      Array()
    } else {
      Array((inputs.head, inputs.tail.head)) ++ splitInput(inputs.tail.tail)
    }
  }

  def explore(coordinates: String, instructions: String): Coordinates =
  {
    performInstructions(Coordinates.convertToCoordinates(coordinates), convertToInstructions(instructions))
  }

  def convertToInstructions(instructions: String): Array[Instruction] =
  {
    instructions.split("").map(Instruction.convertToInstruction)
  }

  def performInstructions(initialPosition: Coordinates, instructions: Array[Instruction]): Coordinates = {
    instructions.foldLeft(initialPosition)(Instruction.perform)
  }
}
