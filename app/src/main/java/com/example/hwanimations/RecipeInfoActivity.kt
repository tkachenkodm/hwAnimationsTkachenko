package com.example.hwanimations

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hwanimations.databinding.RecipeInfoActivityBinding

class RecipeInfoActivity : AppCompatActivity() {
    private lateinit var binding: RecipeInfoActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RecipeInfoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setRecipeData()
    }


    private fun setRecipeData() {
        val recipe = intent.getParcelableExtra<Recipe>(RECIPE_KEY)

        recipe?.apply {
            binding.tvInfoRecipeName.text = name
            binding.tvInfoRecipeIngredients.text = ingredients
            binding.ivImageRecipe.setImageResource(picture)
        }


    }

    companion object {
        private const val RECIPE_KEY = "extra_recipe"

        fun newIntent(context: Context, recipe: Recipe): Intent {
            val intent = Intent(context, RecipeInfoActivity::class.java)
            intent.putExtra(RECIPE_KEY, recipe)

            return intent
        }
    }
}