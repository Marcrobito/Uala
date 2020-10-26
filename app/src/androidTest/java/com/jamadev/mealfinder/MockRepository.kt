package com.jamadev.mealfinder

import com.jamadev.mealfinder.models.Meals
import com.jamadev.mealfinder.repository.MealsRepository

class MockRepository:MealsRepository {
    override suspend fun fetchFinderData(query: String): Meals {
        TODO("Not yet implemented")
    }

    override suspend fun fetchMealData(id: Int): Meals {
        TODO("Not yet implemented")
    }

    override suspend fun fetchRandomMeal(): Meals {
        TODO("Not yet implemented")
    }
}