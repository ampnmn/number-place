package com.ampnmn.numberPlace.model

class Row(cells: List<Cell>) : List<Cell> by cells {
    val numbers = cells.map { it.number }
    fun containsNumber(number: Number): Boolean {
        return numbers.contains(number)
    }
}
