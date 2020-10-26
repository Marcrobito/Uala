package com.jamadev.mealfinder.presentation.finder

import com.jamadev.mealfinder.repository.MealsRepository
import dagger.Module
import dagger.Provides

@Module
class RecipeFinderModule {
    @Provides
    fun providesRecipeFinderViewModel( repository : MealsRepository) = RecipeFinderViewModel(repository)
}