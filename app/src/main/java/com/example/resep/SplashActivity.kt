package com.example.resep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import com.example.resep.entities.Category
import com.example.resep.interfaces.GetDataService
import com.example.resep.retrofitclient.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val btnGetStarted : Button = findViewById(R.id.btnGetStarted)
        btnGetStarted.setOnClickListener {
            var intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    // category fun to get data from api using retrofit
    fun getCategories(){
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : Callback<List<Category>>{
            override fun onResponse(
                call: Call<List<Category>>,
                response: Response<List<Category>>
            ) {
                insertDataIntoRoomDb(response.body())
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {

                val loader: ProgressBar = findViewById(R.id.loader)
                loader.visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity,"Something went wrong", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun insertDataIntoRoomDb(category: List<Category>?){

    }
}