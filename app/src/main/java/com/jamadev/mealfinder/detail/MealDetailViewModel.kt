package com.jamadev.mealfinder.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamadev.mealfinder.models.Meal
import com.jamadev.mealfinder.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Singleton

@Singleton
class MealDetailViewModel(private val repository: MealsRepository):ViewModel() {

    private val _meal = MutableLiveData<Meal>()
    val meal : LiveData<Meal> get() = _meal

    fun idIsSet(id:String){
        viewModelScope.launch {
            _meal.value  = withContext(Dispatchers.IO){
                repository.fetchMealData(id)
            }
        }
    }



}