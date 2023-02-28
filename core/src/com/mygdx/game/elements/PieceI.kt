package com.mygdx.game.elements

class PieceI {
    var blocks: Array<Array<Block>> = arrayOf(
        arrayOf(Block(0, 4), Block(1, 4), Block(2, 4), Block(3, 4)),
        arrayOf(Block(2, 3), Block(2, 4), Block(2, 5), Block(2, 6)),
        arrayOf(Block(0, 6), Block(1, 6), Block(2, 6), Block(3, 6)),
        arrayOf(Block(0, 3), Block(0, 4), Block(0, 5), Block(0, 6))
    )
    var currentRotation = 0
}