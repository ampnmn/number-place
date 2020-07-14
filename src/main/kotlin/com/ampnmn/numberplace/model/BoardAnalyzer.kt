package com.ampnmn.numberplace.model

class BoardAnalyzer(
        private val board: Board
) {
    /**
     * セル毎に候補を出す
     */
    fun analyze(): Map<Index, List<String>> {
        return board.cells.filter { cell ->
            cell.isEmpty()
        }.map { cell ->
            (Board.minValue..Board.maxValue).map {
                it.toString()
            }.filterNot {
                it in board.row(cell.index.y).values()
            }.filterNot {
                it in board.column(cell.index.x).values()
            }.filterNot {
                it in board.block(cell.index.y, cell.index.x).values()
            }.let {
                cell.index to it
            }
        }.toMap()
    }

    private fun List<Cell>.values() = this.map { it.value }
}
