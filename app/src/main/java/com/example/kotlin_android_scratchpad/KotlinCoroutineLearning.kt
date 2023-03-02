package com.example.kotlin_android_scratchpad

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

fun main() = runBlocking {
    greeting()
}

private suspend fun greeting() = coroutineScope {
    val job = launch {
        delay(1000L)
        println("World")
    }
    println("Hello")
    job.join()
    println("Done")
}