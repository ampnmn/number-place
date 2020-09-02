package com.ampnmn.numberplace.controller

import com.ampnmn.numberplace.model.*
import com.ampnmn.numberplace.model.Number
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("number-place")
class NumberPlaceController {
    @GetMapping
    fun getIndex(model: Model): String {
        Board(listOf(
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
        )).also {
            model.addAttribute("board", it)
        }
        return "index"
    }

    @PostMapping("analyze")
    @ResponseBody
    fun analyze(model: Model, @RequestBody joinedStr: Array<String>): List<Possibility> {
        return Board(joinedStr.toCells()).let {
            BoardAnalyzer(it).analyze()
        }.map { (index, values) ->
            Possibility(index, values.map(Number::toString))
        }
    }

    /**
     * [x,y,value] のように [,] で連結された文字列配列を Cell のリストに変換する
     */
    private fun Array<String>.toCells() = map { joined ->
        joined.split(',').let {
            Cell(index = Index(x = it[0].toInt(), y = it[1].toInt()), number = Number(it[2]))
        }
    }

    data class Possibility(
            val index: Index,
            val possibles: List<String>
    )
}
