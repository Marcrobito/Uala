package com.jamadev.mealfinder.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import java.lang.Exception

private const val TAG =  "RandomMealReceiver"

class RandomMealReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            val action = intent?.action
            Log.d(TAG, action?:"fail" )
        }catch (e:Exception) {
            Log.e(TAG, e.toString() )
        }
    }
}