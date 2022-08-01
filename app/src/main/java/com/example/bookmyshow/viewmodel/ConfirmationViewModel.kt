package com.example.bookmyshow.viewmodel

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ConfirmationViewModel @Inject constructor() : ViewModel() {
    val movieName = "World War III"
    val theaterName = "PVR Mumbai"
    val theaterAddress = "RGB Road, Gulchowk, Navi Mumbai"
    val imageBanner =
        "https://prd-rteditorial.s3.us-west-2.amazonaws.com/wp-content/uploads/2022/01/20131619/Most_Anticipated_Movies_2023_Header.jpg"
}