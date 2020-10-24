package com.jamadev.mealfinder.repository

import android.util.Log
import com.jamadev.mealfinder.models.Meals
import com.jamadev.mealfinder.network.RecipesApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response
import java.util.logging.Logger

class Repository(private val network:RecipesApi) : MealsRepository {


    override suspend fun fetchFinderData(query: String):Meals? = network.getMeals(query)



}

