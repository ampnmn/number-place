package com.ampnmn.numberplace.model

import com.ampnmn.numberplace.model.rule.BlockMustNotHaveSameValue
import com.ampnmn.numberplace.model.rule.ColumnMustNotHaveSameValue
import com.ampnmn.numberplace.model.rule.RowMustNotHaveSameValue

class BoardAnalyzer(
        private val board: Board
) {
    companion object {
        val rules = listOf(
                RowMustNotHaveSameValue,
                ColumnMustNotHaveSameValue,
                BlockMustNotHaveSameValue
        )
    }

    /**
     * セル毎に候補を出す
     */
    fun analyze(): Map<Index, List<String>> {

        return board.cells.filter { cell ->
            cell.isEmpty()
        }.map { cell ->
            (Board.minValue..Board.maxValue)
                    .map { it.toString() }
                    .filter { value -> rules.all { it.verify(board, cell.index, value) } }
                    .let { cell.index to it }
        }.toMap()
    }
}
