package com.example.resep

import RecipeDatabase
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resep.adapter.MainCategoryAdapter
import com.example.resep.adapter.SubCategoryAdapter
import com.example.resep.entities.CategoryItems
import com.example.resep.entities.Recipes
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity(){
    var arrMainCategory = ArrayList<CategoryItems>()
    var arrSubCategory = ArrayList<Recipes>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getDataFromDb()

        arrSubCategory.add(Recipes(1, "Beef and Mustard pie"))
        arrSubCategory.add(Recipes(2, "Chicken and mushroom hotpot"))
        arrSubCategory.add(Recipes(3, "Banana pancakes"))
        arrSubCategory.add(Recipes(4, "Kapsalon"))

        subCategoryAdapter.setData(arrSubCategory)



        findViewById<RecyclerView>(R.id.rv_sub_category).apply {
            layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = subCategoryAdapter
        }
    }

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()
                mainCategoryAdapter.setData(arrMainCategory)
                findViewById<RecyclerView>(R.id.rv_main_category).apply {
                    layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
                    adapter = mainCategoryAdapter
                }
            }
        }
    }
}
