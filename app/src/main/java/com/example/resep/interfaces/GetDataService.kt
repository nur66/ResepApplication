package com.example.resep.interfaces

import com.example.resep.entities.Category
import retrofit2.Call
import retrofit2.http.GET

interface GetDataService {

    @GET("categories.php")
    fun getCategoryList(): Call<Category>
}