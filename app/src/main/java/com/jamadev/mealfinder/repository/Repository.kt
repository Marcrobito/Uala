package com.jamadev.mealfinder.repository

import com.jamadev.mealfinder.models.Meal
import com.jamadev.mealfinder.models.Meals
import com.jamadev.mealfinder.network.RecipesApi
import javax.inject.Singleton

@Singleton
class Repository(private val network:RecipesApi) : MealsRepository {
    override suspend fun fetchFinderData(query: String): Meals = network.getMeals(query)
    override suspend fun fetchMealData(id: Int): Meals = network.getMeal(id)
}

