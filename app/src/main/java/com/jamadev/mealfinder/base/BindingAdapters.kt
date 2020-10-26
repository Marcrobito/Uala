package com.jamadev.mealfinder.base

import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jamadev.mealfinder.models.Meal
import com.jamadev.mealfinder.models.MealsAdapterObject


@BindingAdapter("visible")
fun View.bindVisible(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("url")
fun ImageView.loadUrl(url: String?) {
    if (url != null){
        Glide.with(this).load(url).into(this)
    }
}

@BindingAdapter("meals_adapter")
fun RecyclerView.setMealsAdapter(mealsAdapterObject: MealsAdapterObject?){
    if(mealsAdapterObject != null){
        val adapter = MealsListAdapter(mealsAdapterObject.meals, mealsAdapterObject.listener)
        setAdapter(adapter)
    }
}

//TODO test this
@BindingAdapter("web_url")
fun WebView.loadUrl(url: String?) {
    Log.d("MealDetailViewModel", url ?: "dou'h")
    if (url != null){
        loadUrl(url)
    }
}