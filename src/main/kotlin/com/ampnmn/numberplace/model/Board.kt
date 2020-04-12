package com.ampnmn.numberplace.model

/**
 * ボード
 */
data class Board(
        val size: Int,
        val squares: List<Square>
) {
    init {
        if (squares.size != size) throw IllegalArgumentException("Incomprehensible!!")
    }

    val cells: List<Cell>
        get() = squares.flatMap { it.cells }.sorted()

    fun row(number: Int): List<Cell> = cells.filter {
        it.index.y == number
    }

    fun column(number: Int): List<Cell> = cells.filter {
        it.index.x == number
    }
}
