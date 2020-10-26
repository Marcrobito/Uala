package com.jamadev.mealfinder.presentation.finder

import android.content.BroadcastReceiver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jamadev.mealfinder.base.OnMealSelectedListener
import com.jamadev.mealfinder.models.Meal
import com.jamadev.mealfinder.models.MealsAdapterObject
import com.jamadev.mealfinder.models.ReducedMeal
import com.jamadev.mealfinder.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Singleton

private const val TAG = "RecipeFinderViewModel"

@Singleton
class RecipeFinderViewModel(var repository: MealsRepository) : ViewModel() {

    private val _randomMeal = MutableLiveData<ReducedMeal>()
    val randomMeal: LiveData<ReducedMeal> get() = _randomMeal

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> get() = _showLoading

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> get() = _message

    private var listener:OnMealSelectedListener? = null

    private val _mealsAdapterObject = MutableLiveData<MealsAdapterObject>()
    val mealsAdapterObject : LiveData<MealsAdapterObject> get() = _mealsAdapterObject

    init {
        _showLoading.value = false
        _message.value = ""
    }

    fun setListener(listener:OnMealSelectedListener?){
        this.listener= listener
    }

    fun findRecipeButtonClicked(queryString: String) {
        _message.value = ""
        _showLoading.value = true
        viewModelScope.launch {
            val data: List<Meal>? = withContext(Dispatchers.IO) {
                repository.fetchFinderData(queryString).meals
            }
            _showLoading.value = false
            if (data == null) {
                _message.value = "The recipe was not found, try another search"
            } else if(listener != null) {
                _mealsAdapterObject.value = MealsAdapterObject(data, listener!!)
            }
        }
    }

    fun broadCastReceived(meal: ReducedMeal) {
        if (meal.id != null) _randomMeal.value = meal
    }


}
