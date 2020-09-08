package com.ampnmn.numberplace.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class BoardAnalyzerTest {
    @Test
    fun analyzeTest() {
        val board = Board(
                type = BoardType.ThreeByThree,
                cells = listOf(
                        Cell(Index(1, 1), Number("")),
                        Cell(Index(1, 2), Number("2")),
                        Cell(Index(1, 3), Number("")),
                        Cell(Index(1, 4), Number("")),
                        Cell(Index(1, 5), Number("6")),
                        Cell(Index(1, 6), Number("")),
                        Cell(Index(1, 7), Number("")),
                        Cell(Index(1, 8), Number("")),
                        Cell(Index(1, 9), Number("9")),

                        Cell(Index(2, 1), Number("9")),
                        Cell(Index(2, 2), Number("")),
                        Cell(Index(2, 3), Number("6")),
                        Cell(Index(2, 4), Number("4")),
                        Cell(Index(2, 5), Number("")),
                        Cell(Index(2, 6), Number("")),
                        Cell(Index(2, 7), Number("")),
                        Cell(Index(2, 8), Number("2")),
                        Cell(Index(2, 9), Number("")),

                        Cell(Index(3, 1), Number("")),
                        Cell(Index(3, 2), Number("5")),
                        Cell(Index(3, 3), Number("")),
                        Cell(Index(3, 4), Number("")),
                        Cell(Index(3, 5), Number("")),
                        Cell(Index(3, 6), Number("")),
                        Cell(Index(3, 7), Number("1")),
                        Cell(Index(3, 8), Number("6")),
                        Cell(Index(3, 9), Number("4")),

                        Cell(Index(4, 1), Number("8")),
                        Cell(Index(4, 2), Number("")),
                        Cell(Index(4, 3), Number("5")),
                        Cell(Index(4, 4), Number("")),
                        Cell(Index(4, 5), Number("")),
                        Cell(Index(4, 6), Number("")),
                        Cell(Index(4, 7), Number("2")),
                        Cell(Index(4, 8), Number("1")),
                        Cell(Index(4, 9), Number("")),

                        Cell(Index(5, 1), Number("")),
                        Cell(Index(5, 2), Number("1")),
                        Cell(Index(5, 3), Number("")),
                        Cell(Index(5, 4), Number("")),
                        Cell(Index(5, 5), Number("3")),
                        Cell(Index(5, 6), Number("")),
                        Cell(Index(5, 7), Number("")),
                        Cell(Index(5, 8), Number("")),
                        Cell(Index(5, 9), Number("8")),

                        Cell(Index(6, 1), Number("7")),
                        Cell(Index(6, 2), Number("3")),
                        Cell(Index(6, 3), Number("")),
                        Cell(Index(6, 4), Number("2")),
                        Cell(Index(6, 5), Number("")),
                        Cell(Index(6, 6), Number("1")),
                        Cell(Index(6, 7), Number("")),
                        Cell(Index(6, 8), Number("")),
                        Cell(Index(6, 9), Number("")),

                        Cell(Index(7, 1), Number("")),
                        Cell(Index(7, 2), Number("")),
                        Cell(Index(7, 3), Number("")),
                        Cell(Index(7, 4), Number("1")),
                        Cell(Index(7, 5), Number("")),
                        Cell(Index(7, 6), Number("2")),
                        Cell(Index(7, 7), Number("6")),
                        Cell(Index(7, 8), Number("")),
                        Cell(Index(7, 9), Number("")),

                        Cell(Index(8, 1), Number("")),
                        Cell(Index(8, 2), Number("6")),
                        Cell(Index(8, 3), Number("4")),
                        Cell(Index(8, 4), Number("")),
                        Cell(Index(8, 5), Number("")),
                        Cell(Index(8, 6), Number("3")),
                        Cell(Index(8, 7), Number("")),
                        Cell(Index(8, 8), Number("")),
                        Cell(Index(8, 9), Number("2")),

                        Cell(Index(9, 1), Number("2")),
                        Cell(Index(9, 2), Number("")),
                        Cell(Index(9, 3), Number("8")),
                        Cell(Index(9, 4), Number("6")),
                        Cell(Index(9, 5), Number("5")),
                        Cell(Index(9, 6), Number("")),
                        Cell(Index(9, 7), Number("4")),
                        Cell(Index(9, 8), Number("")),
                        Cell(Index(9, 9), Number("1"))
                ))

        val actual = BoardAnalyzer(board).analyze()
        Assertions.assertTrue(
                actual.size == 46
        )
        Assertions.assertTrue(
                actual[Index(3, 1)] == listOf(Number("3"))
        )
        Assertions.assertTrue(
                actual[Index(6, 3)] == listOf(Number("9"))
        )
    }

    companion object {
        @JvmStatic
        fun indexProvider() = (1..9).let {
            it.flatMap { x -> it.map { y -> Index(x, y) } }
        }

        @JvmStatic
        private val emptyBoard = indexProvider().map {
            Cell(it, Number(""))
        }.let {
            Board(
                    type = BoardType.ThreeByThree,
                    cells = it
            )
        }
    }

    @ParameterizedTest
    @MethodSource("indexProvider")
    fun blockTest(index: Index) {
        Assertions.assertTrue(
                index in emptyBoard.getBlock(Cell(index, Number(""))).map { it.index }
        )
    }
}
