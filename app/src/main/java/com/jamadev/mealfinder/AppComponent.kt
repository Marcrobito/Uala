package com.jamadev.mealfinder

import com.jamadev.mealfinder.detail.MealDetailFragment
import com.jamadev.mealfinder.detail.MealDetailModule
import com.jamadev.mealfinder.network.NetworkModule
import com.jamadev.mealfinder.finder.RecipeFinderFragment
import com.jamadev.mealfinder.finder.RecipeFinderModule
import com.jamadev.mealfinder.repository.RepositoryModule
import com.jamadev.mealfinder.service.RandomMealService
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoryModule::class, RecipeFinderModule::class, MealDetailModule::class])

interface AppComponent {
    fun inject(finder: RecipeFinderFragment)
    fun inject(detail: MealDetailFragment)
    fun inject(service: RandomMealService)
}