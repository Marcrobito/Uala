package com.jamadev.mealfinder.presentation.detail

import com.jamadev.mealfinder.repository.MealsRepository
import dagger.Module
import dagger.Provides

@Module
class MealDetailModule {
    @Provides
    fun providesMealDetailViewModel(repository: MealsRepository) = MealDetailViewModel(repository)
}