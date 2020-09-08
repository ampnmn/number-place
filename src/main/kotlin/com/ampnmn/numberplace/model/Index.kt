package com.ampnmn.numberPlace.model

data class Index(val x: Int, val y: Int) : Comparable<Index> {
    override fun compareTo(other: Index): Int {
        return if (x == other.x) y.compareTo(other.y)
        else x.compareTo(other.x)
    }
}
