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
        val valueRange = (Board.minValue..Board.maxValue)
        return board.cells.filter { it.isEmpty() }
                .map { emptyCell ->
                    valueRange.map { it.toString() }
                            .filter { value ->
                                rules.all { it.verify(board, emptyCell.index, value) }
                            }.let { values ->
                                emptyCell.index to values
                            }
                }.let {
                    val replaced = valueRange.flatMap { i ->
                        it.replaceValuesWhenHavingOnlyOneValue(
                                filter = { index ->
                                    index.x == i
                                }
                        ) + it.replaceValuesWhenHavingOnlyOneValue(
                                filter = { index ->
                                    index.y == i
                                }
                        ) + it.replaceValuesWhenHavingOnlyOneValue(
                                filter = { index ->
                                    board.blocks[i - 1].map { cell -> cell.index }.contains(index)
                                }
                        )
                    }
                    it.toMap() + replaced.toMap()
                }
    }

    private fun List<Pair<Index, List<String>>>.replaceValuesWhenHavingOnlyOneValue(
            filter: (Index) -> Boolean
    ): List<Pair<Index, List<String>>> {
        return filter { (index, _) ->
            filter(index)
        }.filter { (_, values) ->
            values.size >= 2
        }.let {
            val allValues = it.flatMap { (_, values) -> values }
            it.mapNotNull { (index, values) ->
                values.find { value ->
                    allValues.count { it == value } == 1
                }?.let {
                    index to listOf(it)
                }
            }
        }
    }
}
