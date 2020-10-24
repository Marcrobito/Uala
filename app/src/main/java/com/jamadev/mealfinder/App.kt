package com.jamadev.mealfinder

import android.app.Application
import com.jamadev.mealfinder.network.NetworkModule
import com.jamadev.mealfinder.repository.RepositoryModule

class App:Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
    }

    fun getComponent() = component
}