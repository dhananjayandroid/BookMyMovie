package com.example.bookmyshow.inject

import android.content.Context
import com.example.bookmyshow.BaseApplication
import com.example.bookmyshow.view.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule:: class])
interface ApplicationComponent {
    fun inject(application: BaseApplication)

    fun inject(mainActivity:MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

}