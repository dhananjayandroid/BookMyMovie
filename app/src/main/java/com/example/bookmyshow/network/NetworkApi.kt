package com.example.bookmyshow.network

import com.example.bookmyshow.model.MovieList
import com.example.bookmyshow.model.TheatersList
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {
    /**
     * Get the list of the Movies from the API
     */
    @GET("v1/getMovies")
    suspend fun getMovies() : Response<List<MovieList>>

    /**
     * Get the list of the Theaters from the API
     */
    @GET("v1/getCinemas")
    suspend fun getTheaters() : Response<List<TheatersList>>
}
