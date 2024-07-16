package com.akshaysingh8700.threadsclone.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.akshaysingh8700.threadsclone.R
import com.akshaysingh8700.threadsclone.navigation.Routes
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navHost: NavHostController) {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (image) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "brand logo",
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(240.dp)
        )
    }

    LaunchedEffect(true) {
        delay(3000)

        if(Firebase.auth.currentUser != null){
            navHost.navigate(Routes.BottomNav.route){
                popUpTo(navHost.graph.startDestinationId)
                launchSingleTop = true
            }
        }
        else{
            navHost.navigate((Routes.Login.route)){
                popUpTo(navHost.graph.startDestinationId)
                launchSingleTop = true
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    SplashScreen(navHost = NavHostController(LocalContext.current))
}