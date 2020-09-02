package com.ampnmn.numberplace.model

/**
 * ボード
 */
data class Board(
        val cells: List<Cell>
) {
    init {
        if (cells.size != boardSize * boardSize)
            throw IllegalArgumentException("Incomprehensible cells.")
    }

    companion object {
        const val minValue = 1
        const val maxValue = 9
        const val boardSize = 9
        const val blockSize = 3

        val topIndexes = (minValue until maxValue step blockSize).let {
            it.flatMap { y -> it.map { x -> Index(x, y) } }
        }
    }

    val rows: List<Row> = cells.groupBy { it.index.y }.values.map { Row(it) }

    val columns: List<Column> = cells.groupBy { it.index.x }.values.map { Column(it) }

    val blocks: List<Block> = topIndexes.map { top ->
        (top.x until top.x + blockSize).flatMap { x ->
            (top.y until top.y + blockSize).mapNotNull { y ->
                cells.find { it.index.x == x && it.index.y == y }
            }
        }.let { Block(it) }
    }

    fun getAllEmptyCells() = cells.filter { it.isEmpty() }

    fun getRow(cell: Cell): Row = rows.find { cell.belongTo(it) }
            ?: throw IllegalArgumentException("")

    fun getColumn(cell: Cell): Column = columns.find { cell.belongTo(it) }
            ?: throw IllegalArgumentException("")

    fun getBlock(cell: Cell): Block = blocks.find { cell.belongTo(it) }
            ?: throw IllegalArgumentException("")
}
