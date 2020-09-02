//package com.ampnmn.numberplace.model
//
//import org.junit.jupiter.api.Assertions
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.params.ParameterizedTest
//import org.junit.jupiter.params.provider.MethodSource
//
//internal class BoardAnalyzerTest {
//    @Test
//    fun analyzeTest() {
//        val board = Board(listOf(
//                Cell(Index(1, 1), ""),
//                Cell(Index(1, 2), "2"),
//                Cell(Index(1, 3), ""),
//                Cell(Index(1, 4), ""),
//                Cell(Index(1, 5), "6"),
//                Cell(Index(1, 6), ""),
//                Cell(Index(1, 7), ""),
//                Cell(Index(1, 8), ""),
//                Cell(Index(1, 9), "9"),
//
//                Cell(Index(2, 1), "9"),
//                Cell(Index(2, 2), ""),
//                Cell(Index(2, 3), "6"),
//                Cell(Index(2, 4), "4"),
//                Cell(Index(2, 5), ""),
//                Cell(Index(2, 6), ""),
//                Cell(Index(2, 7), ""),
//                Cell(Index(2, 8), "2"),
//                Cell(Index(2, 9), ""),
//
//                Cell(Index(3, 1), ""),
//                Cell(Index(3, 2), "5"),
//                Cell(Index(3, 3), ""),
//                Cell(Index(3, 4), ""),
//                Cell(Index(3, 5), ""),
//                Cell(Index(3, 6), ""),
//                Cell(Index(3, 7), "1"),
//                Cell(Index(3, 8), "6"),
//                Cell(Index(3, 9), "4"),
//
//                Cell(Index(4, 1), "8"),
//                Cell(Index(4, 2), ""),
//                Cell(Index(4, 3), "5"),
//                Cell(Index(4, 4), ""),
//                Cell(Index(4, 5), ""),
//                Cell(Index(4, 6), ""),
//                Cell(Index(4, 7), "2"),
//                Cell(Index(4, 8), "1"),
//                Cell(Index(4, 9), ""),
//
//                Cell(Index(5, 1), ""),
//                Cell(Index(5, 2), "1"),
//                Cell(Index(5, 3), ""),
//                Cell(Index(5, 4), ""),
//                Cell(Index(5, 5), "3"),
//                Cell(Index(5, 6), ""),
//                Cell(Index(5, 7), ""),
//                Cell(Index(5, 8), ""),
//                Cell(Index(5, 9), "8"),
//
//                Cell(Index(6, 1), "7"),
//                Cell(Index(6, 2), "3"),
//                Cell(Index(6, 3), ""),
//                Cell(Index(6, 4), "2"),
//                Cell(Index(6, 5), ""),
//                Cell(Index(6, 6), "1"),
//                Cell(Index(6, 7), ""),
//                Cell(Index(6, 8), ""),
//                Cell(Index(6, 9), ""),
//
//                Cell(Index(7, 1), ""),
//                Cell(Index(7, 2), ""),
//                Cell(Index(7, 3), ""),
//                Cell(Index(7, 4), "1"),
//                Cell(Index(7, 5), ""),
//                Cell(Index(7, 6), "2"),
//                Cell(Index(7, 7), "6"),
//                Cell(Index(7, 8), ""),
//                Cell(Index(7, 9), ""),
//
//                Cell(Index(8, 1), ""),
//                Cell(Index(8, 2), "6"),
//                Cell(Index(8, 3), "4"),
//                Cell(Index(8, 4), ""),
//                Cell(Index(8, 5), ""),
//                Cell(Index(8, 6), "3"),
//                Cell(Index(8, 7), ""),
//                Cell(Index(8, 8), ""),
//                Cell(Index(8, 9), "2"),
//
//                Cell(Index(9, 1), "2"),
//                Cell(Index(9, 2), ""),
//                Cell(Index(9, 3), "8"),
//                Cell(Index(9, 4), "6"),
//                Cell(Index(9, 5), "5"),
//                Cell(Index(9, 6), ""),
//                Cell(Index(9, 7), "4"),
//                Cell(Index(9, 8), ""),
//                Cell(Index(9, 9), "1")
//        ))
//
//        val actual = BoardAnalyzer(board).analyze()
//        Assertions.assertEquals(
//                mapOf(
//                        Index(1, 1) to listOf("4"),
//                        Index(1, 3) to listOf("1"),
//                        Index(2, 2) to listOf("8"),
//                        Index(2, 5) to listOf("1"),
//                        Index(3, 1) to listOf("3"),
//                        Index(3, 5) to listOf("2"),
//                        Index(4, 2) to listOf("4"),
//                        Index(4, 9) to listOf("3"),
//                        Index(5, 1) to listOf("6"),
//                        Index(5, 3) to listOf("2"),
//                        Index(6, 3) to listOf("9"),
//                        Index(6, 5) to listOf("8"),
//                        Index(6, 9) to listOf("6"),
//                        Index(7, 5) to listOf("4"),
//                        Index(8, 1) to listOf("1"),
//                        Index(9, 8) to listOf("3")
//                ),
//                actual.filter { it.value.size == 1 }
//        )
//    }
//
//    companion object {
//        @JvmStatic
//        @Suppress("unused")
//        fun indexProvider() = (1..9).let {
//            it.flatMap { x -> it.map { y -> Index(x, y) } }
//        }
//
//        @JvmStatic
//        private val emptyBoard = indexProvider().map {
//            Cell(it, "${it.x},${it.y}")
//        }.let {
//            Board(it)
//        }
//    }
//
//    @ParameterizedTest
//    @MethodSource("indexProvider")
//    fun blockTest(index: Index) {
//        Assertions.assertTrue(
//                index in emptyBoard.block(index.y, index.x).map { it.index }
//        )
//    }
//}
