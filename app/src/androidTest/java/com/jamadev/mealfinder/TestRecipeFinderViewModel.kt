package com.jamadev.mealfinder

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jamadev.mealfinder.presentation.finder.RecipeFinderViewModel
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
class TestRecipeFinderViewModel {

    private val mockRepository = MockRepository()
    private val spiedVieModel = RecipeFinderViewModel(mockRepository)


    @Test
    fun check(){
        
    }
}