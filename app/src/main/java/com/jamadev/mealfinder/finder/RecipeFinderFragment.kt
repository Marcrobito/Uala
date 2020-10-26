package com.jamadev.mealfinder.finder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jamadev.mealfinder.App
import com.jamadev.mealfinder.R
import com.jamadev.mealfinder.base.BaseFragment
import com.jamadev.mealfinder.base.MealsListAdapter
import com.jamadev.mealfinder.base.OnMealSelectedListener
import com.jamadev.mealfinder.base.loadUrl
import com.jamadev.mealfinder.databinding.FragmentRecipeFinderBinding
import com.jamadev.mealfinder.service.RandomMealService
import javax.inject.Inject


private const val TAG = "RecipeFinderFragment"

class RecipeFinderFragment : BaseFragment(), OnMealSelectedListener {

    @Inject
    lateinit var viewModel: RecipeFinderViewModel
    private lateinit var binding: FragmentRecipeFinderBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as App).getComponent().inject(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRecipeFinderBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.meals.observe(viewLifecycleOwner) {
            val adapter = MealsListAdapter(it, this)
            val manager = LinearLayoutManager(this.activity, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.layoutManager = manager
            binding.recyclerView.adapter = adapter
        }

        val filter = IntentFilter()
        filter.addAction(RandomMealService.ACTION)
        val receiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                binding.include.mealTitle.text =  intent.getStringExtra("meal")?:""
                if(  intent.getStringExtra("thumb") != null){
                    binding.include.imageView.loadUrl(intent.getStringExtra("thumb")!!)
                }
                binding.include.id=intent.getStringExtra("mealId")
                binding.include.root.setOnClickListener {
                    onMealSelected(intent.getStringExtra("mealId")!!)
                }
            }
        }

        activity?.registerReceiver(receiver, filter)
        return binding.root
    }

    override fun onMealSelected(mealId: String) {
        val bundle = bundleOf("mealId" to mealId)
        binding.root.findNavController().navigate(R.id.presentMealDetail, bundle)
    }


}