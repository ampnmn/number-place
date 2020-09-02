package com.ampnmn.numberplace.model

class Column(cells: List<Cell>) : List<Cell> by cells {
    val numbers = cells.map { it.number }
    fun containsNumber(number: Number): Boolean {
        return numbers.contains(number)
    }
}
