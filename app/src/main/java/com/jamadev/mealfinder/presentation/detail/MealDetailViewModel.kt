package com.jamadev.mealfinder.presentation.detail

import android.util.Log
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

private const val TAG = "MealDetailViewModel"

@Singleton
class MealDetailViewModel(private val repository: MealsRepository):ViewModel() {

    private val _meal = MutableLiveData<Meal>()
    val meal : LiveData<Meal> get() = _meal

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> get() = _showLoading

    init {
        _showLoading.value = false
    }

    fun idIsSet(id:String){
        Log.d(TAG, id)
        _showLoading.value = true
        viewModelScope.launch {
            _meal.value  = withContext(Dispatchers.IO){
                repository.fetchMealData(id.toInt()).meals[0]
            }
            Log.d(TAG, _meal.value.toString())
            _showLoading.value = false
        }
    }



}