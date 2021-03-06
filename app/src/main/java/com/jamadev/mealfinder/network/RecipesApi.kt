package com.jamadev.mealfinder.network

import com.jamadev.mealfinder.models.Meal
import com.jamadev.mealfinder.models.Meals
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesApi {

    @GET("search.php?s=")
    suspend fun getMeals(@Query("s") query: String): Meals

    @GET("lookup.php?")
    suspend fun getMeal(@Query("i") id: Int): Meals

    @GET("random.php")
    suspend fun getRandomMeal(): Meals
}