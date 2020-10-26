package com.jamadev.mealfinder.presentation.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jamadev.mealfinder.App
import com.jamadev.mealfinder.base.BaseFragment
import com.jamadev.mealfinder.databinding.FragmentMealDetailBinding
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

        showBackButton(true)

        binding = FragmentMealDetailBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this



        if (mealId != null) {
            viewModel.idIsSet(mealId!!)
        } else {
            //TODO implement a onFailure method
        }
        return binding.root
    }
}