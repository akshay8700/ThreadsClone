package com.akshaysingh8700.threadsclone.navigation

sealed class Routes(val route: String){
    object Splash: Routes("splash")
    object Home: Routes("home")
    object Search: Routes("search")
    object Notification: Routes("notification")
    object Profile: Routes("profile")
    object AddThreads: Routes("add_threads")
    object BottomNav: Routes("bottom_nav")
    object Login: Routes("login")
    object Register: Routes("register")
}