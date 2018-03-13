package com.chriswk.migraine

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class DiaryApp {
}

fun main(args: Array<String>) {
    SpringApplication.run(DiaryApp::class.java, *args)
}