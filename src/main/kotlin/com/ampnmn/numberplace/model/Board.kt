package com.ampnmn.numberPlace.model

/**
 * ボード
 */
data class Board(
        val type: BoardType,
        val cells: List<Cell>
) {
    init {
        if (cells.size != type.cellCount)
            throw IllegalArgumentException("Incomprehensible cells.")
    }

    val rows: List<Row> = cells.groupBy { it.index.y }.values.map { Row(it) }

    val columns: List<Column> = cells.groupBy { it.index.x }.values.map { Column(it) }

    val blocks: List<Block> = type.topIndexes.map { top ->
        (top.x until top.x + type.blockSize).flatMap { x ->
            (top.y until top.y + type.blockSize).mapNotNull { y ->
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
