package com.jamadev.mealfinder.repository

import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun providesMealsRepository():MealsRepository = Repository()

}