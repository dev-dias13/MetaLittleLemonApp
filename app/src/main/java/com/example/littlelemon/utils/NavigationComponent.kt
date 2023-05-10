package com.example.littlelemon.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.data.model.UserInfo
import com.example.littlelemon.ui.screen.OnBoarding
import com.example.littlelemon.ui.screen.ProfileScreen
import com.example.littlelemon.ui.screen.HomeScreen

@Composable
fun AppNavigation() {
    val context = LocalContext.current
    UserInfo.loadFromPreferences(context)

    val startDestination = if (UserInfo.isLoggedIn){
        HomeScreen.route
    } else {
        OnBoarding.route
    }

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination){

        composable(OnBoarding.route){
            OnBoarding(navController = navController)
        }

        composable(HomeScreen.route){
            HomeScreen(navController = navController)
        }

        composable(ProfileScreen.route){
            ProfileScreen(navController = navController)
        }
    }
}