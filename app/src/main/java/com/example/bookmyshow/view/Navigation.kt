package com.example.bookmyshow.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bookmyshow.view.ui.navigation.Screen
import com.example.bookmyshow.viewmodel.ConfirmationViewModel
import com.example.bookmyshow.viewmodel.LoginViewModel
import com.example.bookmyshow.viewmodel.OTPViewModel
import com.example.bookmyshow.viewmodel.TheaterViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            //    val component = DaggerLoginComponent.builder().build()
            val viewModel: LoginViewModel = LoginViewModel() /*daggerViewModel{
                component.getViewModel()
            }*/
            LoginScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screen.OTPScreen.route) {
            val viewModel: OTPViewModel = OTPViewModel()
            OTPScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screen.TheaterScreen.route) {
            val viewModel = TheaterViewModel()
            TheaterScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screen.ConfirmationScreen.route) {
            val viewModel = ConfirmationViewModel()
            ConfirmationScreen(navController = navController, viewModel = viewModel)
        }

        composable(route = Screen.ConfirmedScreen.route) {
            ConfirmedScreen(navController = navController)
        }
    }
}
