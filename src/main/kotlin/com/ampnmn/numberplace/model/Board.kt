package com.ampnmn.numberplace.model

/**
 * ボード
 */
data class Board(
        val cells: List<Cell>
) {
    companion object {
        const val minValue = 1
        const val maxValue = 9
        const val boardSize = 9
        const val blockSize = 3
    }

    init {
        if (cells.size != boardSize * boardSize)
            throw IllegalArgumentException("Incomprehensible!!")
    }

    val rows = (1..boardSize).map { row(it) }

    fun row(rowNumber: Int): List<Cell> = cells.filter {
        it.index.y == rowNumber
    }

    fun column(columnNumber: Int): List<Cell> = cells.filter {
        it.index.x == columnNumber
    }

    fun block(rowNumber: Int, columnNumber: Int): List<Cell> {
        val top = (minValue until maxValue step blockSize).let {
            it.flatMap { y -> it.map { x -> Index(x, y) } }
        }.filter {
            it.x <= columnNumber && it.y <= rowNumber
        }.maxOrNull() ?: throw IllegalArgumentException("top-cell is not found.")

        return (top.y until top.y + blockSize).flatMap { y ->
            (top.x until top.x + blockSize).mapNotNull { x ->
                cells.find { it.index.x == x && it.index.y == y }
            }
        }
    }
}
