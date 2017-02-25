package com.karaskiewicz.rx_extensions.util

import io.reactivex.Observable

fun infiniteIterator() = object : Iterator<Int> {
    var counter = 0

    override fun hasNext() = true

    override fun next() = counter++
}

fun infiniteSequence() = Observable.fromIterable(
        object : Iterable<Int> {
            override fun iterator() = infiniteIterator()
        }
)