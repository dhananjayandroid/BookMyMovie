package com.example.bookmyshow.model

import com.google.gson.annotations.SerializedName

data class MovieList constructor(var id:Int?){
    @SerializedName("title"     ) var title     : String?           = null
    @SerializedName("year"      ) var year      : String?           = null
    @SerializedName("runtime"   ) var runtime   : String?           = null
    @SerializedName("genres"    ) var genres    : ArrayList<String> = arrayListOf()
    @SerializedName("director"  ) var director  : String?           = null
    @SerializedName("actors"    ) var actors    : String?           = null
    @SerializedName("plot"      ) var plot      : String?           = null
    @SerializedName("posterUrl" ) var posterUrl : String?           = null
}
