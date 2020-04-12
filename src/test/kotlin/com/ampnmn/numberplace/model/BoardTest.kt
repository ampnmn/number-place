package com.ampnmn.numberplace.model

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BoardAnalyzerTest {
    @Test
    fun analyzeTest() {
        val board = Board(
                size = 4,
                squares = listOf(
                        Square(listOf(
                                Cell("1", Index(1, 1)),
                                Cell("3", Index(1, 2)),
                                Cell("", Index(2, 1)),
                                Cell("", Index(2, 2))
                        )),
                        Square(listOf(
                                Cell("", Index(3, 1)),
                                Cell("1", Index(3, 2)),
                                Cell("", Index(4, 1)),
                                Cell("2", Index(4, 2))
                        )),
                        Square(listOf(
                                Cell("4", Index(1, 3)),
                                Cell("", Index(1, 4)),
                                Cell("3", Index(2, 3)),
                                Cell("", Index(2, 4))
                        )),
                        Square(listOf(
                                Cell("", Index(3, 3)),
                                Cell("", Index(3, 4)),
                                Cell("1", Index(4, 3)),
                                Cell("3", Index(4, 4))
                        ))
                )
        )

        val actual = BoardAnalyzer(board).analyze()
        Assertions.assertEquals(
                mapOf(
                        Index(1, 4) to "2",
                        Index(2, 1) to "2,4",
                        Index(2, 2) to "4",
                        Index(2, 4) to "1,2",
                        Index(3, 1) to "3,4",
                        Index(3, 3) to "2",
                        Index(3, 4) to "2,4",
                        Index(4, 1) to "4"
                ),
                actual
        )
    }
}
