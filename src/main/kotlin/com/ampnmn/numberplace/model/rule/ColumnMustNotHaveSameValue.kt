package com.ampnmn.numberplace.model.rule

import com.ampnmn.numberplace.model.Board
import com.ampnmn.numberplace.model.Index

object ColumnMustNotHaveSameValue : NumberPlaceRule {
    override fun verify(board: Board, index: Index, value: String): Boolean {
        return board.column(index.x).map { it.value }.contains(value).not()
    }
}
