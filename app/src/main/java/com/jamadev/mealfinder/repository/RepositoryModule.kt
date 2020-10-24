package com.jamadev.mealfinder.repository

import com.jamadev.mealfinder.network.RecipesApi
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesMealsRepository(network:RecipesApi):MealsRepository = Repository(network)

}