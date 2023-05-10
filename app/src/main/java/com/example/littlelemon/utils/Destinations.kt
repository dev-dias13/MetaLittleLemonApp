package com.example.littlelemon.utils


// all destinations
interface Destinations{
    val route: String
}

object OnBoarding: Destinations {
    override val route = "OnBoarding"
}

object HomeScreen: Destinations {
    override val route = "Home"
}

object ProfileScreen: Destinations {
    override val route = "Profile"
}