package main

import (
	"fmt"
	"math/rand"
)

func main() {

	c1 := NewCharlie("CHARLIE", 20, 20, HORIZONTAL)
	c1.print()

	c2 := NewCharlie("CHARLIE", 20, 20, DIAGONAL)
	c2.print()

	c3 := NewCharlie("CHARLIE", 20, 20, VERTICAL)
	c3.print()

}

type direction struct {
	X int
	Y int
}

var HORIZONTAL = &direction{1, 0}
var VERTICAL = &direction{0, 1}
var DIAGONAL = &direction{1, 1}

const ANSI_RESET = "\u001B[0m"
const ANSI_RED = "\u001B[31m"

type charlie struct {
	Word      string
	Rows      int
	Columns   int
	Direction *direction
	tableau   [][]string
}

func NewCharlie(word string, rows int, columns int, direction *direction) *charlie {
	c := &charlie{
		Word:      word,
		Rows:      rows,
		Columns:   columns,
		Direction: direction,
	}

	c.init()
	c.fill()
	c.fillWord()
	return c
}

// init struct charlie
func (c *charlie) init() {
	c.tableau = make([][]string, c.Rows)
	for i := 0; i < c.Rows; i++ {
		c.tableau[i] = make([]string, c.Columns)
	}
}

func (c *charlie) fill() {

	for i := 0; i < c.Rows; i++ {
		for j := 0; j < c.Columns; j++ {
			c.tableau[i][j] = string(rand.Intn(26) + 65)
		}
	}

}

func (c *charlie) fillWord() {

	startRow := rand.Intn(c.Rows)
	if c.Direction.Y == 1 {
		startRow -= len(c.Word)
	}
	if startRow < 0 {
		startRow = 0
	}
	startColumn := rand.Intn(c.Columns)
	if c.Direction.X == 1 {
		startColumn -= len(c.Word)
	}
	if startColumn < 0 {
		startColumn = 0
	}

	for i := 0; i < len(c.Word); i++ {
		c.tableau[startRow+(c.Direction.Y*i)][startColumn+(c.Direction.X*i)] = ANSI_RED + c.Word[i:i+1] + ANSI_RESET
	}

}

func (c *charlie) print() {
	for i := 0; i < c.Rows; i++ {
		for j := 0; j < c.Columns; j++ {
			fmt.Print(c.tableau[i][j], " ")
		}
		fmt.Println()
	}
	fmt.Println()
	fmt.Println()
}
