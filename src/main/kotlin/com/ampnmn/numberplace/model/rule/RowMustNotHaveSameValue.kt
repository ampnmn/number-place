package com.ampnmn.numberplace.model.rule

import com.ampnmn.numberplace.model.Board
import com.ampnmn.numberplace.model.Index

object RowMustNotHaveSameValue : NumberPlaceRule {
    override fun verify(board: Board, index: Index, value: String): Boolean {
        return board.row(index.y).map { it.value }.contains(value).not()
    }
}
