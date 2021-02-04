package com.example.hwanimations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hwanimations.databinding.RecipeListItemBinding

class RecipeAdapter(private val recipes: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private var callback: (binding: RecipeListItemBinding, recipe: Recipe) -> (Unit) = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            RecipeListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    fun setCallback(callback: (binding: RecipeListItemBinding, recipe: Recipe) -> Unit) {
        this.callback = callback
    }

    inner class RecipeViewHolder(private val binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.apply {
                tvRecipeName.text = recipe.name
                tvIngredients.text = recipe.ingredients
                ivRecipeImage.setImageResource(recipe.picture)
                root.setOnClickListener {
                    callback(this, recipe)
                }
            }
        }
    }

}

