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

    fun getViewIsLoaded(){
        //repository.setFinderViewModel(this, this.viewModelScope )
        val data = viewModelScope.launch(Dispatchers.IO) {
            repository.fetchFinderData("Pasta")
        }

        Log.d("data", data.toString())

    }



}
