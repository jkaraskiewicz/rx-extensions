package com.karaskiewicz.rx_extensions.operators.indexed

import com.karaskiewicz.rx_extensions.util.IndexedElement
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer

class IndexedElementTransformer<T> : ObservableTransformer<T, IndexedElement<T>> {

    override fun apply(upstream: Observable<T>): ObservableSource<IndexedElement<T>> {
        return upstream.scan(
                IndexedElement(),
                { last, newValue -> IndexedElement(newValue, last.index + 1) }
        )
    }
}