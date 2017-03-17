package com.ruchira

import java.io.{File, PrintWriter}

import scala.io.Source

object Main
{
  val INPUT_FILE = "input.txt"

  val OUTPUT_FILE = "output.txt"

  /**
    * Main method
    */
  def main(args: Array[String]): Unit =
  {
    // Gets the absolute path of a file
    val getPath: (String => String) = fileName => {
      new File(fileName) getAbsolutePath
    }

    // Writes to a file
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

  /**
    * Maps Array[String] into Array[(String, String)]. This is to simplify
    * passing input arguments to explore(String, String).
    */
  def splitInput(inputs: Array[String]): Array[(String, String)] =
  {
    if(inputs.isEmpty) {
      Array()
    } else {
      Array((inputs.head, inputs.tail.head)) ++ splitInput(inputs.tail.tail)
    }
  }

  /**
    * Parses the string coordinates and the string instructions, executes the instructions
    * and then return the final coordinates
    */
  def explore(coordinates: String, instructions: String): Coordinates =
  {
    performInstructions(Coordinates.convertToCoordinates(coordinates), convertToInstructions(instructions))
  }

  /**
    * Converts a string into an array of instructions
    */
  def convertToInstructions(instructions: String): Array[Instruction] =
  {
    instructions.split("").map(Instruction.convertToInstruction)
  }

  /**
    * Performs the array of instructions, starting from the passed-in position
    */
  def performInstructions(initialPosition: Coordinates, instructions: Array[Instruction]): Coordinates = {
    instructions.foldLeft(initialPosition)(Instruction.perform)
  }
}
