package com.jamadev.mealfinder

import android.app.Application
import android.content.Intent
import com.jamadev.mealfinder.network.NetworkModule
import com.jamadev.mealfinder.repository.RepositoryModule
import com.jamadev.mealfinder.service.RandomMealService
import javax.inject.Singleton

@Singleton
class App:Application() {

    private lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
        val i = Intent(this, RandomMealService::class.java)
        startService(i)
    }

    fun getComponent() = component
}