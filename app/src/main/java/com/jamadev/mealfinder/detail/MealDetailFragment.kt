package com.jamadev.mealfinder.detail

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jamadev.mealfinder.App
import com.jamadev.mealfinder.R
import com.jamadev.mealfinder.base.BaseFragment
import com.jamadev.mealfinder.databinding.FragmentMealDetailBinding
import com.jamadev.mealfinder.databinding.FragmentRecipeFinderBinding
import javax.inject.Inject

private const val MEAL_ID = "mealId"
private const val TAG = "MealDetailFragment"

class MealDetailFragment : BaseFragment() {


    @Inject
    lateinit var viewModel: MealDetailViewModel

    private lateinit var binding: FragmentMealDetailBinding
    private var mealId: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as App).getComponent().inject(this)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mealId = it.getString(MEAL_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMealDetailBinding.inflate(inflater, container, false)
        //binding.mealDetail.viewModel = viewModel
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        if (mealId != null) {
            viewModel.idIsSet(mealId!!)
        }else{
            Log.d(TAG, "----------------------");
        }

        return binding.root
    }

}