package com.ampnmn.numberplace.model.rule

import com.ampnmn.numberplace.model.Board
import com.ampnmn.numberplace.model.Index

interface NumberPlaceRule {
    /**
     * この盤面のこの場所にはこの数字を入れられるか？
     */
    fun verify(board: Board, index: Index, value: String): Boolean
}
