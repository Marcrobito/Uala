package com.jamadev.mealfinder

import com.jamadev.mealfinder.network.NetworkModule
import com.jamadev.mealfinder.repository.RepositoryModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class])

interface AppComponent {
    fun inject(app: MainActivity)
}