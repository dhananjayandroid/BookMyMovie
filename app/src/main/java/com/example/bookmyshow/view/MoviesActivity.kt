package com.example.bookmyshow.view

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bookmyshow.R
import com.example.bookmyshow.network.NetworkApi
import com.example.bookmyshow.network.RetrofitClient
import com.example.bookmyshow.model.MovieList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MoviesActivity : AppCompatActivity() {
    lateinit var txtData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_movies)
        txtData = findViewById(R.id.txtData)
        getMovies()
    }

/*    fun getUserList() {
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(MovieApi::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getMovies()
                if (response.isSuccessful()) {
                    var json = Gson().toJson(response.body())
                    if (response.body()?.genres?.size!! <= 0) {
                        Toast.makeText(
                            this@MoviesActivity,
                            "No Data ",
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        txtData.setText(json)
                    }

                    //new
                    *//* if(response?.body()!!.support.text.contains("Harshita")){
                         Toast.makeText(
                             this@MainActivity,
                             "Hello Retrofit",
                             Toast.LENGTH_LONG
                         ).show()
                     }*//*

                    // var getNEsteddata=response.body().data.get(0).suport.url

                } else {
                    Toast.makeText(
                        this@MoviesActivity,
                        response.errorBody().toString(),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }catch (Ex: Exception){
                Log.e("Error",Ex.localizedMessage)
            }
        }

    }*/

    fun getMovies(){
        val moviesApi = RetrofitClient.getRetrofitApi()
        // launching a new coroutine
        GlobalScope.launch {//viewModelScope.launch
            val result = moviesApi?.getMovies()
            if (result != null && result.isSuccessful) {
                // Checking the results
                var json = Gson().toJson(result.body())

                val collectionType = object : TypeToken<List<MovieList?>?>() {}.type
                val lcs: List<MovieList> = Gson()
                    .fromJson(json, collectionType) as List<MovieList>

                lcs.forEachIndexed {
                        index, movieList ->
                    movieList.title
                println(movieList.title)
                    println(movieList.posterUrl)


                }


                Log.d("ayush: ", result.body().toString())
            }
        }

    }



}