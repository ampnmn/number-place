package com.ampnmn.numberplace.model

class BoardAnalyzer(
        private val board: Board
) {
    fun analyze(): Map<Index, List<Number>> {
        val numberRange = (Board.minValue..Board.maxValue).map { Number(it) }
        val emptyCells = board.getAllEmptyCells()
        return emptyCells.map { cell ->
            numberRange
                    .filterNot { number ->
                        board.getRow(cell).containsNumber(number)
                    }.filterNot { number ->
                        board.getColumn(cell).containsNumber(number)
                    }.filterNot { number ->
                        board.getBlock(cell).containsNumber(number)
                    }.let { numbers ->
                        cell.index to numbers
                    }
        }.toMap()

//                .let {
//            val replaced = numberRange.flatMap { i ->
//                it.replaceValuesWhenHavingOnlyOneValue(
//                        filter = { index ->
//                            index.x == i
//                        }
//                ) + it.replaceValuesWhenHavingOnlyOneValue(
//                        filter = { index ->
//                            index.y == i
//                        }
//                ) + it.replaceValuesWhenHavingOnlyOneValue(
//                        filter = { index ->
//                            board.blocks[i - 1].map { cell -> cell.index }.contains(index)
//                        }
//                )
//            }
//            it.toMap() + replaced.toMap()
//        }
    }

//    private fun List<Pair<Index, List<String>>>.replaceValuesWhenHavingOnlyOneValue(
//            filter: (Index) -> Boolean
//    ): List<Pair<Index, List<String>>> {
//        return filter { (index, _) ->
//            filter(index)
//        }.filter { (_, values) ->
//            values.size >= 2
//        }.let {
//            val allValues = it.flatMap { (_, values) -> values }
//            it.mapNotNull { (index, values) ->
//                values.find { value ->
//                    allValues.count { it == value } == 1
//                }?.let {
//                    index to listOf(it)
//                }
//            }
//        }
//    }
}
