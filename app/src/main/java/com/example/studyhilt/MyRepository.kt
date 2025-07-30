package com.example.studyhilt

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor() {
    fun getWelcomeMessage(): String = "Hello from Hilt Repository!"
}