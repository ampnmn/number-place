package com.ampnmn.numberplace.model

data class Cell(
        val index: Index,
        val number: Number
) : Comparable<Cell> {
    override fun compareTo(other: Cell) = index.compareTo(other.index)
    fun isEmpty(): Boolean = number.isEmpty()
    fun isNotEmpty(): Boolean = number.isNotEmpty()
    fun belongTo(cells: List<Cell>): Boolean = cells.contains(this)
}
