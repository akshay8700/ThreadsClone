package com.akshaysingh8700.threadsclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.akshaysingh8700.threadsclone.screens.AddThreads
import com.akshaysingh8700.threadsclone.screens.BottomNav
import com.akshaysingh8700.threadsclone.screens.HomeScreen
import com.akshaysingh8700.threadsclone.screens.Login
import com.akshaysingh8700.threadsclone.screens.Notification
import com.akshaysingh8700.threadsclone.screens.Profile
import com.akshaysingh8700.threadsclone.screens.Register
import com.akshaysingh8700.threadsclone.screens.SearchScreen
import com.akshaysingh8700.threadsclone.screens.SplashScreen


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Splash.route ) {
        composable(Routes.Splash.route) {
            SplashScreen(navController)
        }
        composable(Routes.Home.route) {
            HomeScreen()
        }
        composable(Routes.Notification.route) {
            Notification()
        }
        composable(Routes.AddThreads.route) {
            AddThreads()
        }
        composable(Routes.Profile.route) {
            Profile()
        }
        composable(Routes.Search.route) {
            SearchScreen()
        }
        composable(Routes.BottomNav.route) {
            BottomNav(navController)
        }
        composable(Routes.Login.route) {
            Login(navController)
        }
        composable(Routes.Register.route) {
            Register(navController)
        }
    }
}