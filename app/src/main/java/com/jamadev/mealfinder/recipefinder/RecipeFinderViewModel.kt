package com.jamadev.mealfinder.recipefinder

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamadev.mealfinder.repository.MealsRepository
import com.jamadev.mealfinder.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeFinderViewModel(var repository: MealsRepository): ViewModel() {

    private val TAG = "RecipeFinderViewModel"
    fun getViewIsLoaded(){


        viewModelScope.launch(Dispatchers.IO) {
            Log.d(TAG, "***************that's weird***************")
            val data = repository.fetchFinderData("Pasta")
            Log.d(TAG, "***************that's weird***************")
            Log.d(TAG, data.toString())
        }





    }



}
