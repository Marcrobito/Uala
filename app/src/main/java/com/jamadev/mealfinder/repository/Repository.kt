package com.jamadev.mealfinder.repository

import com.jamadev.mealfinder.models.Meals
import com.jamadev.mealfinder.network.RecipesApi
import retrofit2.Call
import retrofit2.Response

class Repository(private val network:RecipesApi) : MealsRepository {


    override suspend fun fetchFinderData(query: String): Response<Meals>? = network.getMeals(query)




}

