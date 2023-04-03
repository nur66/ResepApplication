//package com.example.resep.dao
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.resep.entities.Recipies
//
//@Dao
//interface RecipieDao {
//
//    @get:Query("SELECT * FROM recipes ORDER BY id DESC")
//    val allRecipes: List<Recipies>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertRecipe(recipies: Recipies)
//}