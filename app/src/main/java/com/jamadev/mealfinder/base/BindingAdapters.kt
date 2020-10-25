package com.jamadev.mealfinder.base

import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("visible")
fun View.bindVisible(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("url")
fun ImageView.loadUrl(url:String){
    Glide.with(this).load(url).into(this)
}

@BindingAdapter("web_url")
fun WebView.loadUrl(url:String?){
    Log.d("MealDetailViewModel", url?:"dou'h")
    url?:loadUrl(url)
}