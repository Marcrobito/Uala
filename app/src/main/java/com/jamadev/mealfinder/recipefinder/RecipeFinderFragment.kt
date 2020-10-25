package com.jamadev.mealfinder.recipefinder

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.jamadev.mealfinder.App
import com.jamadev.mealfinder.R
import com.jamadev.mealfinder.base.BaseFragment
import com.jamadev.mealfinder.base.MealsListAdapter
import com.jamadev.mealfinder.databinding.FragmentRecipeFinderBinding
import com.jamadev.mealfinder.models.Meal
import java.util.logging.Logger
import javax.inject.Inject


class RecipeFinderFragment : BaseFragment() {

    private val TAG = "RecipeFinderFragment"

    @Inject
    lateinit var viewModel:RecipeFinderViewModel
    private lateinit var binding: FragmentRecipeFinderBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as App).getComponent().inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRecipeFinderBinding.inflate(inflater,  container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.meals.observe(viewLifecycleOwner){
            val adapter = MealsListAdapter(it)
            val manager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.layoutManager = manager
            binding.recyclerView.adapter = adapter
        }

        return binding.root
    }


}