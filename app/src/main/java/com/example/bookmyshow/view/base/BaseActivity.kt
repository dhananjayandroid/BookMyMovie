package com.example.bookmyshow.view.base

import androidx.appcompat.app.AppCompatActivity
import com.example.bookmyshow.viewmodel.ViewModelFactory

import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory



}