# Agile Digital Test

Coding exercise from Agile Digital.

## Getting Started

### Input

The first line of input is the upper-right coordinates of the landing area, the lower-left coordinates are assumed to be 0,0.

The rest of the input is information pertaining to the explorers that have been deployed. Each explorer has two lines of input. The first line gives the explorer’s position, and the second line is a series of instructions telling the explorer how to explore the plateau.

The position is made up of two integers and a letter separated by spaces, corresponding to the x and y co-ordinates and the explorer’s orientation.

The inputs for the application is passed via `input.txt` in the root project directory.

Example

```text
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM

```

### Output

The output for each explorer should be its final co-ordinates and heading.

The output will be written to `output.txt` in the root project directory.

Example

```text
1 3 N
5 1 E
```

Once the inputs have been set in `input.txt`, navigate to the root directory and type the following the run the application

```sh
sbt run

```

## Running Tests

Navigate to root directory of the project and type the following the command line
```sh
sbt test

```