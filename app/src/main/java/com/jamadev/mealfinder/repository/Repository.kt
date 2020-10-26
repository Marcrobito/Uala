package com.jamadev.mealfinder.repository

import com.jamadev.mealfinder.models.Meals
import com.jamadev.mealfinder.network.RecipesApi
import javax.inject.Singleton

@Singleton
class Repository(private val network:RecipesApi) : MealsRepository {
    override suspend fun fetchFinderData(query: String) = network.getMeals(query)
    override suspend fun fetchMealData(id: Int) = network.getMeal(id)
    override suspend fun fetchRandomMeal() = network.getRandomMeal()
}

