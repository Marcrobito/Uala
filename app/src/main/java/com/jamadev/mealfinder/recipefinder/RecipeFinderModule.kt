package com.jamadev.mealfinder.recipefinder

import com.jamadev.mealfinder.repository.MealsRepository
import com.jamadev.mealfinder.repository.Repository
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class RecipeFinderModule {
    @Provides
    fun providesRecipeFinderViewModel( repository : MealsRepository) = RecipeFinderViewModel(repository)
}