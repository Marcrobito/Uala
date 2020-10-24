package com.jamadev.mealfinder.recipefinder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamadev.mealfinder.repository.MealsRepository
import com.jamadev.mealfinder.repository.Repository
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeFinderViewModel: ViewModel(), FinderVM {


    val repository: MealsRepository = Repository()

    init {

    }

    fun getViewIsLoaded(){
        repository.setFinderViewModel(this, this.viewModelScope )
        val data = viewModelScope.launch {
            repository.fetchFinderData("Pasta")
        }

    }



}

interface FinderVM{

}