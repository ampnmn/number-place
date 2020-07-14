package com.ampnmn.numberplace.controller

import com.ampnmn.numberplace.model.Board
import com.ampnmn.numberplace.model.BoardAnalyzer
import com.ampnmn.numberplace.model.Cell
import com.ampnmn.numberplace.model.Index
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("number-place")
class NumberPlaceController {
    @GetMapping
    fun getIndex(model: Model): String {
        Board(listOf(
                Cell(Index(1, 1), ""),
                Cell(Index(1, 2), "2"),
                Cell(Index(1, 3), ""),
                Cell(Index(1, 4), ""),
                Cell(Index(1, 5), "6"),
                Cell(Index(1, 6), ""),
                Cell(Index(1, 7), ""),
                Cell(Index(1, 8), ""),
                Cell(Index(1, 9), "9"),

                Cell(Index(2, 1), "9"),
                Cell(Index(2, 2), ""),
                Cell(Index(2, 3), "6"),
                Cell(Index(2, 4), "4"),
                Cell(Index(2, 5), ""),
                Cell(Index(2, 6), ""),
                Cell(Index(2, 7), ""),
                Cell(Index(2, 8), "2"),
                Cell(Index(2, 9), ""),

                Cell(Index(3, 1), ""),
                Cell(Index(3, 2), "5"),
                Cell(Index(3, 3), ""),
                Cell(Index(3, 4), ""),
                Cell(Index(3, 5), ""),
                Cell(Index(3, 6), ""),
                Cell(Index(3, 7), "1"),
                Cell(Index(3, 8), "6"),
                Cell(Index(3, 9), "4"),

                Cell(Index(4, 1), "8"),
                Cell(Index(4, 2), ""),
                Cell(Index(4, 3), "5"),
                Cell(Index(4, 4), ""),
                Cell(Index(4, 5), ""),
                Cell(Index(4, 6), ""),
                Cell(Index(4, 7), "2"),
                Cell(Index(4, 8), "1"),
                Cell(Index(4, 9), ""),

                Cell(Index(5, 1), ""),
                Cell(Index(5, 2), "1"),
                Cell(Index(5, 3), ""),
                Cell(Index(5, 4), ""),
                Cell(Index(5, 5), "3"),
                Cell(Index(5, 6), ""),
                Cell(Index(5, 7), ""),
                Cell(Index(5, 8), ""),
                Cell(Index(5, 9), "8"),

                Cell(Index(6, 1), "7"),
                Cell(Index(6, 2), "3"),
                Cell(Index(6, 3), ""),
                Cell(Index(6, 4), "2"),
                Cell(Index(6, 5), ""),
                Cell(Index(6, 6), "1"),
                Cell(Index(6, 7), ""),
                Cell(Index(6, 8), ""),
                Cell(Index(6, 9), ""),

                Cell(Index(7, 1), ""),
                Cell(Index(7, 2), ""),
                Cell(Index(7, 3), ""),
                Cell(Index(7, 4), "1"),
                Cell(Index(7, 5), ""),
                Cell(Index(7, 6), "2"),
                Cell(Index(7, 7), "6"),
                Cell(Index(7, 8), ""),
                Cell(Index(7, 9), ""),

                Cell(Index(8, 1), ""),
                Cell(Index(8, 2), "6"),
                Cell(Index(8, 3), "4"),
                Cell(Index(8, 4), ""),
                Cell(Index(8, 5), ""),
                Cell(Index(8, 6), "3"),
                Cell(Index(8, 7), ""),
                Cell(Index(8, 8), ""),
                Cell(Index(8, 9), "2"),

                Cell(Index(9, 1), "2"),
                Cell(Index(9, 2), ""),
                Cell(Index(9, 3), "8"),
                Cell(Index(9, 4), "6"),
                Cell(Index(9, 5), "5"),
                Cell(Index(9, 6), ""),
                Cell(Index(9, 7), "4"),
                Cell(Index(9, 8), ""),
                Cell(Index(9, 9), "1")
        )).also {
            model.addAttribute("board", it)
        }
        return "index"
    }

    @PostMapping("analyze")
    @ResponseBody
    fun analyze(model: Model, @RequestBody board: Array<String>): List<Level> {
        return board.map {
            val arr = it.split(',')
            Cell(index = Index(x = arr[0].toInt(), y = arr[1].toInt()), value = arr[2])
        }.let {
            Board(it)
        }.let {
            BoardAnalyzer(it).analyze()
        }.map { (index, values) ->
            Level(index, values.size)
        }
    }

    data class Level(
            val index: Index,
            val level: Int
    )
}
