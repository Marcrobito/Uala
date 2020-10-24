package com.jamadev.mealfinder.repository

import com.jamadev.mealfinder.models.Meals
import retrofit2.Response

interface MealsRepository {
    suspend fun fetchFinderData(query:String): Response<Meals>?
}