package com.jamadev.mealfinder.repository

import com.jamadev.mealfinder.models.Meals

interface MealsRepository {
    suspend fun fetchFinderData(query: String): Meals
    suspend fun fetchMealData(id: Int): Meals
}