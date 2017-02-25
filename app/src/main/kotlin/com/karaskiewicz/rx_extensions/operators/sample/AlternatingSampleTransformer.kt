package com.karaskiewicz.rx_extensions.operators.sample

import com.karaskiewicz.rx_extensions.util.infiniteSequence
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

class AlternatingSampleTransformer<T>(private val delayFunction: (Int) -> Long) : ObservableTransformer<T, T> {

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.sample(
                infiniteSequence().delay<Long>(Function {
                    sequenceElement ->
                    Observable.timer(delayFunction(sequenceElement), TimeUnit.MILLISECONDS)
                })
        )
    }
}