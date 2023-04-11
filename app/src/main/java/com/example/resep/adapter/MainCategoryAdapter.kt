package com.example.resep.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resep.R
import com.example.resep.entities.Recipies

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var arrMainCategory = ArrayList<Recipies>()
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    fun setData(arrData : List<Recipies>){
        arrMainCategory = arrData as ArrayList<Recipies>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category, parent, false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {


    }



}