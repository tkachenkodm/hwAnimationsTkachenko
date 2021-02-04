package com.example.hwanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hwanimations.databinding.ActivityMainBinding
import androidx.core.util.Pair
import androidx.core.app.ActivityOptionsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecyclerAdapter()
    }

    private fun setRecyclerAdapter() {
        val adapter = RecipeAdapter(recipeList)

        adapter.setCallback { binding, recipe ->

            val intent = RecipeInfoActivity.newIntent(this, recipe)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                Pair.create(binding.ivRecipeImage, binding.ivRecipeImage.transitionName),
                Pair.create(binding.tvRecipeName, binding.tvRecipeName.transitionName),
                Pair.create(binding.tvIngredients, binding.tvIngredients.transitionName)
            )

            startActivity(intent, options.toBundle())
        }

        binding.rvRecipeList.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    companion object {
        val recipeList = listOf(
            Recipe("Cake", "Flour, Eggs", R.drawable.cake),
            Recipe("Pancake", "Flour, Eggs, Butter", R.drawable.pancake),
            Recipe("Pizza", "Flour, Eggs, Cheese", R.drawable.pizza),
            Recipe("Bread", "Flour, Eggs, Water", R.drawable.bread)
        )
    }
}