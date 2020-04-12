package com.ampnmn.numberplace.model

class BoardAnalyzer(
        private val board: Board
) {
    /**
     * セル毎に候補を出す
     */
    fun analyze(): Map<Index, String> {
        return board.cells.filter { cell ->
            cell.isEmpty()
        }.map { cell ->
            (1..board.size).filter {
                board.row(cell.index.y).containsNot(it)
            }.filter {
                board.column(cell.index.x).containsNot(it)
            }.filter {
                val square = board.squares.find { square -> square.contains(cell) }!!
                square.cells.containsNot(it)
            }.let {
                cell.index to it.joinToString(separator = ",")
            }
        }.toMap()
    }

    private fun List<Cell>.containsNot(value: Int): Boolean = this.all { cell ->
        cell.value != value.toString()
    }
}
