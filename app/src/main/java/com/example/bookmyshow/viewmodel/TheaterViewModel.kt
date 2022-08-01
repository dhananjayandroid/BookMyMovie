package com.example.bookmyshow.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookmyshow.model.MovieList
import com.example.bookmyshow.model.TheatersList
import com.example.bookmyshow.network.RetrofitClient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class TheaterViewModel@Inject constructor() : ViewModel() {

    private val _theatersList = MutableLiveData<List<TheatersList>>()
    val theaters: LiveData<List<TheatersList>> = _theatersList

    val progressLiveData =  MutableLiveData<Boolean>()

    private fun getTheaters() {
        val theatersApi = RetrofitClient.getRetrofitApi()
        // launching a new coroutine
        viewModelScope.launch {
            progressLiveData.postValue(true)
            val result = theatersApi?.getTheaters()
            if (result != null && result.isSuccessful) {
                // Checking the results
                _theatersList.postValue(result.body())
                var json = Gson().toJson(result.body())

                val collectionType = object : TypeToken<List<MovieList?>?>() {}.type
                val lcs: List<TheatersList> = Gson()
                    .fromJson(json, collectionType) as List<TheatersList>

                lcs.forEachIndexed { index, theatersList ->
                    theatersList.name
                    println(theatersList.name)
                    println(theatersList.image)
                }
                Log.d("theaters data: ", result.body().toString())

                progressLiveData.postValue(false)
            }
        }
    }

    init {
        getTheaters()
    }
}
