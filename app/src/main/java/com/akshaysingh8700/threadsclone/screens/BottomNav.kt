package com.akshaysingh8700.threadsclone.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.akshaysingh8700.threadsclone.model.BottomNavItem
import com.akshaysingh8700.threadsclone.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav(navController: NavHostController) {
    val navController1 = rememberNavController()

    Scaffold(
        bottomBar = { MyBottomBar(navController1) }
    ) {
        innerPadding ->
        NavHost(
            navController = navController1,
            startDestination = Routes.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.Home.route){
                HomeScreen()
            }
            composable(Routes.Splash.route) {
                SplashScreen(navController1)
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
        }
    }
}

@Composable
fun MyBottomBar(navController1: NavHostController) {

    val backStackEntry = navController1.currentBackStackEntryAsState()

    val list = listOf(
        BottomNavItem(
            "Home",
            Routes.Home.route,
            Icons.Filled.Home
        ),
        BottomNavItem(
            "Search",
            Routes.Search.route,
            Icons.Filled.Search
        ),
        BottomNavItem(
            "Add Threads",
            Routes.AddThreads.route,
            Icons.Filled.Add
        ),
        BottomNavItem(
            "Notification",
            Routes.Notification.route,
            Icons.Filled.Notifications
        ),
        BottomNavItem(
            "Profile",
            Routes.Profile.route,
            Icons.Filled.Person
        )
    )

    BottomAppBar {
        list.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController1.navigate(it.route) {
                        popUpTo(navController1.graph.findStartDestination().id) {
                            saveState = true
                        }
                    }
                },
                icon = {
                    Icon(imageVector = it.icon, contentDescription = it.title)
                }
            )
        }
    }

}