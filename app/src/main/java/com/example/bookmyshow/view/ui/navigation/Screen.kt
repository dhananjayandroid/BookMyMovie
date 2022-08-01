package com.example.bookmyshow.view.ui.navigation

sealed class Screen(val route:String){
    object SplashScreen: Screen("splash_screen")
    object LoginScreen: Screen("login_screen")
    object OTPScreen: Screen("otp_screen")
    object TheaterScreen: Screen("theater_screen")
    object ConfirmationScreen: Screen("confirmation_screen")
    object ConfirmedScreen: Screen("confirmed_screen")
}
