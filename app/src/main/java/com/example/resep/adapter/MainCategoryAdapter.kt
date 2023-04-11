package com.example.resep.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target
import com.example.resep.R
import com.example.resep.entities.CategoryItems

class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var ctx: Context? = null
    var arrMainCategory = ArrayList<CategoryItems>()
    class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var dishName : TextView
        var img_dish : ImageView

        init {
            dishName = view.findViewById(R.id.tv_dish_name)
//            img_dish = view.findViewById(R.id.img_dish)
            img_dish = view.findViewById(R.id.img_dish)
        }
    }

    fun setData(arrData : List<CategoryItems>){
        arrMainCategory = arrData as ArrayList<CategoryItems>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category, parent, false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {

        holder.dishName.text = arrMainCategory[position].strcategory

        // use glid to show images
        Glide.with(ctx!!).load(arrMainCategory[position].strcategorythumb).into(holder.img_dish)

    }



}