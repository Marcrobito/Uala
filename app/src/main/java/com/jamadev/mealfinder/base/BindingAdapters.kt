package com.jamadev.mealfinder.base

import android.media.Image
import android.view.View
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