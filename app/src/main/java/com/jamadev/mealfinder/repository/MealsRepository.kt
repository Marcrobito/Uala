package com.jamadev.mealfinder.repository

import com.jamadev.mealfinder.models.Meals
import com.jamadev.mealfinder.recipefinder.FinderVM
import kotlinx.coroutines.CoroutineScope

interface MealsRepository {
    fun setFinderViewModel(finderVM: FinderVM, scope: CoroutineScope)
    suspend fun fetchFinderData(query:String):Meals?
}