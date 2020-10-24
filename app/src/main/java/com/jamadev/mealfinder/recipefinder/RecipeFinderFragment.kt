package com.jamadev.mealfinder.recipefinder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.jamadev.mealfinder.R
import com.jamadev.mealfinder.base.BaseFragment
import java.util.logging.Logger


class RecipeFinderFragment : BaseFragment() {

    private val TAG = "RecipeFinderFragment"

    private lateinit var viewModel:RecipeFinderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get()

        viewModel.getViewIsLoaded()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_finder, container, false)
    }


}