package com.example.bookmyshow.view.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bookmyshow.BaseApplication
import com.example.bookmyshow.view.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as BaseApplication).applicationComponent.inject(this)

        setContent {
            Navigation()
        }
    }
}

