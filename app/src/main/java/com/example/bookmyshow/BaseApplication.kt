package com.example.bookmyshow

import android.app.Application
import com.example.bookmyshow.inject.ApplicationComponent
import com.example.bookmyshow.inject.DaggerApplicationComponent

class BaseApplication : Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initDaggerIntegration()
    }

    private fun initDaggerIntegration() {
        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}
