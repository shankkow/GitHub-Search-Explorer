package com.example.assignmenttrial1

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        // To provide the application context
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this // Set the instance when the application is created
    }

    // Function to get the application context
    fun applicationContext(): App {
        return instance
    }
}
