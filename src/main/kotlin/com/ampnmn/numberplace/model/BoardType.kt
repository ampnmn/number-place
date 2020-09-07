package com.ampnmn.numberplace.model

import kotlin.math.pow
import kotlin.math.sqrt

enum class BoardType(
        val numberRange: IntRange
) {
    TwoByTwo(1..4),
    ThreeByThree(1..9),
    FourByFour(1..16),
    FiveByFive(1..25);

    val minNumber: Int = numberRange.minOrNull()!!
    val maxNumber: Int = numberRange.maxOrNull()!!
    val boardSize: Int = numberRange.count()
    val blockSize: Int = sqrt(boardSize.toDouble()).toInt()
    val cellSize: Int = boardSize.toDouble().pow(2).toInt()
    val topIndexes = (minNumber until maxNumber step blockSize).let {
        it.flatMap { y -> it.map { x -> Index(x, y) } }
    }

    companion object {
        fun cellSizeOf(size: Int) = values().single { it.cellSize == size }
    }
}
