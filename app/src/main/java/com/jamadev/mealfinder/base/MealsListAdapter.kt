package com.jamadev.mealfinder.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jamadev.mealfinder.databinding.ItemRecipeBinding
import com.jamadev.mealfinder.models.Meal


class MealsListAdapter(private val meals: List<Meal>) :RecyclerView.Adapter<MealsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemRecipeBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(meals[position])
        holder.bind(meals[position])
    }


    override fun getItemCount() = meals.size


    class ViewHolder(private val binding: ItemRecipeBinding) :RecyclerView.ViewHolder(binding.root) {

        fun bind(meal: Meal){
            binding.meal = meal
        }

    }


}