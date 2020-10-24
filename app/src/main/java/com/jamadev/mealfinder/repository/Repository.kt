package com.jamadev.mealfinder.repository

import android.util.Log
import com.jamadev.mealfinder.models.Meals
import com.jamadev.mealfinder.network.RecipesApi
import com.jamadev.mealfinder.recipefinder.FinderVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response


class Repository : MealsRepository {

    @Inject
    lateinit var network:RecipesApi

    private var finderVM: FinderVM? = null
    private lateinit var scope:CoroutineScope

    override fun setFinderViewModel(finderVM: FinderVM,  scope:CoroutineScope) {
        this.scope = scope
        this.finderVM = finderVM
    }

    override suspend fun fetchFinderData(query: String):Meals? {

        var meals = null
        scope.launch(Dispatchers.IO) {
            val call = network.getMeals(query)
                suspend {

                    call.enqueue( object : Callback<Meals> {
                    override fun onFailure(call: Call<Meals>, t: Throwable) {

                    }

                    override fun onResponse(call: Call<Meals>, response: Response<Meals>) {
                        Log.d("trye", response?.body().toString())
                        meals = null
                    }

                })
            }

        }
        return meals
    }


}

