package com.rehuapro

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val executionTime = measureTimeMillis {
        val deferredResults = mutableListOf<Deferred<Unit>>()
        for (i in 1..1000000) {
            deferredResults.add(async { launchCoroutine() })
        }
        awaitAll(*deferredResults.toTypedArray())
    }
    println("Done in $executionTime milliseconds")
}

suspend fun launchCoroutine() = coroutineScope {
    delay(1000L)
    println("Processed something!")
}