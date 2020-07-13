package com.ampnmn.numberplace.model

/**
 * 値と位置
 */
data class Cell(
        val index: Index,
        val value: String
) : Comparable<Cell> {
    override fun compareTo(other: Cell) = index.compareTo(other.index)
    fun isEmpty(): Boolean = value.isEmpty()
}
