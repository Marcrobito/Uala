package com.jamadev.mealfinder.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.jamadev.mealfinder.App
import com.jamadev.mealfinder.repository.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

private const val TAG = "RandomMealService"

class RandomMealService: Service() {

    @Inject
    lateinit var repository: MealsRepository

    override fun onCreate() {
        super.onCreate()
        (application as App).getComponent().inject(this)
        val serviceTimer = ServiceTimer()
        val timer = Timer()
        timer.schedule(serviceTimer, 0, 30000)
        Log.d(TAG, "Service was created")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    companion object{
        const val ACTION = "RandomMealService"
    }

    inner class ServiceTimer:TimerTask(){
        override fun run() {
            GlobalScope.launch(Dispatchers.Main) {
                val meal = withContext(Dispatchers.IO){
                    repository.fetchRandomMeal().meals[0]
                }
                if(meal != null ){
                    val i = Intent(ACTION)
                    i.putExtra("mealId", meal.idMeal)
                    i.putExtra("meal", meal.strMeal)
                    i.putExtra("thumb", meal.strMealThumb)
                    sendBroadcast(i)
                    Log.d(TAG, meal.strMeal)
                }
            }
        }

    }
}