package com.example.bookmyshow.model

import com.google.gson.annotations.SerializedName

data class TheatersList(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("avatar")
    var image: String? = null
)