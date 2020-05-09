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
            (1..board.size).map {
                it.toString()
            }.filterNot {
                board.row(cell.index.y).cells.toValues().contains(it)
            }.filterNot {
                board.column(cell.index.x).cells.toValues().contains(it)
            }.filterNot {
                val square = board.squares.find { square -> square.contains(cell) }!!
                square.cells.toValues().contains(it)
            }.let {
                cell.index to it.joinToString(separator = ",")
            }
        }.toMap()
    }

    private fun List<Cell>.toValues(): List<String> = this.map { it.value }
}
