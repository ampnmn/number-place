package com.ampnmn.numberplace.model

/**
 * 正方形
 */
data class Square(
        val cells: List<Cell>
) {
    fun contains(cell: Cell) = cells.contains(cell)
}
