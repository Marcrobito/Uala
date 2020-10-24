package com.jamadev.mealfinder.network

import com.jamadev.mealfinder.models.Meals
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipesApi {

    @GET("search.php?s=")
    suspend fun getMeals(@Query("s") query:String): Response<Meals>


}