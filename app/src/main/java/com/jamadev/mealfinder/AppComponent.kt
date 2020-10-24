package com.jamadev.mealfinder

import com.jamadev.mealfinder.network.NetworkModule
import com.jamadev.mealfinder.recipefinder.RecipeFinderFragment
import com.jamadev.mealfinder.recipefinder.RecipeFinderModule
import com.jamadev.mealfinder.repository.MealsRepository
import com.jamadev.mealfinder.repository.RepositoryModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class, RecipeFinderModule::class])

interface AppComponent {
    fun inject(finder: RecipeFinderFragment)
}