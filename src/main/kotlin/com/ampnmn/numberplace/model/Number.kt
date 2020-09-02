package com.ampnmn.numberplace.model

data class Number(val value: String) {

    constructor(value: Int) : this(value.toString())

    fun isEmpty(): Boolean = value.isEmpty()
    fun isNotEmpty(): Boolean = value.isNotEmpty()
    override fun toString(): String = value
}
