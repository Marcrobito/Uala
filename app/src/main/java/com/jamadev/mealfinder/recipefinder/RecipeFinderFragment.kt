package com.jamadev.mealfinder.recipefinder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jamadev.mealfinder.R
import com.jamadev.mealfinder.base.BaseFragment
import java.util.logging.Logger


class RecipeFinderFragment : BaseFragment() {

    private val TAG = "RecipeFinderFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_finder, container, false)
    }


}