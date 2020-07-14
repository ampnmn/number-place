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
                board.row(cell.index.y).values().contains(it)
            }.filterNot {
                board.column(cell.index.x).values().contains(it)
            }.filterNot {
                board.block(cell.index.y, cell.index.x).values().contains(it)
            }.let {
                cell.index to it
            }
        }.toMap()
    }

    private fun List<Cell>.values() = this.map { it.value }
}
