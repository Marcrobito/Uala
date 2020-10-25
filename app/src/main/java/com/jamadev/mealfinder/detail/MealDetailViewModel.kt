package com.jamadev.mealfinder.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jamadev.mealfinder.models.Meal
import com.jamadev.mealfinder.repository.MealsRepository
import javax.inject.Singleton

@Singleton
class MealDetailViewModel(repository: MealsRepository):ViewModel() {

    private val _meal = MutableLiveData<Meal>()
    val meal : LiveData<Meal> get() = _meal

    fun idIsSet(id:String){

    }



}